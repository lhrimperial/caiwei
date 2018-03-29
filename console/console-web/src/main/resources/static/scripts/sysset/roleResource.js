/**
 * 全局变量及函数
 */
var baseinfo = {};
baseinfo.role={};
baseinfo.role.resourceCodes=new Array();
baseinfo.role.deleteResourceCodes=new Array();

baseinfo.role.resourceAppCodes=new Array();
baseinfo.role.deleteAppResourceCodes=new Array();
// 当前操作的角色
baseinfo.role.currRoleCode="";

baseinfo.role.currAppRoleCode="";
/**
 * 字符串数组操作
 */
baseinfo.role.removeStr = function(p_array, str){
    if(p_array==null || p_array.length==0){
        return p_array;
    }
    for(var i=0,l=p_array.length;i<l;i++){
        if(p_array[i]==str){
            p_array.splice(i,1);
            return p_array;
        }
    }
    return p_array;
};

/**
 * 字符串数组操作
 */
baseinfo.role.removeAppStr = function(p_array, str){
    if(p_array==null || p_array.length==0){
        return p_array;
    }

    for(var i=0,l=p_array.length;i<l;i++){
        if(p_array[i]==str){
            p_array.splice(i,1);
            return p_array;
        }
    }
    return p_array;
};

//扩展方法去掉数组指定元素
Array.prototype.indexOf = function(val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
    }
    return -1;
};
Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};

// checked所有父结点
baseinfo.role.checkParent = function(node,checked){
    var parentNode = node.parentNode;
    if(parentNode){
        if(parentNode.data.checked==false){
            baseinfo.role.resourceCodes.push(parentNode.data.id);
            baseinfo.role.removeStr(baseinfo.role.deleteResourceCodes,parentNode.data.id);
            parentNode.set('checked',true);
        }
        baseinfo.role.checkParent(parentNode,checked);
    }
};

baseinfo.role.checkAppParent = function(node,checked){
    var parentNode = node.parentNode;
    if(parentNode){
        if(parentNode.data.checked==false){
            baseinfo.role.resourceAppCodes.push(parentNode.data.id);
            baseinfo.role.removeAppStr(baseinfo.role.deleteAppResourceCodes,parentNode.data.id);
            parentNode.set('checked',true);
        }
        baseinfo.role.checkAppParent(parentNode,checked);
    }
};

baseinfo.role.setRoleCode = function(roleCode){
    var resourceVo=new Object();
    resourceVo.currRoleCode= roleCode;
    var r_url = "setCurrRoleCode";
    r_url=	baseinfo.realPath(r_url) ;
    Ext.Ajax.request({
        url: r_url,
        jsonData:resourceVo,
        success:function(response){
            var result = Ext.decode(response.responseText);
            if(result.success){
                var treeData= result.nodes;
                return treeData;
            }else{
            }
        }
    });
};

baseinfo.role.setAppRoleCode = function(roleCode){
    var resourceVo=new Object();
    resourceVo.currAppRoleCode= roleCode;
    var params = {'resourceVo':resourceVo};
    var r_url = "setCurrRoleCode.action";
    r_url=	baseinfo.realPath(r_url) ;
    Ext.Ajax.request({
        url: r_url,
        jsonData:params,
        success:function(response){
            var result = Ext.decode(response.responseText);
            if(result.success){
                treeData= result.nodes;
                return treeData;
            }else{
            }
        }
    });
};

// 重新加载树结点
baseinfo.role.reloadTreeNode = function(){
    // 重新加载树结点：
    var resourceTree=Ext.getCmp('Caiwei_baseinfo_role_RoleTree_Id'),
        treeStore = resourceTree.getStore(),
        rootNode = treeStore.getRootNode()
    treeStore.load({
        node: rootNode,
        callback: function(records, operation, success){
            rootNode.expand();
        }
    });
    // 加载树结点时，初始化已选树结点，作废的树结点
    baseinfo.role.resourceCodes=new Array();
    baseinfo.role.deleteResourceCodes=new Array();
};

//重新加载树结点
baseinfo.role.reloadAppTreeNode = function(){
    // 重新加载树结点：
    var resourceTree=Ext.getCmp('Caiwei_baseinfo_role_AppRoleTree_Id'),
        treeStore = resourceTree.getStore();
    rootNode = treeStore.getRootNode()
    treeStore.load({
        node: rootNode,
        callback: function(records, operation, success){
            rootNode.expand();
        }
    });
    // 加载树结点时，初始化已选树结点，作废的树结点
    baseinfo.role.resourceAppCodes=new Array();
    baseinfo.role.deleteAppResourceCodes=new Array();
};

// 重新加载查看的树结点
baseinfo.role.reloadSeeTreeNode = function(){
    // 重新加载树结点：
    var resourceTree=Ext.getCmp('Caiwei_baseinfo_role_SeeRoleTree_Id'),
        treeStore = resourceTree.getStore();
    rootNode = treeStore.getRootNode()
    treeStore.load({
        node: rootNode,
        callback: function(records, operation, success){
            rootNode.expand();
        }
    });
    // 加载树结点时，初始化已选树结点，作废的树结点
    baseinfo.role.resourceCodes=new Array();
    baseinfo.role.deleteResourceCodes=new Array();
};

//重新加载查看的树结点
baseinfo.role.reloadAppSeeTreeNode = function(){
    // 重新加载树结点：
    var resourceTree=Ext.getCmp('Caiwei_baseinfo_role_SeeAppRoleTree_Id'),
        treeStore = resourceTree.getStore();
    rootNode = treeStore.getRootNode()
    treeStore.load({
        node: rootNode,
        callback: function(records, operation, success){
            rootNode.expand();
        }
    });
    // 加载树结点时，初始化已选树结点，作废的树结点
    baseinfo.role.resourceAppCodes=new Array();
    baseinfo.role.deleteAppResourceCodes=new Array();
};

/**
 * 权限配置窗口
 */
Ext.define('Caiwei.sysset.role.ResourceWindow', {
    extend: 'Ext.window.Window',
    closable: true,
    parent: null,
    title: "角色权限配置",
    closeAction : 'hide',
    width: 400,
    height: 400,
    layout: "fit",
    modal:true,
    roleTab: null,
    getRoleTab: function(){
        if(this.roleTab==null){
            this.roleTab = Ext.create("Caiwei.view.role.RoleTab");
        }
        return this.roleTab;
    },
    listeners: {
        beforeshow: function(me) {
            // 显示WINDOW的时候重新加载树
            baseinfo.role.reloadTreeNode();
        }
    },
    constructor: function(config) {
        var me = this,
            cfg = Ext.apply({},
                config);
        me.fbar = [{
            text: '提交',
            handler: function(){
                var roleVo = new Object();
                roleVo.resourceCodes = baseinfo.role.resourceCodes.join(",");
                roleVo.deleteResourceCodes = baseinfo.role.deleteResourceCodes.join(",");
                var selectArr = Ext.getCmp('roleGrid').getSelectionModel().getSelection();
                roleVo.currRoleCode = selectArr.length > 0 ? selectArr[0].get('roleCode') : '';
                var successFun = function(json) {
                    var message = json.resMsg;
                    console.showInfoMsg(message);
                    baseinfo.role.reloadTreeNode();
                };
                var failureFun = function(json) {
                    if (Ext.isEmpty(json)) {
                        config.showErrorMes('请求超时'); // 请求超时
                    } else {
                        var message = json.resMsg;
                        console.showErrorMes(message);
                    }
                };
                console.requestJsonAjax('updateRoleResource', roleVo, successFun, failureFun);
            }
        }];
        me.items = [me.getRoleTab()];
        me.callParent([cfg]);
    }
});

//角色权限TAB
Ext.define('Caiwei.view.role.RoleTab',{
    extend:'Ext.tab.Panel',
    frame : false,
    activeTab : 0,
    columnWidth: 1,
    webRoleTreeItem:null,
    getWebRoleTreeItem:function(){
        var me=this;
        if(Ext.isEmpty(me.webRoleTreeItem)){
            me.webRoleTreeItem = Ext.create('Caiwei.view.role.RoleTree');
        }
        return me.webRoleTreeItem;
    },
    AppRoleTreeItem:null,
    getAppRoleTreeItem:function(){
        var me=this;
        /*if(Ext.isEmpty(me.AppRoleTreeItem)){
         me.AppRoleTreeItem= Ext.create('Butterfly.baseinfo.role.AppRoleTree')
         }*/
        return me.AppRoleTreeItem;
    },
    listeners: {
        tabchange : function(tabPanel,newCard,oldCard,eOpts ){
            /*if(baseinfo.resource.SEARCH_TYPE_App == newCard.getItemId()){
             baseinfo.resource.search(null);
             }*/
        }
    },
    initComponent: function(config){
        var me = this,
            cfg = Ext.apply({}, config);
        me.items = [{
                title : 'WEB角色权限',
                itemId:'WEB',
                tabConfig : {
                    width : 120
                },
                items : [
                    me.getWebRoleTreeItem()
                ]
            }/*,{
                title : 'APP角色权限',
                itemId:'APP',
                tabConfig : {
                    width : 120
                },
                items : [
                    me.getAppRoleTreeItem()
                ]
            }*/]
        me.callParent([cfg]);
    }
});

/**
 * 资源权限树store
 */
Ext.define('Caiwei.baseinfo.role.ResourceTreeStore', {
    extend: 'Ext.data.TreeStore',
    root: {
        text:'CONSOLE系统',
        id : 'console_1',
        //expanded: true
    },
    proxy:{
        type:'ajax',
        url:'queryResourceByParentResChecked',
        actionMethods:'POST',
        reader:{
            type:'json',
            rootProperty:'nodes',
        },
        default:{expanded : true }
    },
    listeners : {
        beforeload : function(store, operation, eOpts) {
            // 选中的数据
            var selectArr = Ext.getCmp('roleGrid').getSelectionModel().getSelection();
            var searchParams = store.proxy.extraParams;
            var params = {
                'roleDO.roleCode' : selectArr.length > 0 ? selectArr[0].get('roleCode') : ''
            }
            Ext.apply(store.proxy.extraParams, params);
        }
    }
});

//定义web权限树
Ext.define('Caiwei.view.role.RoleTree',{
    extend:'Ext.tree.Panel',
    id: 'Caiwei_baseinfo_role_RoleTree_Id',
    animate: false,
    autoScroll : true,
    useArrows: true,
    frame: true,
    rootVisible: true,
    height : 300,
    deSelectParentFunction : function(node) {
        if (node.data.id == this.store.root.id)
            return;
        var parentNode = node.parentNode;
        if (parentNode.hasChildNodes()) {
            for (var i = 0; i < parentNode.childNodes.length; i++) {
                var childNode = parentNode.childNodes[i];
                if (childNode.data.checked == true) {
                    return;
                }
            }
        }
        if(parentNode.data.id != this.store.root.id){
            var a_code=parentNode.data.id;
            baseinfo.role.deleteResourceCodes.push(a_code);
            baseinfo.role.removeStr(baseinfo.role.resourceCodes, a_code);
            parentNode.set("checked", false);
        }
        this.deSelectParentFunction(parentNode);
    },
    deSelectChildFunction : function(node) {
        if (node.hasChildNodes()) {
            for (var i = 0; i < node.childNodes.length; i++) {
                var childNode = node.childNodes[i];
                childNode.set("checked", false);
                var a_code=childNode.data.id;
                baseinfo.role.deleteResourceCodes.push(a_code);
                baseinfo.role.removeStr(baseinfo.role.resourceCodes, a_code);
                this.deSelectChildFunction(childNode);
            }
        }
    },
    checkChange : function(node, checked) {
        var a_code=node.data.id;
        if (checked == true) {
            baseinfo.role.checkParent(node, true);
            //this.selectChildFunction(node, true);
            baseinfo.role.resourceCodes.push(a_code);
            baseinfo.role.removeStr(baseinfo.role.deleteResourceCodes, a_code);
        } else {
            //去除用户取消的编码
            //this.selectChildFunction(node, false);
            // 判断父节点下是否还有子节点是选中状态
            this.deSelectParentFunction(node);
            //如果是取消树结点，先判断是否还有下级已选择的树结点，如果有，则递归作废
            this.deSelectChildFunction(node);
            baseinfo.role.deleteResourceCodes.push(a_code);
            baseinfo.role.removeStr(baseinfo.role.resourceCodes, a_code);

        }
    },
    constructor: function(config){
        var me = this,
            cfg = Ext.apply({}, config);
        me.store = Ext.create('Caiwei.baseinfo.role.ResourceTreeStore');
        me.tbar = [{
            xtype: 'textfield',
            id: 'Caiwei_baseinfo_role_RoleTree_QueryText_Id',
            name:'name',
            fieldLabel:'权限名称',
            labelWidth: 70
        },{
            text: '查询',
            margin:'5 10 5 5',
            handler: function(){
                var a_name= Ext.getCmp('Caiwei_baseinfo_role_RoleTree_QueryText_Id');
                var resourceVo = new Object();
                resourceVo.resourceNode.name = a_name.getValue();
                // 将角色名称发送到后台：
                //TODO
            }
        }];
        // 监听鼠标事件
        me.listeners = {
            // 当树结点被选择（checked)
            checkchange : me.checkChange
        };
        me.callParent([cfg]);
    }
});
