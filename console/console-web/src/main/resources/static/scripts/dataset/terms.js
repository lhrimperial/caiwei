/**
 * 数据字典词条model
 */
Ext.define('Caiwei.dataset.TermsCodeDO', {
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
 * 词条store
 */
Ext.define('Caiwei.dataset.TermsCodeStore', {
    extend: 'Ext.data.Store',
    model: 'Caiwei.dataset.TermsCodeDO',
    proxy: {
        type: 'ajax',
        url: 'queryDataDictionaryByTermsCode',
        actionMethods: 'POST',
        reader: {
            type: 'json',
            root: 'termsCodeDOS'
        }
    },
    listeners: {
        beforeload: function (store, operation, eOpts) {
            var queryForm = Ext.getCmp('termsCodeQueryForm');
            if (queryForm != null) {
                var params = {
                    'termsCodeDO.termsCode': queryForm.getForm().findField('termsCode').getValue(),
                    'termsCodeDO.termsName': queryForm.getForm().findField('termsName').getValue(),
                    'termsCodeDO.active' : queryForm.getForm().findField('active').getValue()
                };
                Ext.apply(store.proxy.extraParams, params);
            }
        }
    }
});

/**
 * Role Query Form
 */
Ext.define('Caiwei.dataset.TermsCodeQueryForm', {
    extend: 'Ext.form.Panel',
    id: 'termsCodeQueryForm',
    frame: true,
    header: false,
    height: 88,
    collapsible: true,
    layout: 'column',
    region: 'north',
    bodyStyle:'padding:6px;',
    labelStyle : "text-align:right;width:40;",
    default: {
        margin: '5 10 5 0',
        labelWidth: 40,
        columnWidth: 0.2,
        labelAlign: 'right'
    },
    defaultType: 'textfield',
    constructor: function (config) {
        var me = this,
            cfg = Ext.apply({}, config);
        me.items = [{
            name: 'termsCode',
            fieldLabel: '词条编码',
            xtype: 'textfield'
        }, {
            name: 'termsName',
            fieldLabel: '词条名称',
            xtype: 'textfield'
        }, {
            style:'margin-top:5px;',
            name: 'active',
            fieldLabel: '是否可用',
            xtype: 'yesnocombselector',
            value: 'Y',
            isShowAll : true// 是否显示全部
        }],
            me.buttons = [{
                text: '查询',
                handler: function () {
                    if (me.getForm().isValid()) {
                        me.up().getTermsCodeGrid().getPagingToolbar().moveFirst();
                    }
                }
            }, {
                text: '清空',
                handler: function () {
                    me.getForm().reset();
                }
            }];
        me.callParent([cfg]);
    }
});

/**
 * 用户角色信息
 */
Ext.define('Caiwei.dataset.TermsCodeGrid', {
    extend: 'Ext.grid.Panel',
    frame: true,
    autoScroll: true,
    width: '100%',
    height: document.documentElement.clientHeight - 150,
    stripeRows: true,
    // 交替行效果
    region: 'center',
    emptyText: '查询结果为空',
    selModel: Ext.create('Ext.selection.CheckboxModel', {
        listeners: {
            selectionchange: function (sm, selections) {
                Ext.getCmp('caiwei_dataset_termscode_deletebtn_id').setDisabled(selections.length === 0);
                Ext.getCmp('caiwei_dataset_termscode_updatebtn_id').setDisabled(selections.length === 0);
            }
        }
    }),
    termsCodeAddWindow: null,
    getTermsCodeAddWindow: function () {
        if (this.termsCodeAddWindow == null) {
            this.termsCodeAddWindow = Ext.create('Caiwei.dataset.TermsCodeAddWindow');
            this.termsCodeAddWindow.parent = this; // 父元素
        }
        return this.termsCodeAddWindow;
    },
    termsCodeUpdateWindow: null,
    getTermsCodeUpdateWindow: function () {
        if (this.termsCodeUpdateWindow == null) {
            this.termsCodeUpdateWindow = Ext.create('Caiwei.dataset.TermsCodeUpdateWindow');
            this.termsCodeUpdateWindow.parent = this; // 父元素
        }
        return this.termsCodeUpdateWindow;
    },
    updateTermsCode : function(){
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length != 1) { // 判断是否选中了一条
            console.showWoringMessage('请选择一条进行修改'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var id = selections[0].get('tid');
        var params = {
            'termsCodeDO': {
                'tid' : id
            }
        }

        var successFun = function (json) {
            var updateWindow = me.getTermsCodeUpdateWindow(); //获得修改窗口
            updateWindow.termsCodeDO = json.result.termsCodeDO;
            updateWindow.show(); //显示修改窗口
            updateWindow.getTermsCodeUpdateForm().getForm().findField('tid').setValue(updateWindow.termsCodeDO.tid);
            updateWindow.getTermsCodeUpdateForm().getForm().findField('termsCode').setValue(updateWindow.termsCodeDO.termsCode);
            updateWindow.getTermsCodeUpdateForm().getForm().findField('termsName').setValue(updateWindow.termsCodeDO.termsName);
            updateWindow.getTermsCodeUpdateForm().getForm().findField('notes').setValue(updateWindow.termsCodeDO.notes);
            updateWindow.getTermsCodeUpdateForm().getForm().findField('active').setValue(updateWindow.termsCodeDO.active);
        };
        var failureFun = function (json) {
            if (Ext.isEmpty(json)) {
                console.showErrorMes('请求超时'); //请求超时
            } else {
                var message = json.resMsg;
                console.showErrorMes(message);
            }
        };
        console.requestJsonAjax('findTermsCodeByID', params, successFun, failureFun);
    },
    deleteTermsCode: function () {
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length < 1) { // 判断是否至少选中了一条
            console.showWoringMessage('请选择一条进行删除操作'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var termsCodes = new Array();
        for (var i = 0; i < selections.length; i++) {
            termsCodes.push(selections[i].get('termsCode'));
        }
        console.showQuestionMes('是否要删除',
            function (e) {
                if (e == 'yes') { // 询问是否删除，是则发送请求
                    var params = {
                        'termsCodes': termsCodes
                    };
                    var successFun = function (json) {
                        var message = json.resMsg;
                        console.showInfoMsg(message);
                        me.getStore().load();
                    };
                    var failureFun = function (json) {
                        if (Ext.isEmpty(json)) {
                            console.showErrorMes('请求超时'); // 请求超时
                        } else {
                            var message = json.resMsg;
                            console.showErrorMes(message);
                        }
                    };
                    console.requestJsonAjax('deleteTermsCode', params, successFun, failureFun);
                }
            });
    },
    pagingToolbar: null,
    getPagingToolbar: function () {
        if (this.pagingToolbar == null) {
            this.pagingToolbar = Ext.create('Ext.toolbar.Paging', {
                store: this.store,
                pageSize: 20
            });
        }
        return this.pagingToolbar;
    },
    constructor: function (config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.columns = [{
            text: '序号',
            width: 60,
            xtype: 'rownumberer',
            align: 'center'
        },{
            dataIndex: 'tid',
            hidden: true
        },{
            text: '词条编码',
            dataIndex: 'termsCode',
            align: 'center',
            flex: 1
        }, {
            text: '词条名称',
            dataIndex: 'termsName',
            align: 'center',
            flex: 1
        },{
            text: '备注',
            dataIndex: 'notes',
            align: 'center',
            flex: 1
        }, {
            text: '创建时间',
            dataIndex: 'createTime',
            align: 'center',
            flex: 1,
            renderer: function(value) {
                return timeRender(value);
            }
        }, {
            text: '修改时间',
            dataIndex: 'modifyTime',
            align: 'center',
            flex: 1,
            renderer: function(value) {
                return timeRender(value);
            }
        }, {
            text: '是否有效',
            dataIndex: 'active',
            align: 'center',
            flex: 1,
            renderer: function(value) {
                if (value == 'N') {
                    return "否";
                } else {
                    return "是";
                }
            }
        }],
        me.tbar = [{
            text: '新增词条',
            xtype: 'addbutton',
            handler: function () {
                me.getTermsCodeAddWindow().show();
            }
        },{
            id: 'caiwei_dataset_termscode_updatebtn_id',
            text: '修改词条',
            xtype: 'updatebutton',
            disabled: true,
            handler: function () {
                me.updateTermsCode();
            }
        },{
            id: 'caiwei_dataset_termscode_deletebtn_id',
            xtype: 'deletebutton',
            text: '删除',
            disabled: true,
            handler: function () {
                me.deleteTermsCode();
            }
        }];
        me.store = Ext.create('Caiwei.dataset.TermsCodeStore');
        me.bbar = me.getPagingToolbar();
        me.callParent([cfg]);
    }
});

/**
 *修改词条表单
 */
Ext.define('Caiwei.dataset.TermsCodeUpdateForm', {
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
            readOnly:true
        },{
            name: 'termsName',
            fieldLabel: '词条名称',
            xtype: 'textfield',
            allowBlank: false
        },{
            xtype: 'textarea',
            name: 'notes',
            fieldLabel: '备注'
        },{
            xtype: 'yesnocombselector',
            name: 'active',
            fieldLabel: '是否有效'
        }];
        me.callParent([cfg]);
    }
});

/**
 * 修改词条
 */
Ext.define('Caiwei.dataset.TermsCodeUpdateWindow', {
    extend: 'Ext.window.Window',
    title: '修改词条',
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
            me.getTermsCodeUpdateForm().getForm().reset(); // 表格重置
        },
        beforeshow: function(me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getTermsCodeUpdateForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function(item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    termsCodeUpdateForm: null,
    getTermsCodeUpdateForm: function() {
        if (Ext.isEmpty(this.termsCodeUpdateForm)) {
            this.termsCodeUpdateForm = Ext.create('Caiwei.dataset.TermsCodeUpdateForm');
        }
        return this.termsCodeUpdateForm;
    },
    submitTermsCodeValue: function() {
        var me = this;
        if (me.getTermsCodeUpdateForm().getForm().isValid()) { // 校验form是否通过校验
            var termsCodeModel = new Caiwei.dataset.TermsCodeDO();
            me.getTermsCodeUpdateForm().getForm().updateRecord(termsCodeModel); // 将FORM中数据设置到MODEL里面
            var params = {
                'termsCodeDO': termsCodeModel.data
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
            console.requestJsonAjax('updateTermsCode', params, successFun, failureFun); //  发送AJAX请求
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
                me.submitTermsCodeValue();
            }
        }];
        me.items = [me.getTermsCodeUpdateForm()];
        me.callParent([cfg]);
    }
});

Ext.define('Caiwei.dataset.TermsCodeAddWindow', {
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
            me.getTermsCodeForm().getForm().reset(); // 表格重置
        },
        beforeshow: function(me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getTermsCodeForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function(item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    termsCodeAddForm: null,
    getTermsCodeForm: function() {
        if (Ext.isEmpty(this.termsCodeAddForm)) {
            this.termsCodeAddForm = Ext.create('Caiwei.dataset.DataDictionaryForm');
        }
        return this.termsCodeAddForm;
    },
    submitTermsCodeValue: function() {
        var me = this;
        if (me.getTermsCodeForm().getForm().isValid()) { // 校验form是否通过校验
            var termsCode = new Caiwei.model.TermsCodeDO();
            me.getTermsCodeForm().getForm().updateRecord(termsCode); // 将FORM中数据设置到MODEL里面
            var params = {
                'termsCodeDO': termsCode.data
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
                me.getTermsCodeForm().reset();
            }
        },{
            text: '保存',
            // 保存
            /* margin : '0 0 0 55', */
            handler: function() {
                me.submitTermsCodeValue();
            }
        }];
        me.items = [me.getTermsCodeForm()];
        me.callParent([cfg]);
    }
});

/**
 * 词条表单
 */
Ext.define('Caiwei.dataset.DataDictionaryForm', {
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
    var queryForm = Ext.create("Caiwei.dataset.TermsCodeQueryForm");
    var termsCodeGrid = Ext.create("Caiwei.dataset.TermsCodeGrid");
    Ext.create('Ext.Viewport', {
        header: {
            titlePosition: 2,
            titleAlign: 'center'
        },
        border: "0 0 0 0",
        renderTo: Ext.getBody(),
        layout: {
            type: 'border'
        },
        getQueryForm: function() {
            return queryForm;
        },
        getTermsCodeGrid: function() {
            return termsCodeGrid;
        },
        items: [
            queryForm, termsCodeGrid]
    });

});