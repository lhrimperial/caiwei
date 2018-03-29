/**
 * 数据字典词条model
 */
Ext.define('Caiwei.model.TermsCodeDO', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'termsCode',
        // 词条编码
        type: 'string'
    },{
        name: 'termsName',
        // 词条名称
        type: 'string'
    },{
        name: 'active',
        // 是否可用
        type: 'string'
    },{
        name: 'notes',
        // 备注
        type: 'string'
    }]
});

/**
 * 数据字典值model
 */
Ext.define('Caiwei.model.TermsValueDO', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'tid',
        // 词条编码
        type: 'int'
    },{
        name: 'termsName',
        // 词条编码
        type: 'string'
    },{
        name: 'termsCode',
        // 词条编码
        type: 'string'
    },{
        name: 'valueName',
        // 值名称
        type: 'string'
    },{
        name: 'valueCode',
        // 值代码
        type: 'string'
    },{
        name: 'valueSeq',
        // 顺序
        type: 'string'
    },{
        name: 'active',
        // 是否可用
        type: 'string'
    },{
        name: 'notes',
        // 备注
        type: 'string'
    }]
});

/**
 * 数据字典词条名称下拉框store
 */
Ext.define('Caiwei.commonSelector.DataDictionaryStore', {
    extend: 'Ext.data.Store',
    model: 'Caiwei.model.TermsCodeDO',
    proxy: {
        type: 'ajax',
        url: 'queryDataDictionaryByTermsCode',
        actionMethods: 'POST',
        reader: {
            type: 'json',
            root: 'termsCodeDOS'
        }
    }
});
/**
 * 数据字典信息store
 */
Ext.define('Caiwei.store.DataDictionaryValueStore', {
    extend: 'Ext.data.Store',
    model: 'Caiwei.model.TermsValueDO',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'queryDataDictionaryValueByTermsValue',
        reader: {
            type: 'json',
            rootProperty: 'termsValueDOS',
            totalProperty: 'totalCount' // 总个数
        }
    },
    listeners: {
        beforeload: function(store, operation, eOpts) {
            var queryForm = Ext.getCmp('queryForm');
            if (queryForm != null) {
                var params = {
                    'termsValueDO.termsCode': queryForm.getForm().findField('termsCode').getValue(),
                    'termsValueDO.valueCode': queryForm.getForm().findField('valueCode').getValue(),
                    'termsValueDO.valueName': queryForm.getForm().findField('valueName').getValue(),
                    'termsValueDO.active': queryForm.getForm().findField('active').getValue()
                };
                Ext.apply(store.proxy.extraParams, params);
            }
        }
    }
});

/**
 * 数据字典词条名称下拉框
 */
Ext.define('Caiwei.selector.DataDictionarySelector', {
    extend: 'Caiwei.commonSelector.CommonCombSelector',
    alias: 'widget.datadictionaryselector',
    displayField: 'termsName',
    // 显示名称
    valueField: 'termsCode',
    // 值
    queryParam: 'termsCodeDO.termsName',
    selectCall: function (comb, records, obs) {
        var termsNmaeText = Ext.getCmp('caiwei_form_terms_name')
        if(termsNmaeText != null) {
            termsNmaeText.setValue(records.data.termsName);
        }
    },
    // 查询参数
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.store = Ext.create('Caiwei.commonSelector.DataDictionaryStore');
        me.callParent([cfg]);
    }
});

/**
 * 查询表单
 */
Ext.define('Caiwei.view.dataDictionary.QueryForm', {
    extend: 'Ext.form.Panel',
    id: 'queryForm',
    frame: true,
    title : '查询条件',
    height: 120,
    collapsible: true,
    layout: 'hbox',
    defaults: {
        colspan: 1,
        margin: '8 10 5 10',
        labelAlign : 'right'
    },
    defaultType: 'textfield',
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},config);

        me.items = [{
            name: 'termsCode',
            fieldLabel:  '词条名称',
            width: 250,
            xtype: 'datadictionaryselector'
        },{
            name: 'valueCode',
            fieldLabel: '值编码',
            width: 250,
            xtype: 'textfield'
        },{
            name: 'valueName',
            fieldLabel: '值名称',
            width: 250,
            xtype: 'textfield'
        },{
            name: 'active',
            fieldLabel: '是否有效',
            value: 'Y',
            width: 250,
            isShowAll: true,
            xtype: 'yesnocombselector'
        }],
            me.buttons = [{
                text: '查询',
                handler: function() {
                    if (me.getForm().isValid()) {
                        me.up().getDataDictionaryGrid().getPagingToolbar().moveFirst();;
                    }
                }
            },{
                text: '清除',
                handler: function() {
                    me.getForm().reset();
                }
            }];
        me.callParent([cfg]);
    }
});

/**
 * 数据字典信息表格
 */
Ext.define('Caiwei.view.dataDictionary.TermsValueGrid', {
    extend: 'Ext.grid.Panel',
    frame: true,
    autoScroll: true,
    height: console.getBrowserHeight() - 120,
    stripeRows: true,
    // 交替行效果
    selType: "rowmodel",
    // 选择类型设置为：行选择
    emptyText: '查询结果为空',
    // 查询结果为空
    columnLines: true,
    viewConfig: {
        enableTextSelection: true
    },
    dataDictionaryValueAddWindow: null,
    getDataDictionaryValueAddWindow: function() {
        if (this.dataDictionaryValueAddWindow == null) {
            this.dataDictionaryValueAddWindow = Ext.create('Caiwei.view.dataDictionary.DataDictionaryValueAddWindow');
            this.dataDictionaryValueAddWindow.parent = this; // 父元素
        }
        return this.dataDictionaryValueAddWindow;
    },
    dataDictionaryValueUpdateWindow: null,
    getDataDictionaryValueUpdateWindow: function() {
        if (this.dataDictionaryValueUpdateWindow == null) {
            this.dataDictionaryValueUpdateWindow = Ext.create('Caiwei.view.dataDictionary.DataDictionaryValueUpdateWindow');
            this.dataDictionaryValueUpdateWindow.parent = this; // 父元素
        }
        return this.dataDictionaryValueUpdateWindow;
    },
    changeDataDictionaryValue: function () {
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length != 1) { // 判断是否选中了一条
            console.showWoringMessage('请选择一条进行修改'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var id = selections[0].get('tid');
        var params = {
            'termsValueDO': {
                'tid' : id
            }
        }

        var successFun = function (json) {
            var updateWindow = me.getDataDictionaryValueUpdateWindow(); //获得修改窗口
            updateWindow.termsValueDO = json.result.termsValueDO;
            updateWindow.show(); //显示修改窗口
            updateWindow.getDataDictionaryUpdateForm().getForm().findField('tid').setValue(updateWindow.termsValueDO.tid);
            updateWindow.getDataDictionaryUpdateForm().getForm().findField('termsCode').setValue(updateWindow.termsValueDO.termsCode);
            updateWindow.getDataDictionaryUpdateForm().getForm().findField('termsName').setValue(updateWindow.termsValueDO.termsName);
            updateWindow.getDataDictionaryUpdateForm().getForm().findField('valueCode').setValue(updateWindow.termsValueDO.valueCode);
            updateWindow.getDataDictionaryUpdateForm().getForm().findField('valueName').setValue(updateWindow.termsValueDO.valueName);
            updateWindow.getDataDictionaryUpdateForm().getForm().findField('valueSeq').setValue(updateWindow.termsValueDO.valueSeq);
            updateWindow.getDataDictionaryUpdateForm().getForm().findField('notes').setValue(updateWindow.termsValueDO.notes);
            updateWindow.getDataDictionaryUpdateForm().getForm().findField('active').setValue(updateWindow.termsValueDO.active);
        };
        var failureFun = function (json) {
            if (Ext.isEmpty(json)) {
                console.showErrorMes('请求超时'); //请求超时
            } else {
                var message = json.resMsg;
                console.showErrorMes(message);
            }
        };
        console.requestJsonAjax('findDataDictionaryById', params, successFun, failureFun);
    },
    dataDictionaryAddWindow: null,
    getDataDictionaryAddWindow: function() {
        if (this.dataDictionaryAddWindow == null) {
            this.dataDictionaryAddWindow = Ext.create('Caiwei.view.dataDictionary.DataDictionaryAddWindow');
            this.dataDictionaryAddWindow.parent = this; // 父元素
        }
        return this.dataDictionaryAddWindow;
    },
    pagingToolbar: null,
    getPagingToolbar: function() {
        if (this.pagingToolbar == null) {
            this.pagingToolbar = Ext.create('Ext.toolbar.Paging', {
                store: this.store,
                pageSize: 20
            });
        }
        return this.pagingToolbar;
    },
    deleteDataDictionaryValue: function() {
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length < 1) { // 判断是否至少选中了一条
            console.showWoringMessage('请选择一条进行作废操作！'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var dataDictionaryValueEntityList = new Array();
        for (var i = 0; i < selections.length; i++) {
            dataDictionaryValueEntityList.push({
                'tid': selections[i].get('tid'),
                'valueCode': selections[i].get('valueCode'),
                'termsCode' : selections[i].get('termsCode')
            });
        }
        console.showQuestionMes('是否删除?',//是否删除
            function(e) {
                if (e == 'yes') { // 询问是否删除，是则发送请求
                    var params = {
                        'termsValueDOS':  dataDictionaryValueEntityList
                    };
                    var successFun = function(json) {
                        var message = json.resMsg;
                        console.showInfoMsg(message);
                        me.getStore().load();
                    };
                    var failureFun = function(json) {
                        if (Ext.isEmpty(json)) {
                            console.showErrorMes('请求超时'); // 请求超时
                        } else {
                            var message = json.resMsg;
                            console.showErrorMes(message);
                        }
                    };
                    console.requestJsonAjax('deleteDataDictionaryValue', params, successFun, failureFun);
                }
            });
    },
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.columns = [{
            dataIndex: 'termsName',
            width: 200,
            text: '词条名称'
        },{
            dataIndex: 'termsCode',
            width: 200,
            text: '词条编码'
        },{
            text: '值代码',
            dataIndex: 'valueCode',
            width: 200
        },{
            text: '值名称',
            dataIndex: 'valueName',
            width: 200
        },{
            text: '顺序',
            dataIndex: 'valueSeq',
            width: 100
        },{
            text: '是否有效',
            dataIndex: 'active',
            width: 100,
            renderer: function(value) {
                if (value == 'N') {
                    return "否";
                } else {
                    return "是";
                }
            }
        },{
            text: '备注',
            dataIndex: 'notes',
            width: 200
        }],
            me.store = Ext.create('Caiwei.store.DataDictionaryValueStore', {
                autoLoad: false
            });
        me.selModel = Ext.create('Ext.selection.CheckboxModel', { // 多选框
            mode: 'MULTI',
            checkOnly: true
        });
        me.tbar = [{
            text: '新增词条',
            xtype: 'addbutton',
            // 新增
            // hidden:!baseinfo.dataDictionary.isPermission('dataDictionary/dataDictionaryAddButton'),
            handler: function() {
                me.getDataDictionaryAddWindow().show();
            }
        },'-', {
            text: '新增数据字典',
            xtype: 'addbutton',
            handler: function() {
                me.getDataDictionaryValueAddWindow().show();
            }
        }, '-', {
            text: '修改数据字典',
            xtype: 'updatebutton',
            handler: function() {
                me.changeDataDictionaryValue();
            }
        }, '-', {
            id : 'caiwei_bseinfo_datadictionary_del_id',
            text: '删除',
            xtype: 'deletebutton',
            disabled : true,
            handler: function() {
                me.deleteDataDictionaryValue();
            }
        }];
        me.bbar = me.getPagingToolbar();
        me.selModel = Ext.create('Ext.selection.CheckboxModel', {
            listeners: {
                selectionchange: function(sm, selections) {
                    Ext.getCmp('caiwei_bseinfo_datadictionary_del_id').setDisabled(selections.length === 0);
                }
            }}),
            me.callParent([cfg]);
    }
});

/**
 *修改数据字典表单
 */
Ext.define('Caiwei.view.dataDictionary.DataDictionaryValueUpdateForm', {
    extend: 'Ext.form.Panel',
    header: false,
    frame: true,
    collapsible: true,
    width: 300,
    fieldDefaults: {
        labelWidth: 100,
        margin: '8 10 5 10'
    },
    defaultType: 'textfield',
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.items = [{
            name: 'tid',
            fieldLabel: 'ID',
            xtype: 'textfield',
            hidden:true
        },{
            name: 'termsCode',
            fieldLabel: '词条编码',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            readOnly:true
        },{
            name: 'termsName',
            fieldLabel: '词条名称',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            readOnly: true
        },{
            name: 'valueCode',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            fieldLabel: '值编码',
            readOnly: true
        },{
            xtype: 'textfield',
            name: 'valueName',
            fieldLabel: '值名称',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'valueSeq',
            fieldLabel: '值排序',
            xtype: 'numberfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            xtype: 'textarea',
            name: 'notes',
            fieldLabel: '备注'
        },{
            xtype: 'yesnocombselector',
            name: 'active',
            fieldLabel: '是否可用'
        }];
        me.callParent([cfg]);
    }
});

/**
 * 修改数据字典窗口
 */
Ext.define('Caiwei.view.dataDictionary.DataDictionaryValueUpdateWindow', {
    extend: 'Ext.window.Window',
    title: '修改数据字典',
    closable: true,
    parent: null,
    // 父元素
    modal: true,
    resizable: false,
    // 可以调整窗口的大小
    closeAction: 'hide',
    // 点击关闭是隐藏窗口
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    listeners: {
        beforehide: function(me) { // 隐藏WINDOW的时候清除数据
            me.getDataDictionaryUpdateForm().getForm().reset(); // 表格重置
        },
        beforeshow: function(me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getDataDictionaryUpdateForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function(item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    dataDictionaryUpdateForm: null,
    getDataDictionaryUpdateForm: function() {
        if (Ext.isEmpty(this.dataDictionaryUpdateForm)) {
            this.dataDictionaryUpdateForm = Ext.create('Caiwei.view.dataDictionary.DataDictionaryValueUpdateForm');
        }
        return this.dataDictionaryUpdateForm;
    },
    submitDataDictionaryValue: function() {
        var me = this;
        if (me.getDataDictionaryUpdateForm().getForm().isValid()) { // 校验form是否通过校验
            var dataModel = new Caiwei.model.TermsValueDO();
            me.getDataDictionaryUpdateForm().getForm().updateRecord(dataModel); // 将FORM中数据设置到MODEL里面
            var params = {
                'termsValueDO': dataModel.data
            }
            var successFun = function(json) {
                var message = json.resMsg;
                console.showInfoMsg(message); // 提示新增成功
                me.close();
                me.parent.getStore().load(); // 成功之后重新查询刷新结果集
            };
            var failureFun = function(json) {
                if (Ext.isEmpty(json)) {
                    console.showErrorMes('连接超时'); // 请求超时
                } else {
                    var message = json.resMsg;
                    console.showErrorMes(message); // 提示失败原因
                }
            };
            console.requestJsonAjax('updateDataDictionary', params, successFun, failureFun); //  发送AJAX请求
        }
    },
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.fbar = [{
            text: '取消',
            // 取消
            handler: function() {
                me.close();
            }
        },{
            text: '保存',
            handler: function() {
                me.submitDataDictionaryValue();
            }
        }];
        me.items = [me.getDataDictionaryUpdateForm()];
        me.callParent([cfg]);
    }
});


/**
 * 新增数据字典窗口
 */
Ext.define('Caiwei.view.dataDictionary.DataDictionaryValueAddWindow', {
    extend: 'Ext.window.Window',
    title: '新增数据字典',
    closable: true,
    parent: null,
    // 父元素
    modal: true,
    resizable: false,
    // 可以调整窗口的大小
    closeAction: 'hide',
    // 点击关闭是隐藏窗口
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    listeners: {
        beforehide: function(me) { // 隐藏WINDOW的时候清除数据
            me.getDataDictionaryValueForm().getForm().reset(); // 表格重置
        },
        beforeshow: function(me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getDataDictionaryValueForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function(item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    dataDictionaryValueForm: null,
    getDataDictionaryValueForm: function() {
        if (Ext.isEmpty(this.dataDictionaryValueForm)) {
            this.dataDictionaryValueForm = Ext.create('Caiwei.view.dataDictionary.DataDictionaryValueForm');
        }
        return this.dataDictionaryValueForm;
    },
    submitDataDictionaryValue: function() {
        var me = this;
        if (me.getDataDictionaryValueForm().getForm().isValid()) { // 校验form是否通过校验
            var dataDictionaryValueModel = new Caiwei.model.TermsValueDO();
            me.getDataDictionaryValueForm().getForm().updateRecord(dataDictionaryValueModel); // 将FORM中数据设置到MODEL里面
            var params = {
                'termsValueDO':  dataDictionaryValueModel.data
            }
            var successFun = function(json) {
                var message = json.resMsg;
                console.showInfoMsg(message); // 提示新增成功
                me.close();
                me.parent.getStore().load(); // 成功之后重新查询刷新结果集
            };
            var failureFun = function(json) {
                if (Ext.isEmpty(json)) {
                    console.showErrorMes('请求超时!'); // 请求超时
                } else {
                    var message = json.resMsg;
                    console.showErrorMes(message); // 提示失败原因
                }
            };
            console.requestJsonAjax('addTermsValue', params, successFun, failureFun); // 发送AJAX请求
        }
    },
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.fbar = [{
            text: '取消',
            // 取消
            handler: function() {
                me.close();
            }
        },{
            text: '重置',
            // 重置
            handler: function() {
                me.getDataDictionaryValueForm().reset();
            }
        },
            {
                text: '保存',
                // 保存
                /* margin : '0 0 0 55', */
                handler: function() {
                    me.submitDataDictionaryValue();
                }
            }];
        me.items = [me.getDataDictionaryValueForm()];
        me.callParent([cfg]);
    }
});

/**
 * 数据字典表单
 */
Ext.define('Caiwei.view.dataDictionary.DataDictionaryValueForm', {
    extend: 'Ext.form.Panel',
    header: false,
    frame: true,
    collapsible: true,
    width: 280,
    fieldDefaults: {
        labelWidth: 80,
        margin: '8 10 5 10'
    },
    defaultType: 'textfield',
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.items = [{
            name: 'termsName',
            fieldLabel: '词条名称',
            xtype: 'textfield',
            allowBlank: false,
            hidden: true,
            id: 'caiwei_form_terms_name'
        },{
            name: 'termsCode',
            fieldLabel: '词条编码',
            xtype: 'datadictionaryselector',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'valueName',
            fieldLabel: '值名称',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'valueCode',
            fieldLabel: '值编码',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'valueSeq',
            fieldLabel:'序号',
            xtype: 'numberfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'notes',
            fieldLabel: '备注',
            xtype: 'textarea'
        }];
        me.callParent([cfg]);
    }
});

Ext.define('Caiwei.view.dataDictionary.DataDictionaryAddWindow', {
    extend: 'Ext.window.Window',
    title:  '新增词条',
    closable: true,
    parent: null,
    // 父元素
    modal: true,
    resizable: false,
    // 可以调整窗口的大小
    closeAction: 'hide',
    // 点击关闭是隐藏窗口
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    listeners: {
        beforehide: function(me) { // 隐藏WINDOW的时候清除数据
            me.getDataDictionaryForm().getForm().reset(); // 表格重置
        },
        beforeshow: function(me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getDataDictionaryForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function(item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    dataDictionaryForm: null,
    getDataDictionaryForm: function() {
        if (Ext.isEmpty(this.dataDictionaryForm)) {
            this.dataDictionaryForm = Ext.create('Caiwei.view.dataDictionary.DataDictionaryForm');
        }
        return this.dataDictionaryForm;
    },
    submitDataDictionaryValue: function() {
        var me = this;
        if (me.getDataDictionaryForm().getForm().isValid()) { // 校验form是否通过校验
            var dataDictionaryModel = new Caiwei.model.TermsCodeDO();
            me.getDataDictionaryForm().getForm().updateRecord(dataDictionaryModel); // 将FORM中数据设置到MODEL里面
            var params = {
                'termsCodeDO': dataDictionaryModel.data
            }
            var successFun = function(json) {
                var message = json.resMsg;
                console.showInfoMsg(message); // 提示新增成功
                me.close();
                me.parent.getStore().load(); // 成功之后重新查询刷新结果集
            };
            var failureFun = function(json) {
                if (Ext.isEmpty(json)) {
                    console.showErrorMes('请求超时!'); // 请求超时
                } else {
                    var message = json.resMsg;
                    console.showErrorMes(message); // 提示失败原因
                }
            };
            console.requestJsonAjax('addTermsCode', params, successFun, failureFun); // 发送AJAX请求
        }
    },
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.fbar = [{
            text:  '取消',
            // 取消
            handler: function() {
                me.close();
            }
        },{
            text: '重置',
            // 重置
            handler: function() {
                me.getDataDictionaryForm().reset();
            }
        },{
            text: '保存',
            // 保存
            /* margin : '0 0 0 55', */
            handler: function() {
                me.submitDataDictionaryValue();
            }
        }];
        me.items = [me.getDataDictionaryForm()];
        me.callParent([cfg]);
    }
});

/**
 * 数据字典词条表单
 */
Ext.define('Caiwei.view.dataDictionary.DataDictionaryForm', {
    extend: 'Ext.form.Panel',
    header: false,
    frame: true,
    collapsible: true,
    width: 280,
    fieldDefaults: {
        labelWidth: 80,
        margin: '8 10 5 10'
    },
    defaultType: 'textfield',
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},config);

        me.items = [{
            name: 'termsName',
            fieldLabel: '词条名称',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'termsCode',
            fieldLabel: '词条编码',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'notes',
            fieldLabel: '备注',
            xtype: 'textarea'
        }];
        me.callParent([cfg]);
    }
});

Ext.onReady(function() {
    /**
     * 数据字典页面
     */
    Ext.QuickTips.init();
    var queryForm = Ext.create('Caiwei.view.dataDictionary.QueryForm'); //查询FORM
    var dataDictionaryGrid = Ext.create('Caiwei.view.dataDictionary.TermsValueGrid');
    Ext.create('Ext.panel.Panel', {
        renderTo: Ext.getBody(),
        getQueryForm: function() {
            return queryForm;
        },
        getDataDictionaryGrid: function() {
            return dataDictionaryGrid;
        },
        items: [queryForm, dataDictionaryGrid]
    });
});