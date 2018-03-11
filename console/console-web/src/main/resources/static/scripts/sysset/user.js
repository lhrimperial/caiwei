/**
 * User Model
 */
Ext.define('Caiwei.sysset.user.UserDO', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'userCode',
        type: 'string'
    }, {
        name: 'passWord',
        type: 'string'
    }, {
        name: 'empCode',
        type: 'string'
    }, {
        name: 'deptCode',
        type: 'string'
    }, {
        name: 'empName',
        type: 'string'
    }, {
        name: 'lastLogin',
        type: 'date',
        convert: dateConvert
    }, {
        name: 'notes',
        type: 'string'
    }, {
        name: 'createTime',
        type: 'date',
        convert: dateConvert
    }, {
        name: 'modifyTime',
        type: 'date',
        convert: dateConvert
    }]
});

/**
 * 用户信息store
 */
Ext.define('Caiwei.sysset.user.UserStore', {
    extend: 'Ext.data.Store',
    model: 'Caiwei.sysset.user.UserDO',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'queryUserList',
        reader: {
            type: 'json',
            rootProperty: 'userDOS',
            totalProperty: 'totalCount' //总个数
        }
    },
    listeners: {
        beforeload: function (store, operation, eOpts) {
            var queryForm = Ext.getCmp('queryForm');
            if (queryForm != null) {
                var params = {
                    'userVo.userDO.userCode': queryForm.getForm().findField('userCode').getValue(),
                    'userVo.userDO.empCode': queryForm.getForm().findField('empCode').getValue(),
                    'userVo.userDO.empName': queryForm.getForm().findField('empName').getValue(),
                };
                Ext.apply(store.proxy.extraParams, params);
            }
        }
    }
});

/**
 * User Query Form
 */
Ext.define('Caiwei.sysset.user.QueryForm', {
    extend: 'Ext.form.Panel',
    id: 'queryForm',
    frame: true,
    header: false,
    height: 70,
    collapsible: true,
    layout: 'column',
    region: 'north',
    bodyStyle:'padding:6px;',
    default: {
        padding: 10,
        margin: '20 10 5 10',
        labelWidth: 50,
        columnWidth: 0.23,
        labelAlign: 'right'
    },
    defaultType: 'textfield',
    constructor: function (config) {
        var me = this,
            cfg = Ext.apply({}, config);
        me.items = [{
            name: 'userCode',
            fieldLabel: '用户名',
            xtype: 'textfield'
        }, {
            name: 'empCode',
            fieldLabel: '员工工号',
            xtype: 'textfield'
        }, {
            name: 'empName',
            fieldLabel: '员工姓名',
            xtype: 'textfield'
        }],
        me.buttons = [{
            text: '查询',
            handler: function () {
                if (me.getForm().isValid()) {
                    me.up().getUserGrid().getPagingToolbar().moveFirst();
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
 * 用户信息
 */
Ext.define('Caiwei.sysset.user.UserGrid', {
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
                Ext.getCmp('caiwei_sysset_user_deletebtn_id').setDisabled(selections.length === 0);
            }
        }
    }),
    userAddWindow: null,
    getUserAddWindow: function () {
        if (this.userAddWindow == null) {
            this.userAddWindow = Ext.create('Caiwei.sysset.user.UserAddWindow');
            this.userAddWindow.parent = this; // 父元素
        }
        return this.userAddWindow;
    },
    deleteUser: function () {
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length < 1) { // 判断是否至少选中了一条
            Caiwei.showWoringMessage('请选择一条进行删除操作'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var userCodes = new Array();
        for (var i = 0; i < selections.length; i++) {
            userCodes.push(selections[i].get('userCode'));
        }
        Caiwei.showQuestionMes('是否要删除',
            function (e) {
                if (e == 'yes') { // 询问是否删除，是则发送请求
                    var params = {
                        'userVo': {
                            'userCodes': userCodes
                        }
                    };
                    var successFun = function (json) {
                        var message = json.repMsg;
                        Caiwei.showInfoMsg(message);
                        me.getStore().load();
                    };
                    var failureFun = function (json) {
                        if (Ext.isEmpty(json)) {
                            Caiwei.showErrorMes('请求超时'); // 请求超时
                        } else {
                            var message = json.repMsg;
                            Caiwei.showErrorMes(message);
                        }
                    };
                    Caiwei.requestJsonAjax('deleteUser', params, successFun, failureFun);
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
        }, {
            text: '用户名',
            dataIndex: 'userCode',
            align: 'center',
            flex: 1
        }, {
            text: '员工工号',
            dataIndex: 'empCode',
            align: 'center',
            flex: 1
        }, {
            text: '员工姓名',
            dataIndex: 'empName',
            align: 'center',
            flex: 1
        }, {
            text: '部门编码',
            dataIndex: 'deptCode',
            align: 'center',
            flex: 1
        }, /*{
            text: '登录时间',
            dataIndex: 'lastLogin',
            align: 'center',
            flex: 1
        },*/ {
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
        }],
        me.tbar = [{
            text: '新增用户',
            xtype: 'addbutton',
            handler: function () {
                me.getUserAddWindow().show();
            }
        }, {
            id: 'caiwei_sysset_user_deletebtn_id',
            xtype: 'deletebutton',
            text: '删除',
            disabled: true,
            handler: function () {
                me.deleteUser();
            }
        }];
        me.store = Ext.create('Caiwei.sysset.user.UserStore');
        me.bbar = me.getPagingToolbar();
        me.callParent([cfg]);
    }
});

/**
 * 新增用户表单
 */
Ext.define('Caiwei.sysset.user.UserForm', {
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
    constructor: function (config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.items = [{
            name: 'empCode',
            fieldLabel: '员工工号',
            xtype: 'dynamicemployeecombselector',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false,
            listeners: {
                select: function (combo, records, eOpts) {
                    // combo.up().getForm().findField('empName').setValue(records.data.employeeName);
                    // combo.up().getForm().findField('userName').setValue(records.data.account);
                    // combo.up().getForm().findField('title').setValue(records.data.jobName);
                }
            }
        },{
            name: 'userCode',
            fieldLabel: '用戶名',
            xtype: 'textfield',
            editable: false,
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'passWord',
            fieldLabel: '密码',
            xtype: 'textfield',
            hidden: true
        },{
            name: 'empName',
            fieldLabel: '员工姓名',
            xtype: 'textfield',
            editable: false,
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        }];
        me.callParent([cfg]);
    }
});


/**
 * 新增用户
 */
Ext.define('Caiwei.sysset.user.UserAddWindow', {
    extend: 'Ext.window.Window',
    title: '新增用户',
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
        beforehide: function (me) { // 隐藏WINDOW的时候清除数据
            me.getUserForm().getForm().reset(); // 表格重置
        },
        beforeshow: function (me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getUserForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function (item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    userForm: null,
    getUserForm: function () {
        if (Ext.isEmpty(this.userForm)) {
            this.userForm = Ext.create('Caiwei.sysset.user.UserForm');
        }
        return this.userForm;
    },
    submitUserValue: function () {
        var me = this;
        if (me.getUserForm().getForm().isValid()) { // 校验form是否通过校验
            var userModel = new Caiwei.sysset.user.UserDO();
            me.getUserForm().getForm().updateRecord(userModel); // 将FORM中数据设置到MODEL里面
            var params = {
                'userVo': {
                    'userDO': userModel.data
                }
            }
            var successFun = function (json) {
                var message = json.resMsg;
                Caiwei.showInfoMsg(message); // 提示新增成功
                me.close();
                me.parent.getStore().load(); // 成功之后重新查询刷新结果集
            };
            var failureFun = function (json) {
                if (Ext.isEmpty(json)) {
                    Caiwei.showErrorMes('连接超时'); // 请求超时
                } else {
                    var message = json.resMsg;
                    Caiwei.showErrorMes(message); // 提示失败原因
                }
            };
            Caiwei.requestJsonAjax('addUser', params, successFun, failureFun); //  发送AJAX请求
        }
    },
    constructor: function (config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.fbar = [{
            text: '取消',
            // 取消
            handler: function () {
                me.close();
            }
        },{
            text: '重置',
            // 重置
            handler: function () {
                me.getUserForm().reset();
            }
        },{
            text: '保存',
            // 保存
            /* margin : '0 0 0 55', */
            handler: function () {
                me.submitUserValue();
            }
        }];
        me.items = [me.getUserForm()];
        me.callParent([cfg]);
    }
});


Ext.onReady(function() {
    var queryForm = Ext.create("Caiwei.sysset.user.QueryForm");
    var userGrid = Ext.create("Caiwei.sysset.user.UserGrid");
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
        getUserGrid: function() {
            return userGrid;
        },
        items: [
            queryForm, userGrid]
    });

});


