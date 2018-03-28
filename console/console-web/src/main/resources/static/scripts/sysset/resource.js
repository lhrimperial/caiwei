/**
 * 获取浏览器高度
 */
console.getBrowserHeight = function() {
    var browserHeight = document.documentElement.clientHeight;
    return browserHeight;
};

/**
 * model(resouce)
 */
Ext.define('Caiwei.sysset.source.ResourceNode',{
    extend: 'Ext.data.Model',
    fields: [{
        name : 'id',
        // id
        type : 'string'

    },{
        name : 'code',
        // 权限编码
        type : 'string'
    },{
        name : 'name',
        // 权限名称
        type : 'string'
    },{
        name : 'entryUri',
        // 权限入口URI
        type : 'string'
    },{
        name : 'resLevel',
        // 功能层级
        type :'string'
    },/*{
        name : 'parentRes',
        // 父id
        type : 'sring'
    },{
        name : 'parentNode',
        // 父Node

    },*/{
        name : 'active',
        type : 'string'
    },{
        name : 'checked',
        type : 'string'
    },{
        name : 'displayOrder',
        // 显示顺序
        type : 'int'
    },{
        name : 'resType',
        // 权限类型
        type : 'string'
    },{
        name : 'leafFlag',
        // 是否叶子节点
        type : 'string'
    },{
        name : 'iconCls',
        // 图标的CSS样式
        type : 'string'
    },{
        name : 'cls',
        // 节点的CSS样式
        type : 'string'
    },{
        name : 'notes',
        // 权限描述
        type : 'string'
    },{
        name : 'belongSystemType',
        // 所属系统类型
        type : 'string'
    }]
});


/**
 * 权限管理详情视图(resource)
 */
Ext.define('Caiwei.view.resource.Grid', {
    extend : 'Ext.grid.Panel',
    id : 'resourceGrid2',
    frame : true,
    autoScroll : true,
// height : butterfly.getBrowserHeight() - 120,
    height : 40,
    width : '100%',
    addResourceWindow :null,
    getAddResourceWindow : function(){
        if (this.addResourceWindow == null) {
            this.addResourceWindow = Ext.create('Caiwei.view.addResource.Window');
            this.addResourceWindow.parent = this; // 父元素
        }
        return this.addResourceWindow;
    },
    changResource :function(){
        var me = this;
        var selections = me.up().getResourceRoleTree().getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length != 1) { // 判断是否选中了一条
            console.showWoringMessage('请选择一条进行作废操作！'); //
            return; // 没有则提示并返回
        }
        var winIn = me.getAddResourceWindow();
        winIn.show();
        winIn.setTitle('修改');
        var changbox = winIn.getResourceFrom().getForm();
        winIn.setUpdate();
        var resobj = selections[0].get('resourceNode');
        changbox.findField('id').setValue(resobj.id);
        changbox.findField('code').setValue(resobj.code);
        changbox.findField('name').setValue(resobj.name);
        changbox.findField('entryUri').setValue(resobj.entryUri);
        changbox.findField('resLevel').setValue(resobj.resLevel);
        changbox.findField('displayOrder').setValue(resobj.displayOrder);
        changbox.findField('checked').setValue(resobj.checked);
        changbox.findField('resType').setValue(resobj.resType);
        changbox.findField('leafFlag').setValue(resobj.leafFlag);
        changbox.findField('iconCls').setValue(resobj.iconCls);
        changbox.findField('cls').setValue(resobj.cls);
        changbox.findField('notes').setValue(resobj.notes);
        changbox.findField('belongSystemType').setValue(resobj.belongSystemType);
        Ext.getCmp('caiwei_bse_resource_sele').setCombValue(resobj.parentNode.name,resobj.parentNode.code);
        changbox.findField('code').setReadOnly(true);
        changbox.findField('name').setReadOnly(true);
    },
    deleteResource : function(){
        var me = this;
        var selections = me.up().getResourceRoleTree().getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length < 1) { // 判断是否至少选中了一条
            console.showWoringMessage('请选择一条进行作废操作!'); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var resourceNodes = new Array();
        for (var i = 0; i < selections.length; i++) {
            resourceNodes.push({
                'id': selections[0].get('resourceNode').id,
                'code': selections[0].get('resourceNode').code
            });
        }
        console.showQuestionMes('是否要删除?其子节点也将被删除',
            function(e) {
                if (e == 'yes') { // 询问是否删除，是则发送请求
                    var params = {
                        'resourceNodes': resourceNodes
                    };
                    var successFun = function(json) {
                        var message = json.resMsg;
                        console.showInfoMsg(message);
                        me.up().getResourceRoleTree().getStore().load();
                    };
                    var failureFun = function(json) {
                        if (Ext.isEmpty(json)) {
                            console.showErrorMes('请求超时!'); // 请求超时
                        } else {
                            var message = json.resMsg;
                            console.showErrorMes(message);
                        }
                    };
                    console.requestJsonAjax('deleteResource', params, successFun, failureFun);
                }
            });
    },
    constructor : function(config) {
        var me = this,
            cfg = Ext.apply({}, config);
        me.tbar = [ {
            xtype: 'addbutton',
            text : '新增URL',
            handler : function() {
                var winIn = me.getAddResourceWindow();
                winIn.show();
                winIn.setTitle('新增');
                var changbox = winIn.getResourceFrom().getForm();
                winIn.setSave();
                changbox.findField('code').setReadOnly(false);
                changbox.findField('name').setReadOnly(false);
            }
        },'-',{
            xtype :'updatebutton',
            id : 'caiwei_sysset_resource_update_id',
            text : '修改',
            handler : function() {
                me.changResource();
            }
        },'-',{
            xtype : 'deletebutton',
            id : 'caiwei_sysset_resource_delete_id',
            text : '删除',
            handler : function() {
                me.deleteResource();
            }
        }];
        me.callParent([ cfg ]);
    }
});
/**
 * 父code下拉框store
 */
Ext.define('Caiwei.store.resourceSelect',{
    extend : 'Ext.data.Store',
    model : 'Caiwei.sysset.source.ResourceNode',
    pageSize : 20,
    proxy : {
        type : 'ajax',
        url : 'queryResourceByExample',
        actionMethods : 'POST',
        reader : {
            type : 'json',
            rootProperty : 'resourceNodes',
            totalProperty : 'totalCount' // 总个数
        }
    }
});
/**
 * 父code下拉框
 */
Ext.define('Caiwei.selector.ResourceSelector', {
    extend: 'Caiwei.commonSelector.CommonCombSelector',
    alias: 'widget.resourceselector',
    displayField: 'name',
    // 显示名称
    valueField: 'code',
    // 值
    queryParam: 'resourceNode.name',
    // 查询参数
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.store = Ext.create('Caiwei.store.resourceSelect');
        me.callParent([cfg]);
    }
});

/**
 * 新增，修改，权限URL表单(resource_form)
 */
Ext.define('Caiwei.view.resourceFrom', {
    extend: 'Ext.form.Panel',
    header: false,
    frame: true,
    id : 'caiwei_bseinfo_resource_form',
    collapsible: true,
    width: 600,
    fieldDefaults: {
        labelWidth: 80,
        margin: '10 10 10 10',
        labelAlign : 'right'
    },
    layout : 'column',
    defaultType: 'textfield',
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        var typeStore = getDataDictionary().getDataDictionaryStore('SYSTEM_TYPE');
        var jurisdictionStore = getDataDictionary().getDataDictionaryStore('JURISDICTION_TYPE');
        var resourceStore = getDataDictionary().getDataDictionaryStore('RESOURCES_LEVEL');

        me.items = [{
            name: 'id',
            fieldLabel: 'ID',
            columnWidth: 0.45,
            hidden:true
        },{
            name: 'code',
            fieldLabel: '编码',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            columnWidth: 0.45,
            allowBlank: false
        },
        {
            name: 'name',
            fieldLabel: '名称',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            columnWidth: 0.45,
            allowBlank: false
        },{
            name : 'entryUri',
            fieldLabel : '入口URL',
            columnWidth :0.9
        },{
            name : 'resLevel',
            fieldLabel : '层级',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            columnWidth: 0.45,
            xtype : 'combo',
            store : resourceStore,
            displayField: 'valueName',
            valueField: 'valueCode',
            allowBlank: false
        },{
            name : 'resType',
            fieldLabel : '权限类型',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            columnWidth: 0.45,
            xtype : 'combo',
            store : jurisdictionStore,
            displayField: 'valueName',
            valueField: 'valueCode',
            allowBlank: false
        },{
            id :'caiwei_bse_resource_sele',
            name : 'parentRes',
            fieldLabel : '上级',
            columnWidth :0.45,
            xtype :'resourceselector'
        },{
            name : 'displayOrder',
            fieldLabel : '显示顺序',
            columnWidth :0.45,
            xtype: 'numberfield'
        },{
            name : 'checked',
            fieldLabel : '是否权限检查',
            beforeLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'],
            columnWidth: 0.45,
            xtype:'yesnocheckbox',
            allowBlank: false
        },{
            id : 'caiwei_bse_resource_addleafflag',
            name : 'leafFlag',
            fieldLabel : '是否叶子节点',
            columnWidth: 0.45,
            xtype:'yesnocheckbox'

        },{
            name : 'iconCls',
            fieldLabel : '图标样式',
            columnWidth :0.45
        },{
            name : 'cls',
            fieldLabel : '节点样式',
            columnWidth :0.45
        },{
            name : 'belongSystemType',
            fieldLabel : '所属系统类型',
            columnWidth :0.45,
            xtype : 'combo',
            store : typeStore,
            displayField: 'valueName',
            valueField: 'valueCode'
        },{
            id : 'caiwei_bse_resource_active_flag',
            name : 'active',
            fieldLabel : '是否叶可用',
            columnWidth: 0.45,
            value: "Y",
            xtype:'yesnocheckbox'
        },{
            name: 'notes',
            fieldLabel: '描述',
            columnWidth: 0.9
        }];
        me.callParent([cfg]);
    }
});

/**
 * 添加面版
 */
Ext.define('Caiwei.view.addResource.Window',{
    extend: 'Ext.window.Window',
    id : 'caiwei_bse_add_resource2',
    closable: true,
    modal: true,
    resizable: false,
    // 可以调整窗口的大小
    closeAction: 'hide',
    // 点击关闭是隐藏窗口
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    resourceFrom: null,
    getResourceFrom: function() {
        var me = this;
        if (Ext.isEmpty(this.resourceFrom)) {
            this.resourceFrom = Ext.create('Caiwei.view.resourceFrom');
        }
        return this.resourceFrom;
    },
    listeners: {
        beforehide: function(me) { // 隐藏WINDOW的时候清除数据
            me.getResourceFrom().getForm().reset(); // 表格重置
        },
        beforeshow: function(me) { // 显示WINDOW的时候清除数据
            var fielsds = me.getResourceFrom().getForm().getFields();
            if (!Ext.isEmpty(fielsds)) {
                fielsds.each(function(item, index, length) {
                    item.clearInvalid();
                    item.unsetActiveError();
                });
            }
            fielsds = null;
        }
    },
    submitFrom: function() {
        var me = this;
        if (me.getResourceFrom().getForm().isValid()) { // 校验form是否通过校验
            var resourceModel = new Caiwei.sysset.source.ResourceNode();
            me.getResourceFrom().getForm().updateRecord(resourceModel); // 将FORM中数据设置到MODEL里面
            resourceModel.set('parentResDO',{'code':me.getResourceFrom().getForm().findField('parentRes').getValue()});
            var params = {
                    'resourceNode': resourceModel.data
            }
            var successFun = function(json) {
                var message = json.resMsg;
                console.showInfoMsg(message); // 提示新增成功
                me.close();
                me.parent.up().getResourceRoleTree().getStore().load(); // 成功之后重新查询刷新结果集
            };
            var failureFun = function(json) {
                if (Ext.isEmpty(json)) {
                    console.showErrorMes('请求超时!'); // 请求超时
                } else {
                    var message = json.resMsg;
                    console.showErrorMes(message); // 提示失败原因
                }
            };
            console.requestJsonAjax('addResource', params, successFun, failureFun); // 发送AJAX请求
        }
    },
    updateResource : function(){
        var me = this;
        if (me.getResourceFrom().getForm().isValid()) { // 校验form是否通过校验
            var resourceModel = new Caiwei.sysset.source.ResourceNode();
            me.getResourceFrom().getForm().updateRecord(resourceModel); // 将FORM中数据设置到MODEL里面
            resourceModel.set('parentResDO',{'code':me.getResourceFrom().getForm().findField('parentRes').getValue()});
            resourceModel.set('id',me.getResourceFrom().getForm().findField('id').getValue());
            var params = {
                'resourceNode': resourceModel.data
            }

            var successFun = function(json) {
                var message = json.resMsg;
                console.showInfoMsg(message); // 提示新增成功
                me.close();
                me.parent.up().getResourceRoleTree().getStore().load();// 成功之后重新查询刷新结果集
            };
            var failureFun = function(json) {
                if (Ext.isEmpty(json)) {
                    console.showErrorMes('请求超时!'); // 请求超时
                } else {
                    var message = json.resMsg;
                    console.showErrorMes(message); // 提示失败原因
                }
            };
            console.requestJsonAjax('updateResource', params, successFun, failureFun); // 发送AJAX请求
        }
    },
    setSave : function(){
        Ext.getCmp('caiwei_bse_reset_resource_but').setHidden(false);
        Ext.getCmp('caiwei_bse_save_resource_but').setHidden(false);
        Ext.getCmp('caiwei_bse_update_resource_but').setHidden(true);
        Ext.getCmp('caiwei_bse_resource_active_flag').setHidden(true);
    },
    setUpdate : function(){
        Ext.getCmp('caiwei_bse_reset_resource_but').setHidden(true);
        Ext.getCmp('caiwei_bse_save_resource_but').setHidden(true);
        Ext.getCmp('caiwei_bse_update_resource_but').setHidden(false);
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
            id : 'caiwei_bse_reset_resource_but',
            // 重置
            handler: function() {
                me.getResourceFrom().reset();
            }
        },{
            text: '保存',
            id : 'caiwei_bse_save_resource_but',
            handler: function() {
                me.submitFrom();
            }
        }, {
            text: '更新',
            id : 'caiwei_bse_update_resource_but',
            handler: function() {
                me.updateResource();
            }
        }];
        me.items = [me.getResourceFrom()];
        me.callParent([cfg]);
    }
});
/**

/**
 * 资源权限树store
 */
Ext.define('Caiwei.resource.role.ResourceTreeStore', {
    extend: 'Ext.data.TreeStore',
    root: {
        text: 'CONSOLE系统',
        id : 'console_1'// ,
        // expanded: true
    },
    proxy:{
        type:'ajax',
        url:'queryResourceByParentRes',
        actionMethods:'POST',
        reader:{
            type:'json',
            rootProperty:'nodes'
        },
        default:{expanded : true }
    },
    folderSort: true
});

// 定义web权限树
Ext.define('Caiwei.resource.role.RoleTree',{
    extend:'Ext.tree.Panel',
    id: 'Caiwei_resource_RoleTree_Id',
    height : console.getBrowserHeight() - 40,
// collapsible: true, //是否可隐藏，默认false不能
    useArrows: false, // 显示箭头
    rootVisible: false, // 根节点是否可见
    multiSelect: false,
    animate: false,   // 动画
    autoScroll : true,
    frame: true,
    resTextfield: null,
    getResTextfield: function(){
        var me = this;
        if(this.resTextfield==null){
            this.resTextfield = Ext.create('Ext.form.field.Text',{
                height:25,
                columnWidth: 0.4,

                emptyText: '输入功能名',
                /* margin:'0 0 0 19', */
                name: 'name',
                /*
                 * regex: /^(\w|[\u4E00-\u9FA5])*$/, regexText: '非法字符',
                 */
                listeners: {
                    specialkey: function(field, e){
                        if (e.getKey() == e.ENTER) {
                            me.getQueryButton().handler();
                        }
                    }
                }
            });
        }
        return this.resTextfield;
    },
    queryButton: null,
    getQueryButton: function(){
        var me = this;
        if(this.queryButton==null){
            this.queryButton = Ext.create('Ext.button.Button',{
                height:25,
                margin:'0 0 0 3',
                columnWidth: 0.2,

                text: '查询',
                handler: function(){
                    var field = me.getResTextfield(),
                        queryValue = field.getValue();

                    if(!Ext.isEmpty(queryValue)){
                        var params = {'resourceNode.name' : queryValue};
                        var successFun = function(json) {
                            var view = me.getView(),
                                position = false,
                                pathList = json.result.resourceNodes;
                            me.expandNodes = [];
                            me.collapseAll();
                            if(pathList.length==0){
                                return;
                            }
                            for(var i=0;i<pathList.length;i++){
                                me.expandPath(pathList[i],'id','/',function(success, lastNode){
                                    if(success){
                                        var nodeHtmlEl = view.getNode(lastNode),
                                            nodeEl = Ext.get(nodeHtmlEl);
                                        if(Ext.isEmpty(nodeEl)){
                                            me.expandNodes.push(lastNode);
                                            return;
                                        }
                                        var divHtmlEl = nodeEl.query('div')[0],
                                            divEl = Ext.get(divHtmlEl);
                                        divEl.highlight("ff0000", { attr: 'color', duration:50000 });
                                        if(!position){
                                            divHtmlEl.scrollIntoView();
                                            position = true;
                                        }
                                    }else{
                                        console.showErrorMes('查询失败'); //console.log('查询失败');
                                    }
                                });
                            }
                        };
                        var failureFun = function(json) {
                            if (Ext.isEmpty(json)) {
                                console.showErrorMes('请求超时'); // 请求超时
                            } else {
                                var message = json.resMsg;
                                console.showErrorMes(message);
                            }
                        };
                        //Ajax请求得到所有查询到的节点全路径
                        console.requestJsonAjax('queryTreePathForName', params, successFun, failureFun);
                    }
                }
            });
        }
        return this.queryButton;
    },
    store : Ext.create('Caiwei.resource.role.ResourceTreeStore'),
    columns: [{
        xtype: 'treecolumn', // this is so we know which column will show
        // the tree
        text: '名称',
        width: 200,
        sortable: true,
        dataIndex: 'text',
        locked: true
    },{
        text: 'id',
        width: 150,
        hidden : true,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.tid;
        }
    },{
        text: '编码',
        width: 150,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.code;
        },
        sortable: true

    },{
        text: '入口URL',
        width: 250,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.entryUri;
        }
    },{
        text: '功能层级',
        width: 100,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.resLevel;
        }
    },{
        text: '显示顺序',
        width: 100,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.displayOrder;
        }
    },{
        text: '权限检查',
        width: 100,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            if(resource.checked=='Y')
                return '是';
            if(resource.checked=='N')
                return '否';
            return resource.checked;
        }
    },{
        text: '叶子节点',
        width: 100,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            if(resource.leafFlag=='Y')
                return '是';
            if(resource.leafFlag=='N')
                return '否';
            return resource.leafFlag;
        }
    },{
        text: '图片样式',
        width: 150,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.iconCls;
        }
    },{
        text: '节点样式',
        width: 150,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.cls;
        }
    },{
        text: '描述',
        width: 150,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.notes;
        }
    },{
        text: '系统类型',
        width: 100,
        dataIndex: 'resourceNode',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.belongSystemType;
        }
    }],
    constructor: function(config){
        var me = this,
            cfg = Ext.apply({}, config);
        me.dockedItems = [{
            xtype: 'toolbar',
            dock: 'top',
            layout: 'column',
            id: 'mainNavToolbar',
            items: [me.getResTextfield(),me.getQueryButton()]
        }];
        //	me.initListeners();
        me.callParent([cfg]);
    }

});



Ext.onReady(function() {
    /**
     * 权限信息页面
     */
    Ext.QuickTips.init();
    var resourceGrid = Ext.create('Caiwei.view.resource.Grid');
    var resourceRoleTree = Ext.create('Caiwei.resource.role.RoleTree');

    Ext.create('Ext.panel.Panel', {
        renderTo : Ext.getBody(),
        id : 'resourcePanel',
        getResourceGrid : function() {
            return resourceGrid;
        },
        getResourceRoleTree : function(){
            return resourceRoleTree;
        },
        items : [resourceGrid,resourceRoleTree ]
    });
});

