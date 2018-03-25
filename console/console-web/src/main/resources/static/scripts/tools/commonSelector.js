//下拉单选框
Ext.define('Caiwei.commonSelector.CommonCombSelector', {
    extend : 'Frame.commonselector.DynamicComboSelector',
    minChars : 0,
    disableKeyFilter: true,
    isPaging : false,// 分页
    isEnterQuery : true,// 回车查询
    listWidth : 200,// 设置下拉框宽度
    active : null,
    myActive : 'Y',
    record : null,
    displayField : null,
    valueField : null,
    displayField : null,// 显示名称
    valueField : null,// 值
    queryParam : null,// 查询参数
    realValue : null,
    setCombValue : function(displayText, valueText) {
        var me = this, key = me.displayField + '', value = me.valueField
            + '';
        var m = Ext.create(me.store.getModel().getName());
        m.set(key, displayText);
        m.set(value, valueText);
        me.record = m;
        me.store.loadRecords([m]);
        me.setValue(valueText);
        me.realValue = valueText;
    },
    listeners: {
		/*change: function(comb, newValue, oldValue, eOpts){
		 if(comb.isExpanded==true){
		 comb.collapse();
		 }
		 if(newValue != oldValue){
		 comb.realValue = null;
		 }
		 },*/
        //失去焦点时校验是否做出选择，未做出选择清空下拉框
        blur:function(comb, the, eOpts){
            if (Ext.isEmpty(comb.realValue)) {
                comb.setRawValue(null);
                comb.setValue(null);
            }else{
                var display = comb.record.data[comb.displayField];
                if(!Ext.Object.equals(display,comb.getRawValue())){
                    comb.setRawValue(null);
                    comb.setValue(null);
                    comb.realValue = null;
                }
            }
        },
        select:function(comb, records, obs){
            comb.record = records;
            var data = records.data;
            comb.realValue = data[comb.valueField];
            //显示情况控件
            comb.getTrigger('clear').show();
        },
        keyup : function(combo, event, eOpts){
            //下拉框输入值
            var value = combo.getRawValue();
            //情况控件
            var clearTrigger = combo.getTrigger('clear');
            if(!Ext.isEmpty(value)){
                //输入不为空显示情况控件
                clearTrigger.show();
            }else{
                //隐藏情况控件
                clearTrigger.hide();
            }
            //关闭下拉框
            //combo.collapse();
            if(combo.isEnterQuery == true && event.getKey() == event.ENTER){
                var rawValue = combo.getRawValue();
                combo.store.loadPage(1,{
                    scope: this,
                    callback: function(records, operation, success) {
                        if(records.length>0){
                            //展开下拉框
                            combo.expand();
                        }
                        combo.setRawValue(rawValue);
                    }
                });
            }
        }
    },

    getBeforeLoad : function(store, operation, e) {
        var me = this;
        var me = this, searchParams = operation.getParams();
        if (Ext.isEmpty(searchParams)) {
            searchParams = {};
        }
        var prefix = me.queryParam.substring(0, me.queryParam
                .lastIndexOf('.'))
            + '.';
        var param = prefix + me.myQueryParam;
        if (!Ext.isEmpty(me.myQueryParam)) {
            searchParams[param] = me.getRawValue();
            searchParams[me.queryParam] = null;
        } else {
            searchParams[me.queryParam] = me.rawValue;
            if(!Ext.isEmpty(me.myQueryParam)){
                searchParams[param] = null;
            }
        }
		/*var activeParam = prefix + 'active';
		 var act = Ext.isEmpty(me.active) ? me.myActive : me.active;
		 searchParams[activeParam] = act;*/
        Ext.apply(store.proxy.extraParams, searchParams);
    },
    triggers:{
        clear : {
            cls : 'x-form-clear-trigger',
            handler : function(){
                this.setRawValue(null);
                this.setValue(null);
                this.realValue = null;
                this.getTrigger('clear').hide();
            },
            hidden : true
        }
    },
    constructor : function(config) {
        var me = this, cfg = Ext.apply({}, config);
        me.active = config.active;
        me.store.addListener('select', function(comb, records, obs) {
            var record = records[0];
            me.record = record;
            me.realValue = record[me.valueField];
        });
        me.callParent([cfg]);
		/*me.on('blur',me.getBlur,me);
		 me.on('select',me.getSelect,me);
		 me.on('change',me.getChange,me);
		 me.on('keyup',me.getKeyup,me);*/
    },
    getRecord : function() {
        var me = this;
        return me.record;
    }
});


/**
 * 联动container
 */
Ext.define('Caiwei.commonselector.LinkageContainer',{
    extend: 'Ext.form.FieldContainer',
    alias: 'widget.linkagecontainer',
    defaultType: 'linkagecomboselector',
    getItemValue: function(itemId){
        var me = this,
            item = me.items.get(itemId);
        if(item!=null){
            return item.getValue();
        }
        return null;
    },
    getValue: function(){
        var me = this,
            values = new Array();
        for(var i=0;i<me.items.length;i++){
            values[i] = me.getItemValue(me.items.items[i].itemId);
        }
        return values;
    }
});

/**
 * 联动查询组件
 */
Ext.define('Caiwei.commonselector.LinkageComboSelector',{
    extend: 'Frame.commonselector.DynamicComboSelector',
    alias: 'widget.linkagecomboselector',
    minChars : 0,
    isPaging : false,// 分页
    isEnterQuery : true,// 回车查询
    parentParamsAndItemIds: null,//级联父组件参数
    realValue : null,
    listeners:{
        //失去焦点时校验是否做出选择，未做出选择清空下拉框
        blur:function(comb, the, eOpts){
            if (Ext.isEmpty(comb.realValue)) {
                comb.setRawValue(null);
                comb.setValue(null);
            }else{
                var display = comb.record.data[comb.displayField];
                if(!Ext.Object.equals(display,comb.getRawValue())){
                    comb.setRawValue(null);
                    comb.setValue(null);
                    comb.realValue = null;
                }
            }
        },
        select:function(comb, records, obs){
            comb.record = records;
            var data = records.data;
            comb.realValue = data[comb.valueField];
            //显示情况控件
            comb.getTrigger('clear').show();
        },
        keyup : function(combo, event, eOpts){
            //下拉框输入值
            var value = combo.getRawValue();
            //情况控件
            var clearTrigger = combo.getTrigger('clear');
            if(!Ext.isEmpty(value)){
                //输入不为空显示情况控件
                clearTrigger.show();
            }else{
                //隐藏情况控件
                clearTrigger.hide();
            }
            //关闭下拉框
            //combo.collapse();
            if(combo.isEnterQuery == true && event.getKey() == event.ENTER){
                var rawValue = combo.getRawValue();
                combo.store.loadPage(1,{
                    scope: this,
                    callback: function(records, operation, success) {
                        if(records.length>0){
                            //展开下拉框
                            combo.expand();
                        }
                        combo.setRawValue(rawValue);
                    }
                });
            }
        }
    },
	/*eventType: ['callparent'],//事件(传入)
	 getFocus: function(){
	 var me = this;
	 me.on('focus',function(){
	 me.setValue(null);
	 me.store.loadPage(1,{
	 scope: this,
	 callback: function(records, operation, success) {
	 if(records.length>0){
	 me.expand();
	 }
	 }
	 });
	 });
	 },*/
	/*getCallParent: function(){
	 var me = this,
	 cmp;
	 if(!Ext.isEmpty(me.parentParamsAndItemIds)){
	 Ext.Object.each(me.parentParamsAndItemIds, function(queryParam, itemId, parentParamsAndItemIds) {
	 cmp = me.up().items.get(itemId);
	 if(!cmp.hasListener('select')){
	 cmp.on('select',function(combo){
	 me.setValue(null);
	 me.store.loadPage(1,{
	 scope: this,
	 callback: function(records, operation, success) {
	 me.focus(false, 100);
	 me.expand();
	 }
	 });
	 });
	 }
	 });
	 }
	 },*/
    triggers:{
        clear : {
            cls : 'x-form-clear-trigger',
            handler : function(){
                this.setRawValue(null);
                this.setValue(null);
                this.realValue = null;
                this.getTrigger('clear').hide();
            },
            hidden : true
        }
    },
    initComponent:function(){
        var me = this;
		/*me.on('boxready',function(){
		 var callparent = null;
		 for(var i = 0;i<me.eventType.length;i++){
		 if(me.eventType[i]=='focus'){
		 me.getFocus();
		 }else if(me.eventType[i]=='callparent'){
		 callparent = 'callparent';
		 me.getCallParent();
		 }
		 }
		 //调用父类方法会自动包含focus事件
		 if(callparent=='callparent'){
		 me.un('focus');
		 }
		 });*/
        this.callParent(arguments);
        //增加级联查询条件
        me.store.on('beforeLoad', function(st,operation,e){
            var cmp=null, searchParams=operation.getParams();
            if(Ext.isEmpty(searchParams)){
                searchParams={};
            }
            searchParams[me.queryParam] = me.rawValue;
            if(!Ext.isEmpty(me.parentParamsAndItemIds)){
                Ext.Object.each(me.parentParamsAndItemIds, function(queryParam, itemId, parentParamsAndItemIds) {
                    cmp = me.up().items.get(itemId);
                    searchParams[queryParam] = cmp.getValue();
                });
            }
            Ext.apply(st.proxy.extraParams, searchParams);
        });
    }
});


/**
 * #########################################
 * #######      数据字典下拉框开始          #######
 * #########################################
 */
//数据字典下拉单选框
Ext.define('Caiwei.commonSelector.DataDictionaryCommonSelector', {
    extend : 'Ext.form.field.ComboBox',
    alias: 'widget.dataDictionarySelector',
    displayField: 'valueName',
    valueField: 'valueCode',
    queryMode : 'local',
    editable : false,
    setTermsCode:function(termsCode){
        var store = getDataDictionary().getDataDictionaryStore(termsCode);
        if(!Ext.isEmpty(store)&&!Ext.isEmpty(this.anyRecords)){
            store.insert(0,this.anyRecords);
        }
        this.setStore(store);
    },

    constructor : function(config) {
        var me = this, cfg = Ext.apply({}, config);
        var store = getDataDictionary().getDataDictionaryStore(config.termsCode);
        if(!Ext.isEmpty(store)&&!Ext.isEmpty(config.anyRecords)){
            //store.add(config.anyRecords);
            store.insert(0,config.anyRecords);//新增的数据在第一个位置(“全部”)
        }
        me.store = store;
        me.callParent([cfg]);
    }
});
/**
 * #########################################
 * #######      数据字典下拉框结束          #######
 * #########################################
 */

/**
 * #########################################
 * #######      是否下拉框开始          #######
 * #########################################
 */
Ext.define('Caiwei.model.baseinfo.YesNoModel',{
    extend : 'Ext.data.Model',
    fields : [{
        name : 'name',
        type : 'string'
    },{
        name : 'value',
        type : 'string'
    }]
});
Ext.define('Caiwei.commonSelector.YesNoAllStore', {
    extend : 'Ext.data.Store',
    model: 'Caiwei.model.baseinfo.YesNoModel',
    data : [{'name':'全部','value':''},{'name':'是','value':'Y'},{'name':'否','value':'N'}]
});
Ext.define('Caiwei.commonSelector.YesNoStore', {
    extend : 'Ext.data.Store',
    model: 'Caiwei.model.baseinfo.YesNoModel',
    data : [{'name':'是','value':'Y'},{'name':'否','value':'N'}]
});
Ext.define('Caiwei.commonSelector.YesOrNoSelector', {
    extend : 'Ext.form.ComboBox',
    alias : 'widget.yesnocombselector',
    listWidth : this.width,// 下拉列表宽度，从外面传入
    multiSelect : false,// 从外面传入
    displayField : 'name',// 显示名称
    valueField : 'value',// 值
    isShowAll : false,// 是否显示全部
    constructor : function(config) {
        var me = this,
            cfg = Ext.apply({}, config);
        if (config.isShowAll){
            me.store = Ext.create('Caiwei.commonSelector.YesNoAllStore');
        }else{
            me.store = Ext.create('Caiwei.commonSelector.YesNoStore');
        }
        me.callParent([cfg]);
    }
});
//是和否checkBox
Ext.define('Caiwei.commonCheckBox.YesOrNoCheckBox', {
    extend : 'Ext.form.field.Checkbox',
    alias : 'widget.yesnocheckbox',
    inputValue: 'Y',         //选中的值
    uncheckedValue: 'N',
    getValue : function(){
        if(this.checked){
            return 'Y';
        }else{
            return 'N';
        }
    }
});
/**
 * #########################################
 * #######      是否下拉框结束          #######
 * #########################################
 */

/**
 * #########################################
 * #######      附件上传按钮开始          #######
 * #########################################
 */
//数据字典下拉单选框
Ext.define('Caiwei.manage.FileUploads', {
    extend : 'Ext.container.Container',
    alias: 'widget.fileUploadsButton',
    displayField: 'valueName',
    valueField: 'valueCode',
    queryMode : 'local',
    editable : false,
    xtype: 'form-fileuploads',
    controller: 'form-fileuploads',
    items: [{
        items: [ {
            xtype: 'filefield',
            hideLabel: true,
            reference: 'basicFile'
        }]
    }]
});
/**
 * #########################################
 * #######      附件上传按钮结束          #######
 * #########################################
 */

