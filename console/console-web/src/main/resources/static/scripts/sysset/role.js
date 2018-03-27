/**
 * Role Model
 */
Ext.define('Caiwei.sysset.role.RoleDO', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'tid',
        type: 'int'
    }, {
        name: 'roleCode',
        type: 'string'
    }, {
        name: 'roleName',
        type: 'string'
    }, {
        name: 'systemCode',
        type: 'string'
    }, {
        name: 'type',
        type: 'string'
    }, {
        name: 'notes',
        type: 'string'
    }, {
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
 * 用户角色信息store
 */
Ext.define('Caiwei.sysset.role.RoleStore', {
    extend: 'Ext.data.Store',
    model: 'Caiwei.sysset.role.RoleDO',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'listRole',
        reader: {
            type: 'json',
            rootProperty: 'roleDOS',
            totalProperty: 'totalCount' //总个数
        }
    },
    listeners: {
        beforeload: function (store, operation, eOpts) {
            var queryForm = Ext.getCmp('queryForm');
            if (queryForm != null) {
                var params = {
                        'roleDO.roleCode': queryForm.getForm().findField('roleCode').getValue(),
                        'roleDO.roleName': queryForm.getForm().findField('roleName').getValue(),
                        'roleDO.systemCode': queryForm.getForm().findField('systemCode').getValue(),
                        'roleDO.type' : queryForm.getForm().findField('type').getValue(),
                        'roleDO.active' : queryForm.getForm().findField('active').getValue()
                };
                Ext.apply(store.proxy.extraParams, params);
            }
        }
    }
});

/**
 * Role Query Form
 */
Ext.define('Caiwei.sysset.role.QueryForm', {
    extend: 'Ext.form.Panel',
    id: 'queryForm',
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
            name: 'roleCode',
            fieldLabel: '角色编码',
            xtype: 'textfield'
        }, {
            name: 'roleName',
            fieldLabel: '角色名',
            xtype: 'textfield'
        }, {
            name: 'systemCode',
            fieldLabel: '系统编码',
            xtype: 'textfield'
        }, {
            name: 'type',
            fieldLabel: '角色类型',
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
                        me.up().getRoleGrid().getPagingToolbar().moveFirst();
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
Ext.define('Caiwei.sysset.role.RoleGrid', {
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
                Ext.getCmp('caiwei_sysset_role_deletebtn_id').setDisabled(selections.length === 0);
                Ext.getCmp('caiwei_sysset_role_updatebtn_id').setDisabled(selections.length === 0);
            }
        }
    }),
    roleAddWindow: null,
    getRoleAddWindow: function () {
        if (this.roleAddWindow == null) {
            this.roleAddWindow = Ext.create('Caiwei.sysset.role.RoleAddWindow');
            this.roleAddWindow.parent = this; // 父元素
        }
        return this.roleAddWindow;
    },
    roleUpdateWindow: null,
    getRoleUpdateWindow: function () {
        if (this.roleUpdateWindow == null) {
            this.roleUpdateWindow = Ext.create('Caiwei.sysset.role.RoleUpdateWindow');
            this.roleUpdateWindow.parent = this; // 父元素
        }
        return this.roleUpdateWindow;
    },
    updateRole : function(){
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length != 1) { // 判断是否选中了一条
            console.showWoringMessage('请选择一条进行修改'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var id = selections[0].get('tid');
        var params = {
            'roleDO': {
                'tid' : id
            }
        }

        var successFun = function (json) {
            var updateWindow = me.getRoleUpdateWindow(); //获得修改窗口
            updateWindow.roleDO = json.result.roleDO;
            updateWindow.show(); //显示修改窗口
            updateWindow.getRoleUpdateForm().getForm().findField('tid').setValue(updateWindow.roleDO.tid);
            updateWindow.getRoleUpdateForm().getForm().findField('roleCode').setValue(updateWindow.roleDO.roleCode);
            updateWindow.getRoleUpdateForm().getForm().findField('roleName').setValue(updateWindow.roleDO.roleName);
            updateWindow.getRoleUpdateForm().getForm().findField('systemCode').setValue(updateWindow.roleDO.systemCode);
            updateWindow.getRoleUpdateForm().getForm().findField('type').setValue(updateWindow.roleDO.type);
            updateWindow.getRoleUpdateForm().getForm().findField('notes').setValue(updateWindow.roleDO.notes);
            updateWindow.getRoleUpdateForm().getForm().findField('active').setValue(updateWindow.roleDO.active);
        };
        var failureFun = function (json) {
            if (Ext.isEmpty(json)) {
                console.showErrorMes('请求超时'); //请求超时
            } else {
                var message = json.resMsg;
                console.showErrorMes(message);
            }
        };
        console.requestJsonAjax('findRole', params, successFun, failureFun);
    },
    deleteRole: function () {
        var me = this;
        var selections = me.getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length < 1) { // 判断是否至少选中了一条
            console.showWoringMessage('请选择一条进行删除操作'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var roleCodes = new Array();
        for (var i = 0; i < selections.length; i++) {
            roleCodes.push(selections[i].get('roleCode'));
        }
        console.showQuestionMes('是否要删除',
            function (e) {
                if (e == 'yes') { // 询问是否删除，是则发送请求
                    var params = {
                        'roleCodes': roleCodes
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
                    console.requestJsonAjax('deleteRole', params, successFun, failureFun);
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
            text: '角色编码',
            dataIndex: 'roleCode',
            align: 'center',
            flex: 1
        }, {
            text: '角色名称',
            dataIndex: 'roleName',
            align: 'center',
            flex: 1
        }, {
            text: '系统编码',
            dataIndex: 'systemCode',
            align: 'center',
            flex: 1
        }, {
            text: '角色类型',
            dataIndex: 'type',
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
            text: '新增角色',
            xtype: 'addbutton',
            handler: function () {
                me.getRoleAddWindow().show();
            }
        },{
            id: 'caiwei_sysset_role_updatebtn_id',
            text: '修改角色',
            xtype: 'updatebutton',
            disabled: true,
            handler: function () {
                me.updateRole();
            }
        },{
            id: 'caiwei_sysset_role_deletebtn_id',
            xtype: 'deletebutton',
            text: '删除',
            disabled: true,
            handler: function () {
                me.deleteRole();
            }
        }];
        me.store = Ext.create('Caiwei.sysset.role.RoleStore');
        me.bbar = me.getPagingToolbar();
        me.callParent([cfg]);
    }
});

/**
 * 新增角色表单
 */
Ext.define('Caiwei.sysset.role.RoleForm', {
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
            name: 'roleCode',
            fieldLabel: '角色编码',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'roleName',
            fieldLabel: '角色名称',
            xtype: 'textfield',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: false
        },{
            name: 'systemCode',
            fieldLabel: '系统编码',
            xtype: 'textfield',
            // beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: true
        },{
            name: 'type',
            fieldLabel: '角色类型',
            xtype: 'textfield',
            // beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            allowBlank: true
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
 * 新增角色
 */
Ext.define('Caiwei.sysset.role.RoleAddWindow', {
    extend: 'Ext.window.Window',
    title: '新增角色',
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
            me.getRoleForm().getForm().reset(); // 表格重置
        },
        beforeshow: function (me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getRoleForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function (item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    roleForm: null,
    getRoleForm: function () {
        if (Ext.isEmpty(this.roleForm)) {
            this.roleForm = Ext.create('Caiwei.sysset.role.RoleForm');
        }
        return this.roleForm;
    },
    submitRoleValue: function () {
        var me = this;
        if (me.getRoleForm().getForm().isValid()) { // 校验form是否通过校验
            var roleModel = new Caiwei.sysset.role.RoleDO();
            me.getRoleForm().getForm().updateRecord(roleModel); // 将FORM中数据设置到MODEL里面
            var params = {
                'roleDO': roleModel.data
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
            console.requestJsonAjax('addRole', params, successFun, failureFun); //  发送AJAX请求
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
                me.getRoleForm().reset();
            }
        },{
            text: '保存',
            // 保存
            /* margin : '0 0 0 55', */
            handler: function () {
                me.submitRoleValue();
            }
        }];
        me.items = [me.getRoleForm()];
        me.callParent([cfg]);
    }
});

/**
 *修改角色表单
 */
Ext.define('Caiwei.sysset.role.RoleUpdateForm', {
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
            name: 'roleCode',
            fieldLabel: '角色编码',
            readOnly:true
        },{
            name: 'roleName',
            fieldLabel: '角色名称',
            xtype: 'textfield',
            allowBlank: false
        },{
            name: 'systemCode',
            xtype: 'textfield',
            fieldLabel: '系统编码'
        },{
            xtype: 'textfield',
            name: 'type',
            fieldLabel: '角色类型'
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
 * 修改角色
 */
Ext.define('Caiwei.sysset.role.RoleUpdateWindow', {
    extend: 'Ext.window.Window',
    title: '修改角色',
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
            me.getRoleUpdateForm().getForm().reset(); // 表格重置
        },
        beforeshow: function(me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getRoleUpdateForm().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function(item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    roleUpdateForm: null,
    getRoleUpdateForm: function() {
        if (Ext.isEmpty(this.roleUpdateForm)) {
            this.roleUpdateForm = Ext.create('Caiwei.sysset.role.RoleUpdateForm');
        }
        return this.roleUpdateForm;
    },
    submitRoleValue: function() {
        var me = this;
        if (me.getRoleUpdateForm().getForm().isValid()) { // 校验form是否通过校验
            var roleModel = new Caiwei.sysset.role.RoleDO();
            me.getRoleUpdateForm().getForm().updateRecord(roleModel); // 将FORM中数据设置到MODEL里面
            var params = {
                'roleDO': roleModel.data
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
            console.requestJsonAjax('updateRole', params, successFun, failureFun); //  发送AJAX请求
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
                me.submitRoleValue();
            }
        }];
        me.items = [me.getRoleUpdateForm()];
        me.callParent([cfg]);
    }
});


Ext.onReady(function() {
    var queryForm = Ext.create("Caiwei.sysset.role.QueryForm");
    var roleGrid = Ext.create("Caiwei.sysset.role.RoleGrid");
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
        getRoleGrid: function() {
            return roleGrid;
        },
        items: [
            queryForm, roleGrid]
    });

});

