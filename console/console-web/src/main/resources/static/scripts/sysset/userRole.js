//角色部门
Ext.define('Caiwei.sysset.user.OrgRoleWindow', {
    extend: 'Ext.window.Window',
    id:'caiwei_sysset_user_orgrolewindow_id',
    title: '角色部门',
    height: 500,
    width: 400,
    closable: true,
    parent: null,
    // 父元素
    modal: true,
    resizable: false,
    // 可以调整窗口的大小
    closeAction: 'hide',
    layout: {
        type:'vbox',
        padding:'5',
        align:'stretch'
    },
    listeners: {
        beforehide: function(me) { // 隐藏WINDOW的时候清除数据
            me.getRolePanel().getForm().reset(); // 表单数据清除
            /* me.getSearchDept().getForm().reset();*/
            me.getDeptGrid().getStore().removeAll();// 表格数据清除
        }
    },
    //所选用户名
    userCode: null,
    getUserCode:function(){
        return this.userCode;
    },
    //所选部门
    deptCode: null,
    //部门搜索框
    searchDept: null,
    getSearchDept: function() {
        var me = this;
        if (this.searchDept == null) {
            this.searchDept = Ext.create('Caiwei.sysset.user.DeptQueryPanel');
        }
        return this.searchDept;
    },
    selectUserOrgRole: function() {
        var me = this;
        var params = {
            'userDO': {
                'userCode': me.userCode,
                'deptCode': me.deptCode
            }
        };
        var successFun = function(res) {
            //获取后台返回角色信息
            var roleDOS = res.result.roleDOS;
            var roleCodes = new Array();
            if(!Ext.isEmpty(roleDOS)){
                //遍历角色信息
                Ext.Array.forEach(roleDOS,function(role,index,array){
                    roleCodes.push(role.roleCode);
                });
            }
            //添加已有角色信息
            Ext.getCmp('caiwei_sysset_user_itemselector_id').setValue(roleCodes);
        };

        var failureFun = function(json) {
            if (Ext.isEmpty(json)) {
                console.showErrorMes('请求超时'); //请求超时
            } else {
                var message = json.resMsg;
                console.showErrorMes(message);
            }
        };
        console.requestJsonAjax('queryOrgRoleByUserCode', params, successFun, failureFun);
    },
    deptGrid: null,
    getDeptGrid: function() {
        var me = this;
        if (this.deptGrid == null) {
            this.deptGrid = Ext.create('Caiwei.sysset.user.UserDeptGrid');
        }
        return this.deptGrid;
    },
    rolePanel: null,
    getRolePanel: function() {
        var me = this;
        if (this.rolePanel == null) {
            this.rolePanel = Ext.create('Caiwei.sysset.user.RolePanel');
        }
        return this.rolePanel;
    },
    submitUserOrgRole: function() {
        var me = this;
        if(Ext.isEmpty(me.userCode)||Ext.isEmpty(me.deptCode)){
            return;
        }
        var userOrgRoleList = new Array();
        //获取分配角色信息
        var roleCodes = Ext.getCmp('caiwei_sysset_user_itemselector_id').getValue();
        Ext.Array.forEach(roleCodes,function(roleCode,index,array){
                userOrgRoleList.push(roleCode);
            }
        );
        var params = {
            'userDO': {
                'userCode': me.userCode,
                'deptCode': me.deptCode,
                'roleCodes': userOrgRoleList
            }
        }
        var successFun = function(json) {
            var message = json.result;
            console.showInfoMsg(message); //提示新增成功
            me.close();
            //me.parent.getStore().load(); //成功之后重新查询刷新结果集
        };
        var failureFun = function(json) {
            if (Ext.isEmpty(json)) {
                console.showErrorMes('连接超时'); //请求超时
            } else {
                var message = json.message;
                console.showErrorMes(message); //提示失败原因
            }
        };
        //发送AJAX请求
        console.requestJsonAjax('updateUserOrgRole', params, successFun, failureFun);
    },
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.items = [me.getSearchDept(), me.getDeptGrid(), me.getRolePanel()];
        me.fbar = [{
                text: '取消',
                // 取消
                handler: function() {
                    me.close();
                }
            },{
                text: '保存',
                // 保存
                handler: function() {
                    me.submitUserOrgRole();
                }
            }];
    me.callParent([cfg]);
    }
});

//角色信息model
Ext.define('Caiwei.sysset.user.RoleModel', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'tid',
        type: 'string'
    },{
        name: 'roleCode',
        type: 'string'
    },{
        name: 'roleName',
        type: 'string'
    },{
        name: 'systemCode',
        type: 'string'
    },{
        name: 'type',
        type: 'string'
    },{
        name: 'notes',
        type: 'string'
    }]
});
//角色信息store
Ext.define('Caiwei.sysset.user.RoleStore',{
    extend: 'Ext.data.Store',
    autoLoad: true,
    model: 'Caiwei.sysset.user.RoleModel',
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'queryAllRole',
        reader: {
            type: 'json',
            rootProperty: 'roleDOS'
        }
    },
    listeners: {
        'beforeload': function(store, operation, eOpts) {
            var params = {
                'userDO': {}
            }
            Ext.apply(store.proxy.extraParams, params);
        }
    }
});

//分配角色panel
Ext.define('Caiwei.sysset.user.RolePanel',{
    extend: 'Ext.form.Panel',
    header: false,
    layout: 'fit',
    height: 250,
    items: [{
        xtype: 'itemselector',
        name: 'itemselector',
        anchor: '100%',
        id: 'caiwei_sysset_user_itemselector_id',
        store: Ext.create('Caiwei.sysset.user.RoleStore'),
        displayField: 'roleName',
        valueField: 'roleCode',
        msgTarget: 'side',
        fromTitle: '待分配角色',
        toTitle: '已分配角色'
    }]
});

//部门查询panel
Ext.define('Caiwei.sysset.user.DeptQueryPanel', {
    id: 'caiwei_sysset_user_deptqueryForm_id',
    extend: 'Ext.form.Panel',
    labelWidth: 75,
    frame: false,
    height: 30,
    layout: 'column',
    margin: '0 0 5 0',
    items: [{
        xtype: 'textfield',
        name: 'deptName',
        columnWidth: .5,
        margin: '2 0 0 0',
        allowBlank: true,
        emptyText: '请输入部门',
        anchor: '-250 100%'
    },{
        border: false,
        xtype: 'container',
        columnWidth: .2,
        defaults: {
            margin: '0 0 0 10'
        },items: [{
                xtype: 'button',
                width: 80,
                text: '查询',
                //'查询',
                handler: function() {
                    Ext.getCmp('caiwei_sysset_user_deptgrid_id').getStore().load();
                }
            }]
        }]
});

/**
 * 用户部门信息store
 */
Ext.define('Caiwei.sysset.user.UserDeptStore', {
    extend: 'Ext.data.Store',
    fields: ['deptCode', 'deptName'],
    proxy: {
        type: 'ajax',
        actionMethods: 'POST',
        url: 'queryUserDept',
        reader: {
            type: 'json',
            rootProperty: 'departmentDOS',
            totalProperty: 'totalCount'
        }
    },
    listeners: {
        'beforeload': function(store, operation, eOpts) {
            var userCode = Ext.getCmp('caiwei_sysset_user_orgrolewindow_id').userCode;
            var params = {
                'userCode': userCode
            }
            Ext.apply(store.proxy.extraParams, params);
        }
    }
});


//用户部门信息表格
Ext.define('Caiwei.sysset.user.UserDeptGrid', {
    extend: 'Ext.grid.Panel',
    id: 'caiwei_sysset_user_deptgrid_id',
    height: 150,
    autoScroll: true,
    /* pagingToolbar: null,
     getPagingToolbar: function() {
     if (this.pagingToolbar == null) {
     this.pagingToolbar = Ext.create('Ext.toolbar.Paging', {
     store: this.store,
     pageSize: 20
     });
     }
     return this.pagingToolbar;
     },*/
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.columns = [{
            header: '部门编码',
            dataIndex: 'deptCode'
        },{
            header: '部门名称',
            dataIndex: 'deptName',
            flex: 1
        }],
        me.store = Ext.create('Caiwei.sysset.user.UserDeptStore');
        me.selModel = Ext.create('Ext.selection.CheckboxModel', {
            mode: 'SINGLE',
            checkOnly: true
        }),
        /*me.bbar = me.getPagingToolbar();*/
        me.listeners = {
            'itemclick': function(view, record, item, index, e, eOpts) {
                me.up().deptCode=record.get('deptCode');
                me.up().selectUserOrgRole();
            }
        },
        me.callParent([cfg]);
    }
});