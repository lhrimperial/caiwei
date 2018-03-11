/**
 * 主界面菜单Store
 */
Ext.define('Caiwei.store.login.MenuStore', {
    extend: 'Ext.data.TreeStore',
    root: {
        text:'CONSOLE系统',
        id : 'console_1',
        expanded: true
    },
    proxy:{
        type:'ajax',
        url:'loadTree',
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