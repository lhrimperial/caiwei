
/**
 * 组织信息
 */
Ext.define('Caiwei.dataset.DepartmentDO', {
    extend: 'Ext.data.Model',
    fields : [{
        name : 'tid',
        type : 'int'
    },{
        name : 'deptCode',//组织编码
        type : 'string'
    },{
        name : 'deptName',//组织名称
        type : 'string'
    },{
        name : 'parentName',//上级组织名称
        type : 'string'
    },{
        name : 'parentCode',//上级组织标编码
        type : 'string'
    },{
        name : 'notes',//备注
        type : 'string'
    },{
        name : 'active',//物流代码
        type : 'string'
    }]
});

Ext.define('Caiwei.dataset.DepartmentGrid',{
    extend: 'Ext.grid.Panel',
    frame: true,
    autoScroll: true,
    height: 40,
    constructor: function (config) {
        var me = this,
            cfg = Ext.apply({},config);
        me.tbar = [{
            xtype:'addbutton',
            text:'新增部门',
            handler: function () {

            }
        },{
            xtepy:'updatebutton',
            id:'caiwei_dataset_department_update_id',
            text:'修改部门',
            handler: function () {

            }
        },{
            xtype:'deletebutton',
            id:'caiwei_dataset_department_delete_id',
            text:'删除',
            handler:function () {

            }
        }]
    }
});

/**
 * 组织架构基本信息查看界面
 */
Ext.define('Caiwei.dataset.OrgAuxiliaryInfoForm', {
    extend : 'Ext.form.Panel',
    title : '组织架构基本信息',
    animCollapse : true,
    collapsible : true,
    frame : true,
    width : 'auto',
    height : 280,
    layout : {
        type:'table',
        columns: 2
    },
    defaults : {
        colspan : 1,
        xtype:'displayfield',
        labelWidth:110,
        width:350,
        margin : '3 5 3 35'
    },
    constructor : function(config) {
        var me = this,
            cfg = Ext.apply({}, config);
        me.fbar = [];
        me.items = [{
            name: 'deptCode',
            fieldLabel: '组织编码'//组织编码
        },{
            name: 'parentCode',
            fieldLabel: '上级组织编码'//上级组织编码
        },{
            name: 'deptName',
            fieldLabel: '组织名称'//组织名称
        },{
            name: 'parentName',
            fieldLabel: '上级组织名称'//上级组织名称
        },{
            name: 'createTime',
            renderer: function(value) {
                return timeRender(value);
            },
            fieldLabel: '创建时间'//创建时间
        },{
            name: 'modifyTime',
            renderer: function(value) {
                return timeRender(value);
            },
            fieldLabel: '修改时间'//修改时间
        },{
            name: 'active',
            fieldLabel: '是否有效',
            renderer: function(value) {
                if (value == 'N') {
                    return "否";
                } else {
                    return "是";
                }
            }
        }];
        me.callParent([cfg]);
    }
});


Ext.define('Caiwei.dataset.DepartmentInfoPanel', {
    extend:'Ext.panel.Panel',
    frame:true,
    id:'caiwei.dataset.department_InfoPanel_Id',
    height:1782,
    layout:'auto',
    //定义mask 罩
    autoScroll:true,
    myMask:null,
    getMyMask:function(){
        if(Ext.isEmpty(this.myMask)){
            this.myMask = new Ext.LoadMask(this, {msg:"Please wait..."});
        }
        return this.myMask;
    },
    //组织架构基本信息FORM
    orgAuxiliaryInfoForm:null,
    getOrgAuxiliaryInfoForm:function(){
        if(Ext.isEmpty(this.orgAuxiliaryInfoForm)){
            this.orgAuxiliaryInfoForm = Ext.create('Caiwei.dataset.OrgAuxiliaryInfoForm');
        }
        return this.orgAuxiliaryInfoForm;
    },

    constructor : function(config) {
        var me = this,
            cfg = Ext.apply({}, config);
        me.items = [me.getOrgAuxiliaryInfoForm()//组织架构基本信息
        ];
        me.callParent([cfg]);
    }
});


/**
 * 定义功能树的store
 */
Ext.define('Caiwei.dataset.DepartmentTreeStore',{
    extend: 'Ext.data.TreeStore',
    root: {
        text:'集团',
        id : 'root',
        expanded: true
    },
    proxy:{
        type:'ajax',
        url:'loadDepartmentTree',
        actionMethods:'POST',
        reader:{
            type:'json',
            rootProperty:'nodes'
        }
    }
});

/**
 * 左侧树结构面板
 */
Ext.define('Caiwei.dataset.DepartmentTreePanel', {
    extend : 'Ext.tree.Panel',
    height : 900,
    minWidth : 200,
    autoScroll:true,
    oldFullPath:null,//刷新之前展开的路径
    useArrows: true,
    rootVisible: false,
    viewConfig: {plugins: { ptype: 'treeviewdragdrop', appendOnly: true } },
    layoutConfig : {
        // 展开折叠是否有动画效果
        animate : true
    },
    oldId:null,
    //清空数据+关闭form操作
    removeData:function(){
        var me =this;
        //获取主面板
        var departmentInfoPanel=me.up('panel').getDepartmentInfoPanel();
        departmentInfoPanel.getOrgAuxiliaryInfoForm().getForm().reset();//清空组织架构基础信息

    },
    //加载数据+和展开页面
    loadDataAndExpand:function(json){
        //获得行政组织信息
        var departmentInfoModel =new Caiwei.dataset.DepartmentDO(json.result.departmentDO);

        var me =this;
        //获取主面板
        var departmentInfoPanel=me.up('panel').getDepartmentInfoPanel();
        departmentInfoPanel.getOrgAuxiliaryInfoForm().getForm().loadRecord(departmentInfoModel);//加载组织架构基础信息
    },
    //左键单击事件
    treeLeftKeyAction:function(node,record,item,index,e){
        var me = this,
            departmentInfoPanel = me.up('panel').getDepartmentInfoPanel();
        if(Ext.isEmpty(record.raw)||record.raw.id==me.oldId){
            return;
        }else{
            me.oldId = record.raw.id;
            me.removeData();//发送请求之前先清空数据
            if(!Ext.isEmpty(record.raw)){
                var orgAdministrativeInfoModel = new Caiwei.dataset.DepartmentDO(record.raw.entity);//得到部门的model
                me.oldFullPath = orgAdministrativeInfoModel.get('fullPath');

                var params = {'deptCode':record.raw.id};
                var successFun = function(json){

                    //加载数据并展开form
                    me.loadDataAndExpand(json);
                };

                var failureFun = function(json) {
                    if (Ext.isEmpty(json)) {
                        console.showErrorMes('请求超时'); // 请求超时
                    } else {
                        var message = json.resMsg;
                        console.showErrorMes(message);
                    }
                };

                console.requestJsonAjax('loadDepartment', params, successFun, failureFun, false);

            }
        }
    },

    resTextfield: null,
    getResTextfield: function(){
        var me = this;
        if(this.resTextfield==null){
            this.resTextfield = Ext.create('Ext.form.field.Text',{
                height:25,
                columnWidth: 0.7,
                emptyText: '部门名称',//'输入功能名',
                /*margin:'0 0 0 19',*/
                name: 'name',
                /*  regex:  /^(\w|[\u4E00-\u9FA5])*$/,
                 regexText: '非法字符',*/
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
                columnWidth: 0.3,
                text: '查询',
                handler: function(){
                    var field = me.getResTextfield(),
                        queryValue = field.getValue();
                    if(!Ext.isEmpty(queryValue)){
                        var params = {'departmentDO' : {
                                'deptName' : queryValue
                            }
                        };
                        var successFun = function(json) {
                            var view = me.getView(),
                                position = false,
                                pathList = json.result;
                            me.expandNodes = [];
                            me.collapseAll();
                            if(pathList.length==0){
                                Ext.toast('没有找到部门','温馨提示','t');
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
                                        divEl.highlight("ff0000", { attr: 'color', duration:10000 });
                                        if(!position){
                                            divHtmlEl.scrollIntoView();
                                            position = true;
                                        }
                                    }else{
                                        console.log('展开失败');
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

    constructor : function(config) {
        var me = this,
            cfg = Ext.apply({}, config);
        me.store = Ext.create('Caiwei.dataset.DepartmentTreeStore');

        me.dockedItems = [{
            xtype: 'toolbar',
            dock: 'top',
            layout: 'column',
            id: 'baseinfo_orgAdministrativeToolbar_id',
            items: [me.getResTextfield(),me.getQueryButton()]
        }];

        // 监听事件
        me.listeners={
            scrollershow: function(scroller) {
                if (scroller && scroller.scrollEl) {
                    scroller.clearManagedListeners();
                    scroller.mon(scroller.scrollEl, 'scroll', scroller.onElScroll, scroller);
                }
            },
            itemclick : me.treeLeftKeyAction//单击事件
        },
        me.callParent([cfg]);
    }
});
/**
 * @description 行政组织主页
 */
Ext.onReady(function() {
    Ext.QuickTips.init();
    var departmentGrid = Ext.create('Caiwei.dataset.DepartmentGrid');
    var departmentTreeSearchPanel= Ext.create('Caiwei.dataset.DepartmentTreePanel',{width:250});//组织树查询panel
    var departmentInfoPanel = Ext.create('Caiwei.dataset.DepartmentInfoPanel',{columnWidth:1});//组织详细信息PANEL
    Ext.create('Ext.panel.Panel', {
        renderTo : Ext.getBody(),
        layout:'column',
        getDepartmentGrid : function () {
            return departmentGrid;
        },
        //组织树查询panel
        getDepartmentTreeSearchPanel : function() {
            return departmentTreeSearchPanel;
        },
        //组织详细信息PANEL
        getDepartmentInfoPanel : function() {
            return departmentInfoPanel;
        },
        items : [departmentTreeSearchPanel,departmentInfoPanel]
    });
});
