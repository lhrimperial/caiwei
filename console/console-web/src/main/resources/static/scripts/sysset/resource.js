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
    },{
        name : 'parentResDO'
        // 父id

    },{
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
 * 权限store
 */
Ext.define('Caiwei.sysset.source.ResourceStore',{
    extend : 'Ext.data.Store',
    model : 'Caiwei.sysset.source.ResourceNode',
    pageSize : 20,
    proxy : {
        type : 'ajax',
        actionMethods : 'post',
        url : 'queryResourceByExample',
        reader : {
            type : 'json',
            rootProperty : 'resourceNodes',
            totalProperty : 'totalCount' // 总个数
        }
    },
    listeners : {
        beforeload : function(store, operation, eOpts) {
            var params = {
                'resourceNode.code':'console_1'
            };
            Ext.apply(store.proxy.extraParams, params);
        }
    }
});

/**
 * 权限查询表单
 */
Ext.define('Caiwei.sysset.source.queryFrom',{
    extend : 'Ext.form.Panel',
    id : 'caiwei_sysset_resoure_queryfrom_id',
    frame : true,
//	title : '查询条件',
    height : 70,
    collapsible : false,
    layout : 'column',
    defaults : {
        rowspan : 2,
        margin : '8 10 0 0',
        labelAlign : 'right'
    },
    defaultType : 'textfield',
    constructor : function(config) {
        var me = this,
            cfg = Ext.apply({}, config);
        me.items = [{
                name : 'firstCode',
                fieldLabel: '权限',
                columnWidth: 0.4,
                xtype : 'textfield'
            }];
        me.buttons = [{
                text : '查询',
                handler : function() {
                    me.up().getResourceGrid().getPagingToolbar().moveFirst();
                }
            }, {
                text : '清空',
                handler : function() {
                    me.getForm().reset();
                }
            } ];
        me.callParent([ cfg ]);
    }
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
    getaddResourceWindow : function(){
        if (this.addResourceWindow == null) {

            this.addResourceWindow = Ext.create('Butterfly.view.addResource.window');
            this.addResourceWindow.parent = this; // 父元素
        }
        return this.addResourceWindow;
    },
    changResource :function(){
        var me = this;
        var selections = me.up().getresourceTree().getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length != 1) { // 判断是否选中了一条
            butterfly.showWoringMessage(baseinfo.resource.i18n('bse.route.selectedone')); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var winIn = me.getaddResourcewindow();
        winIn.show();
        winIn.setTitle(baseinfo.resource.i18n('butterfly.common.update'));//修改');
        changbox = winIn.getResourceFrom().getForm();
        winIn.setupdate();
        var resobj = selections[0].get('resourceEntity');
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
        Ext.getCmp('butterfly_bse_resource_sele').setCombValue(resobj.parentRes.name,resobj.parentRes.code);
        changbox.findField('code').setReadOnly(true);
        changbox.findField('name').setReadOnly(true);

    },
    deleteResource : function(){
        var me = this;
        var selections = me.up().getresourceTree().getSelectionModel().getSelection(); // 获取选中的数据
        if (selections.length < 1) { // 判断是否至少选中了一条
            butterfly.showWoringMessage(baseinfo.route.i18n('bse.resource.selectedone')); // 请选择一条进行作废操作！
            return; // 没有则提示并返回
        }
        var resourceEntityList = new Array();
        for (var i = 0; i < selections.length; i++) {
            resourceEntityList.push({
                'id': selections[0].get('resourceEntity').id,
                'code': selections[0].get('resourceEntity').code
            });
        }
        butterfly.showQuestionMes(baseinfo.resource.i18n('bse.resource.deleteresource'),//'是否要删除?其子节点也将被删除',
            function(e) {
                if (e == 'yes') { // 询问是否删除，是则发送请求
                    var params = {
                        'resourceVo': {
                            'resourceEntityList': resourceEntityList
                        }
                    };
                    var successFun = function(json) {
                        var message = json.message;
                        butterfly.showInfoMsg(message);
                        me.up().getresourceTree().getStore().load();
                    };
                    var failureFun = function(json) {
                        if (Ext.isEmpty(json)) {
                            butterfly.showErrorMes(baseinfo.resource.i18n('bse.resource.timeout')); // 请求超时
                        } else {
                            var message = json.message;
                            butterfly.showErrorMes(message);
                        }
                    };
                    butterfly.requestJsonAjax('resourceAction!deleteResource.action', params, successFun, failureFun);
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
                // var winIn = me.getaddResourcewindow();
                // winIn.show();
                // winIn.setTitle(baseinfo.resource.i18n('butterfly.common.add'));//'新增');
                // changbox = winIn.getResourceFrom().getForm();
                // winIn.setsave();
                // changbox.findField('code').setReadOnly(false);
                // changbox.findField('name').setReadOnly(false);
            }
        },'-',{
            xtype :'updatebutton',
            id : 'caiwei_sysset_resource_update_id',
            text : '修改',
            handler : function() {
                // me.changResource();
            }
        },'-',{
            xtype : 'deletebutton',
            id : 'caiwei_sysset_resource_delete_id',
            text : '删除',
            handler : function() {
                // me.deleteResource();
            }
        }];
        me.store = Ext.create('Caiwei.sysset.source.ResourceStore', {
            autoLoad : false
        });
        me.callParent([ cfg ]);
    }
});

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
        dataIndex: 'resourceDO',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.tid;
        }
    },{
        text: '编码',
        width: 150,
        dataIndex: 'resourceDO',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.code;
        },
        sortable: true

    },{
        text: '入口URL',
        width: 250,
        dataIndex: 'resourceDO',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.entryUri;
        }
    },{
        text: '功能层级',
        width: 100,
        dataIndex: 'resourceDO',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.resLevel;
        }
    },{
        text: '显示顺序',
        width: 100,
        dataIndex: 'resourceDO',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.displayOrder;
        }
    },{
        text: '权限检查',
        width: 100,
        dataIndex: 'resourceDO',
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
        dataIndex: 'resourceDO',
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
        dataIndex: 'resourceDO',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.iconCls;
        }
    },{
        text: '节点样式',
        width: 150,
        dataIndex: 'resourceDO',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.cls;
        }
    },{
        text: '描述',
        width: 150,
        dataIndex: 'resourceDO',
        renderer: function(resource) {
            if(resource==null||resource=='')
                return '';
            return resource.notes;
        }
    },{
        text: '系统类型',
        width: 100,
        dataIndex: 'resourceDO',
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
    var queryForm = Ext.create('Caiwei.sysset.source.queryFrom');
    var resourceGrid = Ext.create('Caiwei.view.resource.Grid');
    var resourceRoleTree = Ext.create('Caiwei.resource.role.RoleTree');

    Ext.create('Ext.panel.Panel', {
        renderTo : Ext.getBody(),
        id : 'resourcePanel',
        getQueryForm: function(){
          return queryForm;
        },
        getResourceGrid : function() {
            return resourceGrid;
        },
        getResourceRoleTree : function(){
            return resourceRoleTree;
        },
        items : [/*queryForm,*/resourceGrid,resourceRoleTree ]
    });
});

