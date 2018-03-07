/**
 * 主界面菜单Store
 */
Ext.define('Caiwei.store.login.MenuStore', {
    extend: 'Ext.data.TreeStore',
    root: {
        text:'WeChat系统',
        id : 'caiwei_1'//,
        //expanded: true
    },
    proxy:{
        type:'ajax',
        url:'loadTree.action',
        actionMethods:'POST',
        reader:{
            type:'json',
            rootProperty:'nodes',
        },
        default:{expanded : true }
    },
    /*autoLoad:true,*/
    folderSort: true
});