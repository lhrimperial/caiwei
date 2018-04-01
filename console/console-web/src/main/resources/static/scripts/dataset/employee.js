function booleanTypeGender(value){
    if(Ext.isEmpty(value)){
        return value;
    }
    if(value== 'MELE'){
        return '男';
    }
    if(value == 'FEMALE'){
        return '女';
    }
    return value;
}

/**
 * 员工信息实体
 */
Ext.define('Caiwei.dataset.employee.EmployeeDO', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'tid',
        type: 'int'
    },{
        name: 'empCode',
        //员工工号
        type: 'string'
    },{
        name: 'empName',
        //员工名称
        type: 'string'
    },{
        name: 'gender',
        //性别
        type: 'string'
    },{
        name: 'deptName',
        //部门名称
        type: 'string'
    },{
        name: 'deptCode',
        //部门编码
        type: 'string'
    },{
        name: 'mobileNo',
        //手机
        type: 'string'
    },{
        name: 'telPhone',
        //座机
        type: 'string'
    },{
        name: 'email',
        //邮箱
        type: 'string'
    },{
        name: 'active',
        //状态
        type: 'string'
    },{
        name: 'createTime',
        type: 'date',
        dateFormat:'time'
    },{
        name: 'modifyTime',
        type: 'date',
        dateFormat:'time'
    }]
});


/**
 * 员工信息store
 */
Ext.define('Caiwei.dataset.employee.EmployeeStore', {
    extend: 'Ext.data.Store',
    model: 'Caiwei.dataset.employee.EmployeeDO',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'queryEmpList',
        reader: {
            type: 'json',
            rootProperty: 'employeeDOS',
            totalProperty: 'totalCount' //总个数
        }
    },
    listeners: {
        beforeload: function(store, operation, eOpts) {
            var queryForm = Ext.getCmp('caiwei_dataset_employee_EmployeeForm_id');
            if (queryForm != null) {
                var params = {
                    'employeeDO.deptName': queryForm.getForm().findField('deptName').getValue(),
                    'employeeDO.empCode': queryForm.getForm().findField('empCode').getValue(),
                    'employeeDO.empName': queryForm.getForm().findField('empName').getValue(),
                    'employeeDO.active': queryForm.getForm().findField('active').getValue()
                };
                Ext.apply(store.proxy.extraParams, params);
            }
        }
    }
});

Ext.define('Caiwei.dataset.employee.EmployeeForm', {
    extend: 'Ext.form.Panel',
    id: 'caiwei_dataset_employee_EmployeeForm_id',
    frame: true,
    title: '查询条件',
    height: 113,
    collapsible: true,
    layout: 'column',
    region: 'north',
    defaults: {
        margin: '8 10 5 10',
        labelWidth: 100,
        columnWidth: 0.23,
        labelAlign: 'right'
    },
    defaultType: 'textfield',
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.items = [{
            name: 'empCode',
            fieldLabel: '员工工号',
            xtype: 'textfield'
        },{
            name: 'empName',
            fieldLabel: '员工姓名',
            xtype: 'textfield'
        },{
            name: 'deptName',
            fieldLabel:'部门名称',
            xtype: 'textfield'
        },{
            style:'margin-top:5px;',
            name: 'active',
            fieldLabel: '是否可用',
            xtype: 'yesnocombselector',
            value: 'Y',
            isShowAll : true// 是否显示全部
        }],
        me.buttons = [{
            text: '查询',
            handler: function() {
                if (me.getForm().isValid()) {
                    me.up().getEmployeeGrid().getPagingToolbar().moveFirst();
                }
            }
        },{
            text: '重置',
            handler: function() {
                me.getForm().reset();
            }
        }];
        me.callParent([cfg]);
    }
});

/**
 * 员工信息表格
 */
Ext.define('Caiwei.dataset.employee.EmployeeGrid', {
    extend: 'Ext.grid.Panel',
    frame: true,
    autoScroll: true,
    width: '100%',
    layout : 'column',
    height: document.documentElement.clientHeight - 150,
    stripeRows: true,
    // 交替行效果
    region: 'center',
    emptyText: '查询结果为空',
    //查询结果为空
    viewConfig: {
        enableTextSelection: true
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
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.columns = [{
            text: '序号',
            width: 60,
            xtype: 'rownumberer',
            align: 'center'
        },{
            text: 'ID',
            hidden: true
        },{
            text: '员工工号',
            dataIndex: 'empCode',
            align: 'center',
            flex: 1
        },{
            text: '员工姓名',
            dataIndex: 'empName',
            align: 'center',
            flex: 1
        },{
            text: '性别',
            dataIndex: 'gender',
            align: 'center',
            flex: 1,
            renderer:function(value){
                return booleanTypeGender(value);
            }
        },{
            text: '部门编码',
            dataIndex: 'deptCode',
            align: 'center',
            flex: 1
        },{
            text: '部门名称',
            dataIndex: 'deptName',
            align: 'center',
            flex: 2
        },{
            text: '手机',
            dataIndex: 'mobileNo',
            align: 'center',
            flex: 2
        },{
            text: '电话',
            dataIndex: 'telPhone',
            align: 'center',
            flex: 1
        },{
            text: '邮箱',
            dataIndex: 'email',
            align: 'center',
            flex: 2
        },{
            text: '创建时间',
            dataIndex: 'createTime',
            align: 'center',
            flex: 2,
            xtype :'datecolumn',
            format :'Y-m-d H:i:s'
        },{
            text: '修改时间',
            dataIndex: 'modifyTime',
            align: 'center',
            flex: 2,
            xtype :'datecolumn',
            format :'Y-m-d H:i:s'
        }],
        me.tbar = [{
            text: '新增员工信息',
            xtype: 'addbutton',
            handler: function () {
                // me.getTermsCodeAddWindow().show();
            }
        },{
            text: '修改员工信息',
            xtype: 'updatebutton',
            disabled: true,
            handler: function () {
                // me.updateTermsCode();
            }
        },{
            xtype: 'deletebutton',
            text: '删除',
            disabled: true,
            handler: function () {
                // me.deleteTermsCode();
            }
        }];
        me.store = Ext.create('Caiwei.dataset.employee.EmployeeStore', {
            autoLoad: false
        });
        me.selModel = Ext.create('Ext.selection.CheckboxModel', { //多选框
            mode: 'MULTI',
            checkOnly: true
        });
        me.bbar = me.getPagingToolbar();
        me.callParent([cfg]);
    }
});



Ext.onReady(function() {
    var queryForm = Ext.create("Caiwei.dataset.employee.EmployeeForm");
    var employeeGrid = Ext.create("Caiwei.dataset.employee.EmployeeGrid");
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
        getEmployeeGrid: function() {
            return employeeGrid;
        },
        items: [queryForm, employeeGrid]
    });

});







