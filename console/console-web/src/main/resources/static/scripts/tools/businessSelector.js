/**
 * 员工model
 *
 */
Ext.define('Caiwei.baseinfo.commonSelector.EmployeeModel',{
    extend : 'Ext.data.Model',
    fields : [{
        name : 'id'
    }, {
        name : 'empCode'
    }, {
        name : 'empName'
    }, {
        name : 'deptCode'
    }, {
        name : 'deptName'
    }, {
        name : 'gender'
    }, {
        name : 'mobileNo'
    }, {
        name : 'email'
    }, {
        name : 'telPhone'
    }, {
        name : 'status'
    }, {
        name : 'createTime'
    }, {
        name : 'modifyTime'
    }]
});


//员工下拉框store
Ext.define('Caiwei.commonEmployeeSelector.EmployeeCombStore',{
    extend : 'Ext.data.Store',
    model : 'Caiwei.baseinfo.commonSelector.EmployeeModel',
    pageSize : 20,
    proxy : {
        type : 'ajax',
        url : '/caiwei/common/searchEmployeeByParam',
        actionMethods : 'POST',
        reader : {
            type : 'json',
            rootProperty : 'employeeDOS',
            totalProperty : 'totalCount'
        }
    }
});

/**
 * 员工单选
 */
Ext.define('Caiwei.commonEmpSelector.EmployeeCommonSelector',{
    extend : 'Caiwei.commonSelector.CommonCombSelector',
    alias : 'widget.dynamicemployeecombselector',
    displayField : 'empCode',// 显示名称
    valueField : 'empCode',// 值
    active : null,
    queryParam : 'employeeDO.empCode',// 查询参数
    showContent : '{empCode}&nbsp;&nbsp;&nbsp;{empName}',// 显示表格列
    constructor : function(config) {
        var me = this, cfg = Ext.apply({}, config);
        me.store = Ext.create('Caiwei.commonEmployeeSelector.EmployeeCombStore');

        me.store.addListener('beforeload', function(store, operation, eOpts) {
            var searchParams = operation.getParams();
            if (Ext.isEmpty(searchParams)) {
                searchParams = {};
            }

            Ext.apply(store.proxy.extraParams, searchParams);
        })
        me.callParent([cfg]);
    }
});
