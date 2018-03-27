/**
 * User Model
 */
Ext.define('Caiwei.sysset.user.UserDO', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'tid',
        type: 'int'
    }, {
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
    },  {
        name: 'active',
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
                    'userDO.userCode': queryForm.getForm().findField('userCode').getValue(),
                    'userDO.empCode': queryForm.getForm().findField('empCode').getValue(),
                    'userDO.empName': queryForm.getForm().findField('empName').getValue(),
                    'userDO.active': queryForm.getForm().findField('active').getValue()
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
    bodyStyle: {
        padding: '6px',

    },
    labelStyle : "text-align:right;width:40;",
    default: {
        margin: '5 10 5 0',
        labelWidth: 40,
        columnWidth: 0.25,
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
        }, {
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
    userUpdateWindow: null,
    getUserUpdateWindow: function () {
        if (this.userUpdateWindow == null) {
            this.userUpdateWindow = Ext.create('Caiwei.sysset.user.UserUpdateWindow');
            this.userUpdateWindow.parent = this; // 父元素
        }
        return this.userUpdateWindow;
    },
    updateUser: function () {
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length != 1) { // 判断是否选中了一条
            console.showWoringMessage('请选择一条进行修改'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var id = selections[0].get('tid');
        var params = {
            'userDO': {
                'tid' : id
            }
        }
        var successFun = function (json) {
            var updateWindow = me.getUserUpdateWindow(); //获得修改窗口
            updateWindow.userDO = json.result.userDO;
            updateWindow.show(); //显示修改窗口
            updateWindow.getUserUpdateForm().getForm().findField('tid').setValue(updateWindow.userDO.tid);
            updateWindow.getUserUpdateForm().getForm().findField('userCode').setValue(updateWindow.userDO.userCode);
            // updateWindow.getUserUpdateForm().getForm().findField('passWord').setValue(updateWindow.userDO.passWord);
            updateWindow.getUserUpdateForm().getForm().findField('empCode').setValue(updateWindow.userDO.empCode);
            updateWindow.getUserUpdateForm().getForm().findField('empName').setValue(updateWindow.userDO.empName);
            updateWindow.getUserUpdateForm().getForm().findField('deptCode').setValue(updateWindow.userDO.deptCode);
            updateWindow.getUserUpdateForm().getForm().findField('notes').setValue(updateWindow.userDO.notes);
            updateWindow.getUserUpdateForm().getForm().findField('active').setValue(updateWindow.userDO.active);
        };
        var failureFun = function (json) {
            if (Ext.isEmpty(json)) {
                console.showErrorMes('请求超时'); //请求超时
            } else {
                var message = json.resMsg;
                console.showErrorMes(message);
            }
        };
        console.requestJsonAjax('findUserById', params, successFun, failureFun);
    },
    roleConfigWindow: null,
    getRoleConfigWindow: function() {
        if (this.roleConfigWindow == null) {
            this.roleConfigWindow = Ext.create('Caiwei.sysset.user.OrgRoleWindow');
            this.roleConfigWindow.parent = this; // 父元素
        }
        return this.roleConfigWindow;

    },
    addRole: function () {
        var me = this;
        var selections = me.getSelectionModel().getSelection(); //获取选中的数据
        if (selections.length == 0) {
            Ext.MessageBox.alert('提示', '请选择需要配置的用户');
            return;
        } else if (selections.length > 1) {
            Ext.MessageBox.alert('提示', '只能选择一个用户进行配置');
            return;
        }
        var win = me.getRoleConfigWindow();
        win.userCode = selections[0].get('userCode');
        win.getDeptGrid().getStore().load();
        win.show(); //显示部门角色窗口
    },
    deleteUser: function () {
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length < 1) { // 判断是否至少选中了一条
            console.showWoringMessage('请选择一条进行删除操作'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var userCodes = new Array();
        for (var i = 0; i < selections.length; i++) {
            userCodes.push(selections[i].get('userCode'));
        }
        console.showQuestionMes('是否要删除',
            function (e) {
                if (e == 'yes') { // 询问是否删除，是则发送请求
                    var params = {
                        'userCodes': userCodes
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
                    console.requestJsonAjax('deleteUser', params, successFun, failureFun);
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
            dataIndex: 'tid',
            hidden: true
        },{
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
            text: '新增用户',
            xtype: 'addbutton',
            handler: function () {
                me.getUserAddWindow().show();
            }
        },{
            text: '修改用户',
            xtype: 'addbutton',
            handler: function () {
                me.updateUser();
            }
        },{
            text: '角色配置',
            xtype: 'addbutton',
            handler: function () {
                me.addRole();
            }
        },{
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
            name: 'userCode',
            fieldLabel: '用戶名',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false,
            listeners: {
                select: function (combo, records, eOpts) {
                    combo.up().getForm().findField('userCode').setValue(records.data.userCode);
                }
            }
        },{
            name: 'passWord',
            fieldLabel: '密码',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'empCode',
            fieldLabel: '员工工号',
            // xtype: 'textfield',
            xtype: 'dynamicemployeecombselector',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false,
            listeners: {
                select: function (combo, records, eOpts) {
                    combo.up().getForm().findField('empCode').setValue(records.data.empCode);
                    combo.up().getForm().findField('empName').setValue(records.data.empName);
                }
            }
        },{
            name: 'empName',
            fieldLabel: '员工姓名',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'deptCode',
            fieldLabel: '部门编码',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'notes',
            fieldLabel: '备注',
            xtype: 'textarea',
            // beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: true
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
                'userDO': userModel.data
            }
            var successFun = function (json) {
                var message = json.resMsg;
                console.showInfoMsg(message); // 提示新增成功
                me.close();
                me.parent.getStore().load(); // 成功之后重新查询刷新结果集
            };
            var failureFun = function (json) {
                if (Ext.isEmpty(json)) {
                    console.showErrorMes('连接超时'); // 请求超时
                } else {
                    var message = json.resMsg;
                    console.showErrorMes(message); // 提示失败原因
                }
            };
            console.requestJsonAjax('addUser', params, successFun, failureFun); //  发送AJAX请求
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

/**
 *修改用户表单
 */
Ext.define('Caiwei.sysset.user.UserUpdateForm',{
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
            name: 'userCode',
            fieldLabel: '用户编码',
            readOnly:true
        },/*{
            name: 'passWord',
            fieldLabel: '用户密码',
            xtype: 'textfield',
            allowBlank: false
        },*/{
            name: 'empCode',
            xtype: 'textfield',
            fieldLabel: '员工编码',
            readOnly: true
        },{
            xtype: 'textfield',
            name: 'empName',
            fieldLabel: '员工姓名',
            readOnly: true
        },{
            xtype: 'textfield',
            name: 'deptCode',
            fieldLabel: '部门编码',
            readOnly: true
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
 * 修改用户
 */
Ext.define('Caiwei.sysset.user.UserUpdateWindow',{
    extend: 'Ext.window.Window',
    title: '修改用户',
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
            me.getUserUpdateForm().getForm().reset(); // 表格重置
        },
        beforeshow: function(me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getUserUpdateForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function(item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    userUpdateForm: null,
    getUserUpdateForm: function() {
        if (Ext.isEmpty(this.userUpdateForm)) {
            this.userUpdateForm = Ext.create('Caiwei.sysset.user.UserUpdateForm');
        }
        return this.userUpdateForm;
    },
    submitUserValue: function() {
        var me = this;
        if (me.getUserUpdateForm().getForm().isValid()) { // 校验form是否通过校验
            var userModel = new Caiwei.sysset.user.UserDO();
            me.getUserUpdateForm().getForm().updateRecord(userModel); // 将FORM中数据设置到MODEL里面
            var params = {
                'userDO': userModel.data
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
            console.requestJsonAjax('updateUser', params, successFun, failureFun); //  发送AJAX请求
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
                me.submitUserValue();
            }
        }];
        me.items = [me.getUserUpdateForm()];
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


