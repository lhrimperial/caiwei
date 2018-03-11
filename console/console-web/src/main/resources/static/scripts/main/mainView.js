Ext.require([
    'Ext.tab.*',
    'Ext.window.*',
    'Ext.tip.*',
    'Ext.layout.container.Border'
]);

var allChildrenPanel = {};

//切换部门的窗口
Ext.define('Caiwei.main.CurrentDeptChangeWindow', {
    extend: 'Ext.window.Window',
    title: '切换部门',
    height: 400,
    width: 400,
    modal:true,
    closeAction: 'hide',
    layout: {
        type:'vbox',
        padding:'5',
        align:'stretch'
    },
    //部门搜索框
    searchDept : null,
    getSearchDept : function(){
        var me = this;
        if(this.searchDept==null){
            this.searchDept=Ext.create('Ext.form.Panel', {
                labelWidth: 75,
                frame: false,
                height:30,
                layout:'column',
                margin : '0 0 5 0',
                items: [{
                    xtype: 'textfield',
                    name: 'deptName',
                    columnWidth : .5,
                    margin : '2 0 0 0',
                    allowBlank: true,
                    emptyText: '请输入部门',
                    anchor: '-250 100%'
                },{
                    border: false,
                    xtype: 'container',
                    columnWidth: .2,
                    defaults: {
                        margin : '0 0 0 10'
                    },
                    items : [{
                        xtype : 'button',
                        width: 80,
                        text : '查询',
                        handler : function(){
                            me.getDeptGridPanel().getStore().load();
                        }
                    } ]
                }]
            });
        }
        return this.searchDept;
    },
    //部门列表
    deptGridPanel : null,
    getDeptGridPanel : function(){
        var me = this;
        if(this.deptGridPanel==null){
            var store = Ext.create('Ext.data.Store', {
                autoLoad: true,
                storeId:'currentDeptStore',
                pageSize: 10,
                fields: ['deptCode', 'deptName'],
                proxy: {
                    type: 'ajax',
                    actionMethods : 'POST',
                    url: 'currentUserChangeDepts',
                    reader: {
                        type: 'json',
                        root: 'departmentDOS',
                        totalProperty: 'totalCount'
                    }
                },
                listeners: {
                    'beforeload': function(store, operation, eOpts){
                        var queryParams = me.getSearchDept().getForm().getValues();
                        var params = {
                            'deptName' : queryParams.deptName
                        }
                        Ext.apply(store.proxy.extraParams, params);
                    }
                }
            });
            this.deptGridPanel = Ext.create('Ext.grid.Panel', {
                height: 290,
                autoScroll: true,
                store: Ext.data.StoreManager.lookup('currentDeptStore'),
                selModel:  Ext.create('Ext.selection.CheckboxModel', {
                    mode: 'SINGLE',
                    checkOnly: true
                }),
                columns: [
                    { header: '部门编码', dataIndex: 'deptCode' },
                    { header: '部门名称',  dataIndex: 'deptName', flex: 1 }
                ],
                listeners: {
                    'itemdblclick': function(view, record, item, index, e, eOpts){
                        me.doChangeCurrentDept(record.get('deptCode'));
                    }
                },
                bbar: Ext.create('Ext.toolbar.Paging', {
                    store: Ext.data.StoreManager.lookup('currentDeptStore')
                })
            });
        }
        return this.deptGridPanel;
    },
    doChangeCurrentDept: function(deptCode){
        var params = {
            'deptCode' : deptCode
        };
        var successFun = function(json) {
            window.location = 'main';
        };
        var failureFun = function(json) {
            if (Ext.isEmpty(json)) {
                Caiwei.showErrorMes('请求超时'); // 请求超时
            } else {
                var message = json.resMsg;
                Caiwei.showErrorMes(message);
            }
        };
        Caiwei.requestAjax('changeCurrentDept', params, successFun, failureFun);
    },
    constructor: function(config){
        var me = this,
            cfg = Ext.apply({}, config);
        me.items = [me.getSearchDept(),me.getDeptGridPanel()];
        me.buttons = [{
            text: '切换部门',
            handler : function(){
                var selects = me.getDeptGridPanel().getSelectionModel().getSelection();
                if(selects&&selects.length>0){
                    var record = selects[0];
                    me.doChangeCurrentDept(record.get('deptCode'));
                }
            }
        }];
        me.callParent([cfg]);
    }
});

Ext.define('Caiwei.main.topPanel', {
    extend: 'Ext.container.Container',
    id : 'banner',
    frame: true,
    region : 'north',
    style: {background:'#FFFFFF'},
    height : 60,
    layout: {
        type: 'hbox',
        pack: 'start',
        align: 'middle'
    },
    //当前登录信息
    userInfo:null,
    getUserInfo:function(){
        if(this.userInfo==null){
            var htmlText = '<span style="font-size: 18px; font-weight: bold;">&nbsp;&nbsp;登录人:<span style="color:#F15B23;">'+UserContext.getCurrentUser().empName+'&nbsp;&nbsp;&nbsp;&nbsp;</span>当前部门:</span>';
            this.userInfo =Ext.create('Ext.panel.Panel',{
                html: htmlText
            });
        }
        return this.userInfo;
    },
    deptInfo:null,
    getDeptInfo:function(){
        var me = this;
        if(this.deptInfo==null){
            var deptText = '<span style="font-size: 18px; font-weight: bold;color:#F15B23;">'+UserContext.getCurrentUserDept().deptName+'</span>';
            this.deptInfo =Ext.create('Ext.Button',{
                text: deptText,
                style:'background-color:transparent;border-color: transparent;',
                handler: me.onChangeUserDeptSpace
            });
        }
        return this.deptInfo;
    },
    //切换当前部门
    currentDeptChangeWindow : null,
    onChangeUserDeptSpace:function(){
        var me = this;
        if(me.currentDeptChangeWindow == null){
            me.currentDeptChangeWindow = Ext.create('Caiwei.main.CurrentDeptChangeWindow');
        }
        me.currentDeptChangeWindow.show();
    },
    //当前时间
    dateTimeSpace: null,
    getDateTimeSpace: function(){
        if(this.dateTimeSpace==null){
            var htmlText = "";
            if(!Ext.isEmpty(login.currentServerTime)){
                htmlText = '<span style="font-size: 18px; font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;'+constructDateTime(login.currentServerTime)+'</span>';
            }
            this.dateTimeSpace =Ext.create('Ext.panel.Panel',{
                id: 'dateTimeSpace',
                html: htmlText
            });
        }
        return this.dateTimeSpace;
    },

    constructor: function(config){
        var me = this,
            cfg = Ext.apply({}, config);
        me.items = [{
            contentEl: 'logoImageDiv'
        },me.getUserInfo(),me.getDeptInfo(),{
            xtype: 'tbspacer',
            flex : 1
        },me.getDateTimeSpace(),{
            contentEl: 'loginoutDiv'
        }];
        me.callParent([cfg]);
    }
});
//导航菜单树
Ext.define('Caiwei.main.MainNav',{
    extend: 'Ext.tree.Panel',
    id:'mainNav',//菜单CSS Class以此id为准
    componentCls:'ye1',
    cls:'ye1',
    bodyCls:'ye1-body',
    region : 'west',
    store:Ext.create('Caiwei.store.login.MenuStore'),
    collapsible : false,
    viewConfig :{
        loadMask: false
    },
    width : 200,
    /*singleExpand:true,*/
    border:false,
    minWidth:200,
    maxWidth:200,
    autoScroll: true,
    //树节点是否可见
    rootVisible: true,
    //使用vista风格的箭头图标，默认为false
    useArrows: true,
    expandNodes: [],
    resTextfield: null,
    getResTextfield: function(){
        var me = this;
        if(this.resTextfield==null){
            this.resTextfield = Ext.create('Ext.form.field.Text',{
                height:25,
                columnWidth: 0.65,
                emptyText: '输入功能名',//'输入功能名',
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
                columnWidth: 0.35,
                text: '查询',
                handler: function(){
                    var field = me.getResTextfield(),
                        queryValue = field.getValue();
                    //"br"/"bl"/"tr"/"tl"/"t"/"l"/"b"/"r"
                    if(!Ext.isEmpty(queryValue)){
                        var params = {'node' : queryValue};
                        var successFun = function(json) {
                            var view = me.getView(),
                                position = false,
                                pathList = json.pathList;
                            me.expandNodes = [];
                            me.collapseAll();
                            if(pathList.length==0){
                                /*Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),login.i18n('foss.login.notFindMenu'), 'error', 1000);*/
                                return;
                            }
                            for(var i=0;i<pathList.length;i++){
                                Caiwei.log(pathList[i]);
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
                                        Caiwei.log('展开失败');
                                    }
                                });
                            }
                        };
                        var failureFun = function(json) {
                            if (Ext.isEmpty(json)) {
                                Caiwei.showErrorMes('请求超时'); // 请求超时
                            } else {
                                var message = json.message;
                                Caiwei.showErrorMes(message);
                            }
                        };
                        //Ajax请求得到所有查询到的节点全路径
                        Caiwei.requestJsonAjax('queryTreePathForName', params, successFun, failureFun);
                    }
                }
            });
        }
        return this.queryButton;
    },
    initListeners : function(){
        var mainNav = this;
        mainNav.listeners = {
            //点击主菜单节点：
            itemclick: function(node, record,item,index,e,eOpts){
                if(!record.get('leaf')){
                    if(record.get('expanded')){
                        node.collapse(record);
                    }else{
                        node.expand(record);
                    }
                }
                //点击菜单加载页面
                initTabpanel(record.get('id'),record.get('text'),record.get('uri'),record.get('leaf'));
            }
        };
    },
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
        me.initListeners();
        me.callParent([cfg]);
    }
});
Ext.onReady(function(){
    var treePanel = Ext.create('Caiwei.main.MainNav');
    var topPanel = Ext.create('Caiwei.main.topPanel');
    Ext.create('Ext.Viewport', {
        listeners:{
            //渲染结束后开始右上时间更新。每一秒更新一次。
            afterrender : function(){
                setInterval(
                    function(){
                        if(!Ext.isEmpty(login.currentServerTime) && !Ext.isEmpty(Ext.getCmp('dateTimeSpace'))){
                            var htmlText = htmlText = '<span style="font-size: 18px; font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;'+constructDateTime(login.currentServerTime)+'</span>';
                            Ext.getCmp('dateTimeSpace').update(htmlText);
                            login.currentServerTime = new Date((login.currentServerTime).getTime()+1000);
                        }
                    },1000
                );
            }
        },
        header: {
            titlePosition: 0,
            titleAlign: 'center'
        },
        renderTo: Ext.getBody(),
        layout: {
            type: 'border',
            padding: 0,
            margin: 0
        },
        items: [
            topPanel,
            treePanel,
            {
                region: 'center',
                xtype: 'tabpanel',
                bodyStyle: 'background-color:rgb(230, 233, 236); padding-left:11px; padding-right:11px;',
                itemCls: 'ui_tab_panel_itemCls',
                id:'tabPanel',
                items:[{
                    'id': 'homePage',
                    'title': "首页",
                    closable:false,
                    border:false,
                    html: '<iframe id="homePage" src="homePage" style="height:100%;width:100%;padding:0px;margin:0px;" frameborder="0"></iframe>'
                    //html:text
                }]

            }]
    });
});

/**
 * 新增TAB
 * King
 * 2015年5月13日14:02:58
 */
function initTabpanel(id,text,uri,leaf){
    if(false == leaf){
        return;
    }
    var tabs = Ext.getCmp('tabPanel');
    if (tabs) {
        var tab = tabs.getComponent(id);
        //判断是否已经打开该面板
        if (!tab) {
            tab = tabs.add({
                'id': id,
                'title': text,
                closable:true,
                border:false,
                html: '<iframe id="'+id+'" src="'+uri+'" style="height:100%;width:100%;padding:0px;margin:0px;" frameborder="0"></iframe>'
                //html:text
            });
        }
        tabs.setActiveTab(tab);
    }
}

/**
 * 删除TAB
 * King
 * 2015年5月13日14:02:58
 */
function delTabpanel(id){
    var tabs = Ext.getCmp('tabPanel');
    if (tabs) {
        var tab = tabs.getComponent(id);
        if (tab) {
            tabs.remove(tab);
        }
    }
}

//生成当前日期
function constructDateTime(today){
    var dd = today.getDate(),
        mm = today.getMonth()+1, //January is 0!
        yyyy = today.getFullYear(),
        hh = today.getHours(),
        minutes = today.getMinutes(),
        ss=today.getSeconds();
    if(dd<10){dd='0'+dd;}
    if(mm<10){mm='0'+mm;}
    if(hh<10){hh='0'+hh;}
    if(minutes<10){minutes='0'+minutes;}
    if(ss<10){ss='0'+ss;}
    today = yyyy+'-'+mm+'-'+dd+' '+hh+':'+minutes+':'+ss;
    return today;
}
