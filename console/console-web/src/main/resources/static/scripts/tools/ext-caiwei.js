/**
 * @memo 动态加载JavaScript文件
 */
var Caiwei = Caiwei || {};
Caiwei.JsLoader = function() {
   this.load = function(url) {
		var me = this,
			scripts = document.getElementsByTagName("script"),
			len = scripts.length,
			i, script, head;
		for (i=0; i<len; i++) {
			if (scripts[i].src && scripts[i].src.indexOf(url) != -1) {
				me.onSuccess();
				return;
			}
		}
		script = document.createElement("script");
		script.type = "text/javascript";
		script.src = url;
		head = document.getElementsByTagName("head")[0];
		try {
			head.appendChild(script);
			script.onload = script.onreadystatechange = function() {
				if (script.readyState && script.readyState != 'loaded' && script.readyState != 'complete') return;
				script.onreadystatechange = script.onload = null; 
				me.onSuccess();
			}
		} catch(e) {
			//head.removeChild(script);
			if(typeof(me.onFailure) == 'function') {
				me.onFailure();
			} else if(Ext != 'undefined' && Ext != null) {
				Ext.MessageBox.alert("提示", "JavaScript文件加载失败.");
			}
		}
	}
}

// trim方法在IE下报错
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}  
/**
 * 修改date对象数据的JSON提交方式
 * @param date 日期对象
 * @returns dateTime 日期对象的长整型数
 */
Ext.JSON.encodeDate = function(date) {
    var dateTime = date.getTime();
    return dateTime;
};


Ext.override(Ext.window.Window, {
    constrain: true
});

/**
 * 修改Ajax的请求超时时间，方便Debug
 * 仅适用于开发环境
 */
Ext.data.proxy.Server.override({
	timeout: 3000000
});


/**
 * 修改combox下拉后的页面中的分页
 */
/*Ext.view.BoundList.override({
	createPagingToolbar: function() {
        return Ext.widget('simplepaging', {
            id: this.id + '-paging-toolbar',
            pageSize: this.pageSize,
            store: this.store,
            border: false
        });
    }
});*/

/**
*	修改默认提示框按钮的焦点
*	更改提示框中按钮的默认位置需更改源码Ext.window.MessageBox类中
*    buttonIds: [
*        'cancel', 'no', 'yes', 'ok'
*    ]
*/
Ext.override(Ext.window.MessageBox, {
    defaultFocus: 2
});



/**
 * 关闭Tab功能
 * @param tID 待关闭的tab id
*/
/*function removeTab(tID) {
	var tabPanel = Ext.getCmp('mainAreaPanel'),
		tab = Ext.getCmp(tID);
	if(tabPanel==null){
		return;
	}
	tabPanel.remove(tab, true);
}*/

/**
 * 新建Tab功能
 * @param tID 待打开的tab id
 * @param tText tab显示文本值
 * @param tLoc tab页面请求的URL
 * @param params 请求的参数
*/
/*function addTab() {
	var tID = arguments[0],
		tText = arguments[1],
		tLoc = arguments[2],
		tabPanel = Ext.getCmp('mainAreaPanel'),
		tab = Ext.getCmp(tID);
	if(tabPanel==null){
		return;
	}
	tabPanel.params = arguments[3];
	if(!tab) {
		tabPanel.add({
			id: tID,
			title: tText,
			layout: 'fit',
			closable: true,
			tabConfig: { width: 150 },
			cls: 'autoHeight',
			bodyCls: 'autoHeight',
			loader: {
				scripts: true,
				autoLoad: true,
				url: '../'+tLoc
			}
		});
		tabPanel.setActiveTab(tabPanel.child('#'+tID));
	} else {
		tabPanel.setActiveTab(tab);
	}
}*/

/**
 * 动态下拉框查询
 */
Ext.define('Caiwei.commonselector.DynamicComboSelector',{
	extend: 'Ext.form.ComboBox',
	alias: 'widget.dynamiccomboselector',
	triggerCls: Ext.baseCSSPrefix + 'form-search-trigger',
	listWidth: this.width,//下拉列表宽度，从外面传入
	multiSelect: false,//从外面传入
	isPaging: false,//是否要分页
	isEnterQuery: false,	//回车查询
	displayField: null,//显示的字段，从外面传入
	valueField: null,//提交时的字段,从外面传入
	showContent: null,//需要从外面传入如：showContent:'{deptName}&nbsp;&nbsp;{deptCode}'
	queryParam: null,//查询参数
	triggerAction: 'query',
	minChars:1,
	hideTrigger:false,
	listConfig: {
		getInnerTpl: function() {
			return this.up('combo').showContent;
		}
	},
	getValueModel: function(){
		var models = this.valueModels;
		if(Ext.isEmpty(models)&&models.length>0){
			return models[0];
		}else{
			return null;
		}
	},
	/*getChange: function(combo,newValue,oldValue){
		if(combo.isExpanded==true){
			combo.collapse();
		}
	},
	getKeyPress: function( combo, event, eOpts ){
		if(event.getKey() == event.ENTER){
			combo.store.loadPage(1,{
				scope: this,
				callback: function(records, operation, success) {
					if(records.length>0){
						combo.expand();
					}
				}
			});
		}
	},*/
	getBeforeLoad: function(store,operation,e){
		var me = this, searchParams = operation.getParams();
		if (Ext.isEmpty(searchParams)) {
			searchParams = {};
		}
		searchParams[me.queryParam] = me.rawValue;
		Ext.apply(store.proxy.extraParams, searchParams);  
	},
    initEvents: function() {
        var me = this;
        me.callParent(arguments);
		//判断是否是回车去查询
		//if(me.isEnterQuery==true){
			//me.mon(me, 'change', me.getChange, me);
			//me.mon(me, 'keypress', me.getKeyPress, me);
		//}
		me.mon(me.store, 'beforeLoad', me.getBeforeLoad, me);
    },
	initComponent:function(){
		var me = this;
		//列表宽度自定义
		me.on('expand', function(combo, eOpts ){
				combo.getPicker().minWidth=me.listWidth;
				combo.getPicker().setWidth(me.listWidth);
		});
		//判断是否要分页
		if(me.isPaging==true){
			me.pageSize = me.store.pageSize;
		}
		//判断下拉grid显示列
		if(me.showContent==null){
			me.showContent = '{'+me.displayField+'}';
		}
		//判断是否是回车去查询
		if(me.isEnterQuery==true){
			me.enableKeyEvents = true;
			me.queryDelay = 1000000;//此处为了使回车时间生效
		}
		this.callParent(arguments);
	}
});	
/**
 * 动态下拉多选框查询
 */
Ext.define('Caiwei.commonselector.DynamicMultiSelectComboSelector',{
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.dynamicmulticomboselector',
	triggerCls: Ext.baseCSSPrefix + 'form-search-trigger',
	listWidth: this.width,//下拉列表宽度，从外面传入
	isPaging: false,//是否要分页
	isEnterQuery: false,	//回车查询
	triggerOnClick: false,//得到焦点时，不进行下拉
	multiSelect: true,
	minChars:1,
	listConfig: {
		getInnerTpl: function() {
			return this.up('combo').showContent;
		}
	},
	onKeyPress:function(e, t){
		var me = this;
		if(e.getKey() == e.ENTER){
			me.doRawQuery();
		}else{
			me.collapse();
		}
	},
	initEvents: function(){
		var me = this;
        me.callParent(arguments);
        if (me.enableKeyEvents&&me.isEnterQuery) {
			me.mon(me.inputEl, 'keypress', me.onKeyPress, me);
        }
	},
	initComponent:function(){
		var me = this;
		//列表宽度自定义
		me.on('expand', function(combo, eOpts ){
				combo.getPicker().minWidth=me.listWidth;
				combo.getPicker().setWidth(me.listWidth);
		});
		//判断是否要分页
		if(me.isPaging){
			me.pageSize = me.store.pageSize;
		}
		//判断是否是回车去查询
		if(me.isEnterQuery){
			me.enableKeyEvents = true;
			//me.queryDelay = 1000000;//此处为了使回车时间生效
		}
		//判断下拉grid显示列
		if(me.showContent==null){
			me.showContent = '{'+me.displayField+'}';
		}
		this.callParent(arguments);
	}
});



/**
 * A control that allows selection of multiple items in a list.
 */
Ext.define('Ext.ux.form.MultiSelect', {
    
    extend: 'Ext.form.FieldContainer',
    
    mixins: [
        'Ext.util.StoreHolder',
        'Ext.form.field.Field'
    ],
    
    alternateClassName: 'Ext.ux.Multiselect',
    alias: ['widget.multiselectfield', 'widget.multiselect'],
    
    requires: ['Ext.panel.Panel', 'Ext.view.BoundList', 'Ext.layout.container.Fit'],
    
    uses: ['Ext.view.DragZone', 'Ext.view.DropZone'],
    
    layout: 'anchor',
    
    /**
     * @cfg {String} [dragGroup=""] The ddgroup name for the MultiSelect DragZone.
     */

    /**
     * @cfg {String} [dropGroup=""] The ddgroup name for the MultiSelect DropZone.
     */
    
    /**
     * @cfg {String} [title=""] A title for the underlying panel.
     */
    
    /**
     * @cfg {Boolean} [ddReorder=false] Whether the items in the MultiSelect list are drag/drop reorderable.
     */
    ddReorder: false,

    /**
     * @cfg {Object/Array} tbar An optional toolbar to be inserted at the top of the control's selection list.
     * This can be a {@link Ext.toolbar.Toolbar} object, a toolbar config, or an array of buttons/button configs
     * to be added to the toolbar. See {@link Ext.panel.Panel#tbar}.
     */

    /**
     * @cfg {String} [appendOnly=false] `true` if the list should only allow append drops when drag/drop is enabled.
     * This is useful for lists which are sorted.
     */
    appendOnly: false,

    /**
     * @cfg {String} [displayField="text"] Name of the desired display field in the dataset.
     */
    displayField: 'text',

    /**
     * @cfg {String} [valueField="text"] Name of the desired value field in the dataset.
     */

    /**
     * @cfg {Boolean} [allowBlank=true] `false` to require at least one item in the list to be selected, `true` to allow no
     * selection.
     */
    allowBlank: true,

    /**
     * @cfg {Number} [minSelections=0] Minimum number of selections allowed.
     */
    minSelections: 0,

    /**
     * @cfg {Number} [maxSelections=Number.MAX_VALUE] Maximum number of selections allowed.
     */
    maxSelections: Number.MAX_VALUE,

    /**
     * @cfg {String} [blankText="This field is required"] Default text displayed when the control contains no items.
     */
    blankText: 'This field is required',

    /**
     * @cfg {String} [minSelectionsText="Minimum {0}item(s) required"] 
     * Validation message displayed when {@link #minSelections} is not met. 
     * The {0} token will be replaced by the value of {@link #minSelections}.
     */
    minSelectionsText: 'Minimum {0} item(s) required',
    
    /**
     * @cfg {String} [maxSelectionsText="Maximum {0}item(s) allowed"] 
     * Validation message displayed when {@link #maxSelections} is not met
     * The {0} token will be replaced by the value of {@link #maxSelections}.
     */
    maxSelectionsText: 'Maximum {0} item(s) required',

    /**
     * @cfg {String} [delimiter=","] The string used to delimit the selected values when {@link #getSubmitValue submitting}
     * the field as part of a form. If you wish to have the selected values submitted as separate
     * parameters rather than a single delimited parameter, set this to `null`.
     */
    delimiter: ',',
    
    /**
     * @cfg {String} [dragText="{0} Item{1}"] The text to show while dragging items.
     * {0} will be replaced by the number of items. {1} will be replaced by the plural
     * form if there is more than 1 item.
     */
    dragText: '{0} Item{1}',

    /**
     * @cfg {Ext.data.Store/Array} store The data source to which this MultiSelect is bound (defaults to `undefined`).
     * Acceptable values for this property are:
     * <div class="mdetail-params"><ul>
     * <li><b>any {@link Ext.data.Store Store} subclass</b></li>
     * <li><b>an Array</b> : Arrays will be converted to a {@link Ext.data.ArrayStore} internally.
     * <div class="mdetail-params"><ul>
     * <li><b>1-dimensional array</b> : (e.g., <tt>['Foo','Bar']</tt>)<div class="sub-desc">
     * A 1-dimensional array will automatically be expanded (each array item will be the combo
     * {@link #valueField value} and {@link #displayField text})</div></li>
     * <li><b>2-dimensional array</b> : (e.g., <tt>[['f','Foo'],['b','Bar']]</tt>)<div class="sub-desc">
     * For a multi-dimensional array, the value in index 0 of each item will be assumed to be the combo
     * {@link #valueField value}, while the value at index 1 is assumed to be the combo {@link #displayField text}.
     * </div></li></ul></div></li></ul></div>
     */
    
    ignoreSelectChange: 0,

    /**
     * @cfg {Object} listConfig
     * An optional set of configuration properties that will be passed to the {@link Ext.view.BoundList}'s constructor.
     * Any configuration that is valid for BoundList can be included.
     */

    //TODO - doc me.addEvents('drop');

    initComponent: function(){
        var me = this;

        me.items = me.setupItems();

        me.bindStore(me.store, true);

        if (me.store.autoCreated) {
            me.valueField = me.displayField = 'field1';
            if (!me.store.expanded) {
                me.displayField = 'field2';
            }
        }

        if (!Ext.isDefined(me.valueField)) {
            me.valueField = me.displayField;
        }

        me.callParent();
        me.initField();
    },

    setupItems: function() {
        var me = this;

        me.boundList = Ext.create('Ext.view.BoundList', Ext.apply({
            anchor: 'none 100%',
            border: 1,
            multiSelect: true,
            store: me.store,
            displayField: me.displayField,
            disabled: me.disabled
        }, me.listConfig));

        me.boundList.getSelectionModel().on('selectionchange', me.onSelectChange, me);

        // Boundlist expects a reference to its pickerField for when an item is selected (see Boundlist#onItemClick).
        me.boundList.pickerField = me;

        // Only need to wrap the BoundList in a Panel if we have a title.
        if (!me.title) {
            return me.boundList;
        }

        // Wrap to add a title
        me.boundList.border = false;
        return {
            border: true,
            anchor: 'none 100%',
            layout: 'anchor',
            title: me.title,
            tbar: me.tbar,
            items: me.boundList
        };
    },

    onSelectChange: function(selModel, selections){
        if (!this.ignoreSelectChange) {
            this.setValue(selections);
        }    
    },
    
    getSelected: function(){
        return this.boundList.getSelectionModel().getSelection();
    },
    
    // compare array values
    isEqual: function(v1, v2) {
        var fromArray = Ext.Array.from,
            i = 0, 
            len;

        v1 = fromArray(v1);
        v2 = fromArray(v2);
        len = v1.length;

        if (len !== v2.length) {
            return false;
        }

        for(; i < len; i++) {
            if (v2[i] !== v1[i]) {
                return false;
            }
        }

        return true;
    },
    
    afterRender: function(){
        var me = this,
            records;
        
        me.callParent();
        if (me.selectOnRender) {
            records = me.getRecordsForValue(me.value);
            if (records.length) {
                ++me.ignoreSelectChange;
                me.boundList.getSelectionModel().select(records);
                --me.ignoreSelectChange;
            }
            delete me.toSelect;
        }    
        
        if (me.ddReorder && !me.dragGroup && !me.dropGroup){
            me.dragGroup = me.dropGroup = 'MultiselectDD-' + Ext.id();
        }

        if (me.draggable || me.dragGroup){
            me.dragZone = Ext.create('Ext.view.DragZone', {
                view: me.boundList,
                ddGroup: me.dragGroup,
                dragText: me.dragText
            });
        }
        if (me.droppable || me.dropGroup){
            me.dropZone = Ext.create('Ext.view.DropZone', {
                view: me.boundList,
                ddGroup: me.dropGroup,
                handleNodeDrop: function(data, dropRecord, position) {
                    var view = this.view,
                        store = view.getStore(),
                        records = data.records,
                        index;

                    // remove the Models from the source Store
                    data.view.store.remove(records);

                    index = store.indexOf(dropRecord);
                    if (position === 'after') {
                        index++;
                    }
                    store.insert(index, records);
                    view.getSelectionModel().select(records);
                    me.fireEvent('drop', me, records);
                }
            });
        }
    },
    
    isValid : function() {
        var me = this,
            disabled = me.disabled,
            validate = me.forceValidation || !disabled;
            
        
        return validate ? me.validateValue(me.value) : disabled;
    },
    
    validateValue: function(value) {
        var me = this,
            errors = me.getErrors(value),
            isValid = Ext.isEmpty(errors);
            
        if (!me.preventMark) {
            if (isValid) {
                me.clearInvalid();
            } else {
                me.markInvalid(errors);
            }
        }

        return isValid;
    },
    
    markInvalid : function(errors) {
        // Save the message and fire the 'invalid' event
        var me = this,
            oldMsg = me.getActiveError();
        me.setActiveErrors(Ext.Array.from(errors));
        if (oldMsg !== me.getActiveError()) {
            me.updateLayout();
        }
    },

    /**
     * Clear any invalid styles/messages for this field.
     *
     * __Note:__ this method does not cause the Field's {@link #validate} or {@link #isValid} methods to return `true`
     * if the value does not _pass_ validation. So simply clearing a field's errors will not necessarily allow
     * submission of forms submitted with the {@link Ext.form.action.Submit#clientValidation} option set.
     */
    clearInvalid : function() {
        // Clear the message and fire the 'valid' event
        var me = this,
            hadError = me.hasActiveError();
        me.unsetActiveError();
        if (hadError) {
            me.updateLayout();
        }
    },
    
    getSubmitData: function() {
        var me = this,
            data = null,
            val;
        if (!me.disabled && me.submitValue && !me.isFileUpload()) {
            val = me.getSubmitValue();
            if (val !== null) {
                data = {};
                data[me.getName()] = val;
            }
        }
        return data;
    },

    /**
     * Returns the value that would be included in a standard form submit for this field.
     *
     * @return {String} The value to be submitted, or `null`.
     */
    getSubmitValue: function() {
        var me = this,
            delimiter = me.delimiter,
            val = me.getValue();
        
        return Ext.isString(delimiter) ? val.join(delimiter) : val;
    },
    
    getValue: function(){
        return this.value || [];
    },
    
    getRecordsForValue: function(value){
        var me = this,
            records = [],
            all = me.store.getRange(),
            valueField = me.valueField,
            i = 0,
            allLen = all.length,
            rec,
            j,
            valueLen;
            
        for (valueLen = value.length; i < valueLen; ++i) {
            for (j = 0; j < allLen; ++j) {
                rec = all[j];   
                if (rec.get(valueField) == value[i]) {
                    records.push(rec);
                }
            }    
        }
            
        return records;
    },
    
    setupValue: function(value){
        var delimiter = this.delimiter,
            valueField = this.valueField,
            i = 0,
            out,
            len,
            item;
            
        if (Ext.isDefined(value)) {
            if (delimiter && Ext.isString(value)) {
                value = value.split(delimiter);
            } else if (!Ext.isArray(value)) {
                value = [value];
            }
        
            for (len = value.length; i < len; ++i) {
                item = value[i];
                if (item && item.isModel) {
                    value[i] = item.get(valueField);
                }
            }
            out = Ext.Array.unique(value);
        } else {
            out = [];
        }
        return out;
    },
    
    setValue: function(value){
        var me = this,
            selModel = me.boundList.getSelectionModel(),
            store = me.store;

        // Store not loaded yet - we cannot set the value
        if (!store.getCount()) {
            store.on({
                load: Ext.Function.bind(me.setValue, me, [value]),
                single: true
            });
            return;
        }

        value = me.setupValue(value);
        me.mixins.field.setValue.call(me, value);
        
        if (me.rendered) {
            ++me.ignoreSelectChange;
            selModel.deselectAll();
            if (value.length) {
                selModel.select(me.getRecordsForValue(value));
            }
            --me.ignoreSelectChange;
        } else {
            me.selectOnRender = true;
        }
    },
    
    clearValue: function(){
        this.setValue([]);    
    },
    
    onEnable: function(){
        var list = this.boundList;
        this.callParent();
        if (list) {
            list.enable();
        }
    },
    
    onDisable: function(){
        var list = this.boundList;
        this.callParent();
        if (list) {
            list.disable();
        }
    },
    
    getErrors : function(value) {
        var me = this,
            format = Ext.String.format,
            errors = [],
            numSelected;

        value = Ext.Array.from(value || me.getValue());
        numSelected = value.length;

        if (!me.allowBlank && numSelected < 1) {
            errors.push(me.blankText);
        }
        if (numSelected < me.minSelections) {
            errors.push(format(me.minSelectionsText, me.minSelections));
        }
        if (numSelected > me.maxSelections) {
            errors.push(format(me.maxSelectionsText, me.maxSelections));
        }
        return errors;
    },
    
    onDestroy: function(){
        var me = this;
        
        me.bindStore(null);
        Ext.destroy(me.dragZone, me.dropZone);
        me.callParent();
    },
    
    onBindStore: function(store){
        var boundList = this.boundList;
        
        if (boundList) {
            boundList.bindStore(store);
        }
    }
    
});


/*
 * Note that this control will most likely remain as an example, and not as a core Ext form
 * control.  However, the API will be changing in a future release and so should not yet be
 * treated as a final, stable API at this time.
 */

/**
 * A control that allows selection of between two Ext.ux.form.MultiSelect controls.
 */
Ext.define('Ext.ux.form.ItemSelector', {
    extend: 'Ext.ux.form.MultiSelect',
    alias: ['widget.itemselectorfield', 'widget.itemselector'],
    alternateClassName: ['Ext.ux.ItemSelector'],
    requires: [
        'Ext.button.Button',
        'Ext.ux.form.MultiSelect'
    ],

    /**
     * @cfg {Boolean} [hideNavIcons=false] True to hide the navigation icons
     */
    hideNavIcons:false,

    /**
     * @cfg {Array} buttons Defines the set of buttons that should be displayed in between the ItemSelector
     * fields. Defaults to <tt>['top', 'up', 'add', 'remove', 'down', 'bottom']</tt>. These names are used
     * to build the button CSS class names, and to look up the button text labels in {@link #buttonsText}.
     * This can be overridden with a custom Array to change which buttons are displayed or their order.
     */
    buttons: ['top', 'up', 'add', 'remove', 'down', 'bottom'],

    /**
     * @cfg {Object} buttonsText The tooltips for the {@link #buttons}.
     * Labels for buttons.
     */
    buttonsText: {
        top: "Move to Top",
        up: "Move Up",
        add: "Add to Selected",
        remove: "Remove from Selected",
        down: "Move Down",
        bottom: "Move to Bottom"
    },

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    initComponent: function() {
        var me = this;

        me.ddGroup = me.id + '-dd';
        me.callParent();

        // bindStore must be called after the fromField has been created because
        // it copies records from our configured Store into the fromField's Store
        me.bindStore(me.store);
    },

    createList: function(title){
        var me = this;

        return Ext.create('Ext.ux.form.MultiSelect', {
            // We don't want the multiselects themselves to act like fields,
            // so override these methods to prevent them from including
            // any of their values
            submitValue: false,
            getSubmitData: function(){
                return null;
            },
            getModelData: function(){
                return null;    
            },
            flex: 1,
            dragGroup: me.ddGroup,
            dropGroup: me.ddGroup,
            title: title,
            store: {
                model: me.store.model,
                data: []
            },
            displayField: me.displayField,
            valueField: me.valueField,
            disabled: me.disabled,
            listeners: {
                boundList: {
                    scope: me,
                    itemdblclick: me.onItemDblClick,
                    drop: me.syncValue
                }
            }
        });
    },

    setupItems: function() {
        var me = this;

        me.fromField = me.createList(me.fromTitle);
        me.toField = me.createList(me.toTitle);

        return [
            me.fromField,
            {
                xtype: 'container',
                margin: '0 4',
                layout: {
                    type: 'vbox',
                    pack: 'center'
                },
                items: me.createButtons()
            },
            me.toField
        ];
    },

    createButtons: function() {
        var me = this,
            buttons = [];

        if (!me.hideNavIcons) {
            Ext.Array.forEach(me.buttons, function(name) {
                buttons.push({
                    xtype: 'button',
                    tooltip: me.buttonsText[name],
                    handler: me['on' + Ext.String.capitalize(name) + 'BtnClick'],
                    cls: Ext.baseCSSPrefix + 'form-itemselector-btn',
                    iconCls: Ext.baseCSSPrefix + 'form-itemselector-' + name,
                    navBtn: true,
                    scope: me,
                    margin: '4 0 0 0'
                });
            });
        }
        return buttons;
    },

    /**
     * Get the selected records from the specified list.
     * 
     * Records will be returned *in store order*, not in order of selection.
     * @param {Ext.view.BoundList} list The list to read selections from.
     * @return {Ext.data.Model[]} The selected records in store order.
     * 
     */
    getSelections: function(list) {
        var store = list.getStore();

        return Ext.Array.sort(list.getSelectionModel().getSelection(), function(a, b) {
            a = store.indexOf(a);
            b = store.indexOf(b);

            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            return 0;
        });
    },

    onTopBtnClick : function() {
        var list = this.toField.boundList,
            store = list.getStore(),
            selected = this.getSelections(list);

        store.suspendEvents();
        store.remove(selected, true);
        store.insert(0, selected);
        store.resumeEvents();
        list.refresh();
        this.syncValue(); 
        list.getSelectionModel().select(selected);
    },

    onBottomBtnClick : function() {
        var list = this.toField.boundList,
            store = list.getStore(),
            selected = this.getSelections(list);

        store.suspendEvents();
        store.remove(selected, true);
        store.add(selected);
        store.resumeEvents();
        list.refresh();
        this.syncValue();
        list.getSelectionModel().select(selected);
    },

    onUpBtnClick : function() {
        var list = this.toField.boundList,
            store = list.getStore(),
            selected = this.getSelections(list),
            rec,
            i = 0,
            len = selected.length,
            index = 0;

        // Move each selection up by one place if possible
        store.suspendEvents();
        for (; i < len; ++i, index++) {
            rec = selected[i];
            index = Math.max(index, store.indexOf(rec) - 1);
            store.remove(rec, true);
            store.insert(index, rec);
        }
        store.resumeEvents();
        list.refresh();
        this.syncValue();
        list.getSelectionModel().select(selected);
    },

    onDownBtnClick : function() {
        var list = this.toField.boundList,
            store = list.getStore(),
            selected = this.getSelections(list),
            rec,
            i = selected.length - 1,
            index = store.getCount() - 1;

        // Move each selection down by one place if possible
        store.suspendEvents();
        for (; i > -1; --i, index--) {
            rec = selected[i];
            index = Math.min(index, store.indexOf(rec) + 1);
            store.remove(rec, true);
            store.insert(index, rec);
        }
        store.resumeEvents();
        list.refresh();
        this.syncValue();
        list.getSelectionModel().select(selected);
    },

    onAddBtnClick : function() {
        var me = this,
            selected = me.getSelections(me.fromField.boundList);

        me.moveRec(true, selected);
        me.toField.boundList.getSelectionModel().select(selected);
    },

    onRemoveBtnClick : function() {
        var me = this,
            selected = me.getSelections(me.toField.boundList);

        me.moveRec(false, selected);
        me.fromField.boundList.getSelectionModel().select(selected);
    },

    moveRec: function(add, recs) {
        var me = this,
            fromField = me.fromField,
            toField   = me.toField,
            fromStore = add ? fromField.store : toField.store,
            toStore   = add ? toField.store   : fromField.store;

        fromStore.suspendEvents();
        toStore.suspendEvents();
        fromStore.remove(recs);
        toStore.add(recs);
        fromStore.resumeEvents();
        toStore.resumeEvents();

        fromField.boundList.refresh();
        toField.boundList.refresh();

        me.syncValue();
    },

    // Synchronizes the submit value with the current state of the toStore
    syncValue: function() {
        var me = this; 
        me.mixins.field.setValue.call(me, me.setupValue(me.toField.store.getRange()));
    },

    onItemDblClick: function(view, rec) {
        this.moveRec(view === this.fromField.boundList, rec);
    },

    setValue: function(value) {
        var me = this,
            fromField = me.fromField,
            toField = me.toField,
            fromStore = fromField.store,
            toStore = toField.store,
            selected;

        // Wait for from store to be loaded
        if (!me.fromStorePopulated) {
            me.fromField.store.on({
                load: Ext.Function.bind(me.setValue, me, [value]),
                single: true
            });
            return;
        }

        value = me.setupValue(value);
        me.mixins.field.setValue.call(me, value);

        selected = me.getRecordsForValue(value);

        // Clear both left and right Stores.
        // Both stores must not fire events during this process.
        fromStore.suspendEvents();
        toStore.suspendEvents();
        fromStore.removeAll();
        toStore.removeAll();

        // Reset fromStore
        me.populateFromStore(me.store);

        // Copy selection across to toStore
        Ext.Array.forEach(selected, function(rec){
            // In the from store, move it over
            if (fromStore.indexOf(rec) > -1) {
                fromStore.remove(rec);
            }
            toStore.add(rec);
        });

        // Stores may now fire events
        fromStore.resumeEvents();
        toStore.resumeEvents();

        // Refresh both sides and then update the app layout
        Ext.suspendLayouts();
        fromField.boundList.refresh();
        toField.boundList.refresh();
        Ext.resumeLayouts(true);        
    },

    onBindStore: function(store, initial) {
        var me = this;

        if (me.fromField) {
            me.fromField.store.removeAll();
            me.toField.store.removeAll();

            // Add everything to the from field as soon as the Store is loaded
            if (store.getCount()) {
                me.populateFromStore(store);
            } else {
                me.store.on('load', me.populateFromStore, me);
            }
        }
    },

    populateFromStore: function(store) {
        var fromStore = this.fromField.store;

        // Flag set when the fromStore has been loaded
        this.fromStorePopulated = true;

        fromStore.add(store.getRange());

        // setValue waits for the from Store to be loaded
        fromStore.fireEvent('load', fromStore);
    },

    onEnable: function(){
        var me = this;

        me.callParent();
        me.fromField.enable();
        me.toField.enable();

        Ext.Array.forEach(me.query('[navBtn]'), function(btn){
            btn.enable();
        });
    },

    onDisable: function(){
        var me = this;

        me.callParent();
        me.fromField.disable();
        me.toField.disable();

        Ext.Array.forEach(me.query('[navBtn]'), function(btn){
            btn.disable();
        });
    },

    onDestroy: function(){
        this.bindStore(null);
        this.callParent();
    }
});



/**
 * 设置系统中window位置默认限制在它的父元素内
 */
Ext.override(Ext.window.Window, {
    constrain: true
});
/**
 * 设置系统中表格内的内容都可选择
 */
Ext.override(Ext.view.Table, {
    enableTextSelection: true
});
/**
 * 设置只读添加红色星号
 */
Ext.override(Ext.form.field.Base, {
	initComponent:function () {
    	var me = this;
    	me.callParent();
    	if (me.allowBlank === false && !Ext.isEmpty(me.fieldLabel)) {
      		me.beforeLabelTextTpl = '<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>';
    	}
	}
});
/**
 * 设置只读添加红色星号
 */
Ext.override(Ext.form.FieldContainer, {
	initComponent:function () {
    	var me = this;
    	me.callParent();
    	if (me.allowBlank === false && !Ext.isEmpty(me.fieldLabel)) {
      		me.beforeLabelTextTpl = '<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>';
    	}
	}
});

/**
 * A ratings picker based on `Ext.Widget`.
 *
 *      @example
 *      Ext.create({
 *          xtype: 'rating',
 *          renderTo: Ext.getBody(),
 *          listeners: {
 *              change: function (picker, value) {
 *                 console.log('Rating ' + value);
 *              }
 *          }
 *      });
 */
Ext.define('Ext.ux.rating.Picker', {
    extend: 'Ext.Widget',
    xtype: 'rating',
    focusable: true,
    /*
     * The "cachedConfig" block is basically the same as "config" except that these
     * values are applied specially to the first instance of the class. After processing
     * these configs, the resulting values are stored on the class `prototype` and the
     * template DOM element also reflects these default values.
     */
    cachedConfig: {
        /**
         * @cfg {String} [family]
         * The CSS `font-family` to use for displaying the `{@link #glyphs}`.
         */
        family: 'monospace',
        /**
         * @cfg {String/String[]/Number[]} [glyphs]
         * Either a string containing the two glyph characters, or an array of two strings
         * containing the individual glyph characters or an array of two numbers with the
         * character codes for the individual glyphs.
         *
         * For example:
         *
         *      @example
         *      Ext.create({
         *          xtype: 'rating',
         *          renderTo: Ext.getBody(),
         *          glyphs: [ 9671, 9670 ], // '◇◆',
         *          listeners: {
         *              change: function (picker, value) {
         *                 console.log('Rating ' + value);
         *              }
         *          }
         *      });
         */
        glyphs: '☆★',
        /**
         * @cfg {Number} [minimum=1]
         * The minimum allowed `{@link #value}` (rating).
         */
        minimum: 1,
        /**
         * @cfg {Number} [limit=1]
         * The maximum allowed `{@link #value}` (rating).
         */
        limit: 5,
        /**
         * @cfg {String/Object} [overStyle]
         * Optional styles to apply to the rating glyphs when `{@link #trackOver}` is
         * enabled.
         */
        overStyle: null,
        /**
         * @cfg {Number} [rounding=1]
         * The rounding to apply to values. Common choices are 0.5 (for half-steps) or
         * 0.25 (for quarter steps).
         */
        rounding: 1,
        /**
         * @cfg {String} [scale="125%"]
         * The CSS `font-size` to apply to the glyphs. This value defaults to 125% because
         * glyphs in the stock font tend to be too small. When using specially designed
         * "icon fonts" you may want to set this to 100%.
         */
        scale: '125%',
        /**
         * @cfg {String/Object} [selectedStyle]
         * Optional styles to apply to the rating value glyphs.
         */
        selectedStyle: null,
        /**
         * @cfg {String/Object} [style]
         * Optional styles to apply to the top-level element.
         */
        style: null,
        /**
         * @cfg {Object/String/String[]/Ext.XTemplate/Function} tooltip
         * A template or a function that produces the tooltip text. The `Object`, `String`
         * and `String[]` forms are converted to an `Ext.XTemplate`. If a function is given,
         * it will be called with an object parameter and should return the tooltip text.
         * The object contains these properties:
         *
         *   - component: The rating component requesting the tooltip.
         *   - tracking: The current value under the mouse cursor.
         *   - trackOver: The value of the `{@link #trackOver}` config.
         *   - value: The current value.
         *
         * Templates can use these properties to generate the proper text.
         */
        tooltip: null,
        /**
         * @cfg {Boolean} [trackOver=true]
         * Determines if mouse movements should temporarily update the displayed value.
         * The actual `value` is only updated on `click` but this rather acts as the
         * "preview" of the value prior to click.
         */
        trackOver: true,
        /**
         * @cfg {Number} value
         * The rating value. This value is bounded by `minimum` and `limit` and is also
         * adjusted by the `rounding`.
         */
        value: null,
        //---------------------------------------------------------------------
        // Private configs
        /**
         * @cfg {String} tooltipText
         * The current tooltip text. This value is set into the DOM by the updater (hence
         * only when it changes). This is intended for use by the tip manager
         * (`{@link Ext.tip.QuickTipManager}`). Developers should never need to set this
         * config since it is handled by virtue of setting other configs (such as the
         * {@link #tooltip} or the {@link #value}.).
         * @private
         */
        tooltipText: null,
        /**
         * @cfg {Number} trackingValue
         * This config is used to when `trackOver` is `true` and represents the tracked
         * value. This config is maintained by our `mousemove` handler. This should not
         * need to be set directly by user code.
         * @private
         */
        trackingValue: null
    },
    config: {
        /**
         * @cfg {Boolean/Object} [animate=false]
         * Specifies an animation to use when changing the `{@link #value}`. When setting
         * this config, it is probably best to set `{@link #trackOver}` to `false`.
         */
        animate: null
    },
    // This object describes our element tree from the root.
    element: {
        cls: 'u' + Ext.baseCSSPrefix + 'rating-picker',
        // Since we are replacing the entire "element" tree, we have to assign this
        // "reference" as would our base class.
        reference: 'element',
        children: [
            {
                reference: 'innerEl',
                cls: 'u' + Ext.baseCSSPrefix + 'rating-picker-inner',
                listeners: {
                    click: 'onClick',
                    mousemove: 'onMouseMove',
                    mouseenter: 'onMouseEnter',
                    mouseleave: 'onMouseLeave'
                },
                children: [
                    {
                        reference: 'valueEl',
                        cls: 'u' + Ext.baseCSSPrefix + 'rating-picker-value'
                    },
                    {
                        reference: 'trackerEl',
                        cls: 'u' + Ext.baseCSSPrefix + 'rating-picker-tracker'
                    }
                ]
            }
        ]
    },
    // Tell the Binding system to default to our "value" config.
    defaultBindProperty: 'value',
    // Enable two-way data binding for the "value" config.
    twoWayBindable: 'value',
    overCls: 'u' + Ext.baseCSSPrefix + 'rating-picker-over',
    trackOverCls: 'u' + Ext.baseCSSPrefix + 'rating-picker-track-over',
    //-------------------------------------------------------------------------
    // Config Appliers
    applyGlyphs: function(value) {
        if (typeof value === 'string') {
            if (value.length !== 2) {
                Ext.Error.raise('Expected 2 characters for "glyphs" not "' + value + '".');
            }
            value = [
                value.charAt(0),
                value.charAt(1)
            ];
        } else if (typeof value[0] === 'number') {
            value = [
                String.fromCharCode(value[0]),
                String.fromCharCode(value[1])
            ];
        }
        return value;
    },
    applyOverStyle: function(style) {
        this.trackerEl.applyStyles(style);
    },
    applySelectedStyle: function(style) {
        this.valueEl.applyStyles(style);
    },
    applyStyle: function(style) {
        this.element.applyStyles(style);
    },
    applyTooltip: function(tip) {
        if (tip && typeof tip !== 'function') {
            if (!tip.isTemplate) {
                tip = new Ext.XTemplate(tip);
            }
            tip = tip.apply.bind(tip);
        }
        return tip;
    },
    applyTrackingValue: function(value) {
        return this.applyValue(value);
    },
    // same rounding as normal value
    applyValue: function(v) {
        if (v !== null) {
            var rounding = this.getRounding(),
                limit = this.getLimit(),
                min = this.getMinimum();
            v = Math.round(Math.round(v / rounding) * rounding * 1000) / 1000;
            v = (v < min) ? min : (v > limit ? limit : v);
        }
        return v;
    },
    //-------------------------------------------------------------------------
    // Event Handlers
    onClick: function(event) {
        var value = this.valueFromEvent(event);
        this.setValue(value);
    },
    onMouseEnter: function() {
        this.element.addCls(this.overCls);
    },
    onMouseLeave: function() {
        this.element.removeCls(this.overCls);
    },
    onMouseMove: function(event) {
        var value = this.valueFromEvent(event);
        this.setTrackingValue(value);
    },
    //-------------------------------------------------------------------------
    // Config Updaters
    updateFamily: function(family) {
        this.element.setStyle('fontFamily', "'" + family + "'");
    },
    updateGlyphs: function() {
        this.refreshGlyphs();
    },
    updateLimit: function() {
        this.refreshGlyphs();
    },
    updateScale: function(size) {
        this.element.setStyle('fontSize', size);
    },
    updateTooltip: function() {
        this.refreshTooltip();
    },
    updateTooltipText: function(text) {
        var innerEl = this.innerEl,
            QuickTips = Ext.tip && Ext.tip.QuickTipManager,
            tip = QuickTips && QuickTips.tip,
            target;
        if (QuickTips) {
            innerEl.dom.setAttribute('data-qtip', text);
            this.trackerEl.dom.setAttribute('data-qtip', text);
            // If the QuickTipManager is active over our widget, we need to update
            // the tooltip text directly.
            target = tip && tip.activeTarget;
            target = target && target.el;
            if (target && innerEl.contains(target)) {
                tip.update(text);
            }
        }
    },
    updateTrackingValue: function(value) {
        var me = this,
            trackerEl = me.trackerEl,
            newWidth = me.valueToPercent(value);
        trackerEl.setStyle('width', newWidth);
        me.refreshTooltip();
    },
    updateTrackOver: function(trackOver) {
        this.element[trackOver ? 'addCls' : 'removeCls'](this.trackOverCls);
    },
    updateValue: function(value, oldValue) {
        var me = this,
            animate = me.getAnimate(),
            valueEl = me.valueEl,
            newWidth = me.valueToPercent(value),
            column, record;
        if (me.isConfiguring || !animate) {
            valueEl.setStyle('width', newWidth);
        } else {
            valueEl.stopAnimation();
            valueEl.animate(Ext.merge({
                from: {
                    width: me.valueToPercent(oldValue)
                },
                to: {
                    width: newWidth
                }
            }, animate));
        }
        me.refreshTooltip();
        if (!me.isConfiguring) {
            // Since we are (re)configured many times as we are used in a grid cell, we
            // avoid firing the change event unless there are listeners.
            if (me.hasListeners.change) {
                me.fireEvent('change', me, value, oldValue);
            }
            column = me.getWidgetColumn && me.getWidgetColumn();
            record = column && me.getWidgetRecord && me.getWidgetRecord();
            if (record && column.dataIndex) {
                // When used in a widgetcolumn, we should update the backing field. The
                // linkages will be cleared as we are being recycled, so this will only
                // reach this line when we are properly attached to a record and the
                // change is coming from the user (or a call to setValue).
                record.set(column.dataIndex, value);
            }
        }
    },
    //-------------------------------------------------------------------------
    // Config System Optimizations
    //
    // These are to deal with configs that combine to determine what should be
    // rendered in the DOM. For example, "glyphs" and "limit" must both be known
    // to render the proper text nodes. The "tooltip" and "value" likewise are
    // used to update the tooltipText.
    //
    // To avoid multiple updates to the DOM (one for each config), we simply mark
    // the rendering as invalid and post-process these flags on the tail of any
    // bulk updates.
    afterCachedConfig: function() {
        // Now that we are done setting up the initial values we need to refresh the
        // DOM before we allow Ext.Widget's implementation to cloneNode on it.
        this.refresh();
        return this.callParent(arguments);
    },
    initConfig: function(instanceConfig) {
        this.isConfiguring = true;
        this.callParent([
            instanceConfig
        ]);
        // The firstInstance will already have refreshed the DOM (in afterCacheConfig)
        // but all instances beyond the first need to refresh if they have custom values
        // for one or more configs that affect the DOM (such as "glyphs" and "limit").
        this.refresh();
    },
    setConfig: function() {
        var me = this;
        // Since we could be updating multiple configs, save any updates that need
        // multiple values for afterwards.
        me.isReconfiguring = true;
        me.callParent(arguments);
        me.isReconfiguring = false;
        // Now that all new values are set, we can refresh the DOM.
        me.refresh();
        return me;
    },
    //-------------------------------------------------------------------------
    destroy: function() {
        var me = this,
            tip = me.tip;
        if (tip) {
            me.tip = Ext.destroy(tip);
        }
        me.callParent();
    },
    privates: {
        /**
         * This method returns the DOM text node into which glyphs are placed.
         * @param {HTMLElement} dom The DOM node parent of the text node.
         * @return {HTMLTextNode} The text node.
         * @private
         */
        getGlyphTextNode: function(dom) {
            var node = dom.lastChild;
            // We want all our text nodes to be at the end of the child list, most
            // especially the text node on the innerEl. That text node affects the
            // default left/right position of our absolutely positioned child divs
            // (trackerEl and valueEl).
            if (!node || node.nodeType !== 3) {
                node = dom.ownerDocument.createTextNode('');
                dom.appendChild(node);
            }
            return node;
        },
        getTooltipData: function() {
            var me = this;
            return {
                component: me,
                tracking: me.getTrackingValue(),
                trackOver: me.getTrackOver(),
                value: me.getValue()
            };
        },
        /**
         * Forcibly refreshes both glyph and tooltip rendering.
         * @private
         */
        refresh: function() {
            var me = this;
            if (me.invalidGlyphs) {
                me.refreshGlyphs(true);
            }
            if (me.invalidTooltip) {
                me.refreshTooltip(true);
            }
        },
        /**
         * Refreshes the glyph text rendering unless we are currently performing a
         * bulk config change (initConfig or setConfig).
         * @param {Boolean} now Pass `true` to force the refresh to happen now.
         * @private
         */
        refreshGlyphs: function(now) {
            var me = this,
                later = !now && (me.isConfiguring || me.isReconfiguring),
                el, glyphs, limit, on, off, trackerEl, valueEl;
            if (!later) {
                el = me.getGlyphTextNode(me.innerEl.dom);
                valueEl = me.getGlyphTextNode(me.valueEl.dom);
                trackerEl = me.getGlyphTextNode(me.trackerEl.dom);
                glyphs = me.getGlyphs();
                limit = me.getLimit();
                for (on = off = ''; limit--; ) {
                    off += glyphs[0];
                    on += glyphs[1];
                }
                el.nodeValue = off;
                valueEl.nodeValue = on;
                trackerEl.nodeValue = on;
            }
            me.invalidGlyphs = later;
        },
        /**
         * Refreshes the tooltip text rendering unless we are currently performing a
         * bulk config change (initConfig or setConfig).
         * @param {Boolean} now Pass `true` to force the refresh to happen now.
         * @private
         */
        refreshTooltip: function(now) {
            var me = this,
                later = !now && (me.isConfiguring || me.isReconfiguring),
                tooltip = me.getTooltip(),
                data, text;
            if (!later) {
                tooltip = me.getTooltip();
                if (tooltip) {
                    data = me.getTooltipData();
                    text = tooltip(data);
                    me.setTooltipText(text);
                }
            }
            me.invalidTooltip = later;
        },
        /**
         * Convert the coordinates of the given `Event` into a rating value.
         * @param {Ext.Event} event The event.
         * @return {Number} The rating based on the given event coordinates.
         * @private
         */
        valueFromEvent: function(event) {
            var me = this,
                el = me.innerEl,
                ex = event.getX(),
                rounding = me.getRounding(),
                cx = el.getX(),
                x = ex - cx,
                w = el.getWidth(),
                limit = me.getLimit(),
                v;
            if (me.getInherited().rtl) {
                x = w - x;
            }
            v = x / w * limit;
            // We have to round up here so that the area we are over is considered
            // the value.
            v = Math.ceil(v / rounding) * rounding;
            return v;
        },
        /**
         * Convert the given rating into a width percentage.
         * @param {Number} value The rating value to convert.
         * @return {String} The width percentage to represent the given value.
         * @private
         */
        valueToPercent: function(value) {
            value = (value / this.getLimit()) * 100;
            return value + '%';
        }
    }
});


Ext.define('Ext.ux.grid.SubTable', {
    extend: 'Ext.grid.plugin.RowExpander',

    alias: 'plugin.subtable',

    rowBodyTpl: ['<table class="' + Ext.baseCSSPrefix + 'grid-subtable"><tbody>',
        '{%',
            'this.owner.renderTable(out, values);',
        '%}',
        '</tbody></table>'
    ],

    init: function(grid) {
        var me = this,
            columns = me.columns,
            len, i, columnCfg;

        me.callParent(arguments);

        me.columns = [];
        if (columns) {
            for (i = 0, len = columns.length; i < len; ++i) {
                // Don't register with the component manager, we create them to use
                // their rendering smarts, but don't want to treat them as real components
                columnCfg = Ext.apply({
                    preventRegister: true
                }, columns[i]);
                columnCfg.xtype = columnCfg.xtype || 'gridcolumn';
                me.columns.push(Ext.widget(columnCfg));
            }
        }
    },

    destroy: function() {
        var columns = this.columns,
            len, i;

        if (columns) {
            for (i = 0, len = columns.length; i < len; ++i) {
                columns[i].destroy();
            }
        }
        this.columns = null;
        this.callParent();
    },

    getRowBodyFeatureData: function(record, idx, rowValues) {
        this.callParent(arguments);
        rowValues.rowBodyCls += ' ' + Ext.baseCSSPrefix + 'grid-subtable-row';
    },

    renderTable: function(out, rowValues) {
        var me = this,
            columns = me.columns,
            numColumns = columns.length,
            associatedRecords = me.getAssociatedRecords(rowValues.record),
            recCount = associatedRecords.length,
            rec, column, i, j, value;

        out.push('<thead>');
        for (j = 0; j < numColumns; j++) {
            out.push('<th class="' + Ext.baseCSSPrefix + 'grid-subtable-header">', columns[j].text, '</th>');
        }
        out.push('</thead>');
        for (i = 0; i < recCount; i++) {
            rec = associatedRecords[i];
            out.push('<tr>');
            for (j = 0; j < numColumns; j++) {
                column = columns[j];
                value = rec.get(column.dataIndex);
                if (column.renderer && column.renderer.call) {
                    value = column.renderer.call(column.scope || me, value, {}, rec);
                }
                out.push('<td class="' + Ext.baseCSSPrefix + 'grid-subtable-cell"');
                if (column.width != null) {
                    out.push(' style="width:' + column.width + 'px"');
                }
                out.push('><div class="' + Ext.baseCSSPrefix + 'grid-cell-inner">', value, '</div></td>');
            }
            out.push('</tr>');
        }
    },
    
    getRowBodyContentsFn: function(rowBodyTpl) {
        var me = this;
        return function (rowValues) {
            rowBodyTpl.owner = me;
            return rowBodyTpl.applyTemplate(rowValues);
        };
    },
    
    getAssociatedRecords: function(record) {
        return record[this.association]().getRange();
    }
});

/**
 * allowBlank = false 
 * 过滤空格
 */
Ext.override(Ext.form.TextField, { 
    validator:function(text){
        if(this.allowBlank==false && Ext.util.Format.trim(text).length==0)
          return false;
        else
          return true;
    }
}); 