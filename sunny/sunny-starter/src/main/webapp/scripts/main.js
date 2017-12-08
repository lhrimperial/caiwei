Ext.require([
    'Ext.tab.*',
    'Ext.window.*',
    'Ext.tip.*',
    'Ext.layout.container.Border'
]);

/**-----------------------------全局属性与方法定义--------------------------------*/
(function(){
	if(typeof login == 'undefined'){
		login = {};		
	}
	//当前用户
	login.currentUser = {};
	//系统服务器端时间
	login.currentServerTime = null;
	login.queryCurrentInfo = function() {
		//Ajax请求当前登录用户信息
		Ext.Ajax.request({
			url: 'loginAction!currentLoginUserInfo.action',
			method: 'POST',
			async: false,
			success: function(response, opts) {
				var result = Ext.decode(response.responseText);
				if(result.success){
					//设置当前登录用户信息
					login.currentUser = result.currentUser;
					//设置当前服务器时间
					login.currentServerTime = new Date(result.currentServerTime+1000);
					//设置当前部门信息
					login.currentDept = result.currentDept;
				}else{
					wechat.showErrorMes("请求失败");
				}
			},
			failure:function(response){
				wechat.showErrorMes("请求失败");
			},
			exception:function(response){
				var result = Ext.decode(response.responseText);
				wechat.showErrorMes("请求失败");
			}
		});	
	};
	login.queryCurrentInfo();
	//系统业务字典
	/*login.clientVersionNo = 0;
	login.dataDictionary = new Ext.util.HashMap();
	login.queryDictionaryInfo = function(isAsync) {
		//Ajax请求业务字典信息
		Ext.Ajax.request({
			url:'../baseinfo/dataDictionaryAction!searchAllDataDictionary.action',
			method: 'POST',
			async: isAsync || false,
			success: function(response) {
				var result = Ext.decode(response.responseText),
					dataDictionary = result.dataDictionaryVo.dataDictionaryEntitys;
				login.clientVersionNo = result.clientVersionNo;
				for(var i=0;i<dataDictionary.length;i++){
					login.dataDictionary.add(dataDictionary[i].termsCode,dataDictionary[i].dataDictionaryValueEntityList);
				}
			}
		});
	};
	login.isDictionaryHasChanged = function() {
		//判断数据字典内容是否有更新
		Ext.Ajax.request({
			url: '../baseinfo/dataDictionaryAction!isDictionaryHasChanged.action',
			method: 'POST',
			params: {
				clientVersionNo: login.clientVersionNo
			},
			success: function(response) {
				var result = Ext.decode(response.responseText),
					changeFlag = result.message;
				if(changeFlag != "keep") {
					login.clientVersionNo = result.clientVersionNo;
					login.queryDictionaryInfo(true);
				}
			}
		});
	};
	login.queryDictionaryInfo();*/
	setInterval(function() {
		login.queryCurrentInfo();
//		login.isDictionaryHasChanged();
    },10*60*1000 );
})();

/**********************************************************************
 * 当前信息获得与信息的提供方法
 */
Ext.define('UserContext', {
	singleton: true,
	//获得当前用户信息
	getCurrentUser: function(){
		return login.currentUser;
	},
	//获得当前用户对应的职员信息
	getCurrentUserEmp: function(){
		if(login.currentUser){
			return login.currentUser.employee;
		}
		return null; 			
	},
	//获得当前用户部门信息
	getCurrentUserDept: function(){
		return login.currentDept;
	}
	//获得当前用户所拥有角色的编码集合
//	getCurrentUserRoleCodes: function(){
//		if(login.currentUser){
//			return login.currentUser.roleids;
//		}
//		return null;
//	}
});
/**********************************************************************/
/**********************************************************************
 * 业务字典提供方法
 */
//业务字典信息类
/*Ext.define('DataDictionary', {
	singleton: true,
	*//**
	 * 通过词条代码获得业务字典数据
	 * @param termsCode 词条代码
	 * @param valueCodes 条目编码数组
	 * @returns 业务字典数据
	 *//*
	getDataByTermsCode: function(termsCode, valueCodes){
		if(login.dataDictionary!=null&&termsCode!=null){
			var data = Ext.clone(login.dataDictionary.get(termsCode));
			if(!Ext.isEmpty(valueCodes)){
				var reslutArray = new Array();
				if(Ext.isArray(valueCodes)){
					for(var i=0;i<data.length;i++){
						if(Ext.Array.contains(valueCodes, data[i].valueCode)){
							reslutArray.push(data[i]); 
						}
					}
				}else{
					for(var i=0;i<data.length;i++){
						if(valueCodes==data[i].valueCode){
							reslutArray.push(data[i]); 
						}
					}
				}
				//此处当valueCodes为数组，但是内容无法识别(undefined)时，返回全部数据
				if(reslutArray != null && reslutArray.length > 0) {
					return reslutArray;
				} else {
					return data;
				}
				//return reslutArray;
			}
			return data;
		}
		return null; 			
	},
	*//**
	 * 通过多个词条代码获得业务字典数据数组
	 * @param termsCodes 词条代码数组
	 * @returns 业务字典数据数组
	 *//*
	getDataByTermsCodes: function(termsCodes){
		if(termsCodes==null){
			return null;		
		}
		var data = new Array();
		for(var i=0;i<termsCodes.length;i++){
			data.push(DataDictionary.getDataByTermsCode(termsCodes[i]));
		}
		return data;
	},
	*//**
	 * 根据数据字典名称获取对应的store,如果没有则返回[],不影响整个页面的渲染
	 * @param termsCode 词条代码
	 * @param id 如果想要通过store id 查询store的话就传id,否则可以不用传
	 * @param anyRecords 如果想增加一些记录到这个数据字典中，可以通过这个参数传入，
	 * 					 些参数可以是一个数据数组，也可以是一个数据
	 * @param valueCodes 条目编码数组
	 * @returns
	 *//*
	getDataDictionaryStore: function(termsCode, id, anyRecords, valueCodes){
		var data = DataDictionary.getDataByTermsCode(termsCode, valueCodes);
		if(!Ext.isEmpty(data)){
			if(!Ext.isEmpty(anyRecords)){
				if(Ext.isArray(anyRecords)){
					for(var i=0;i<anyRecords.length;i++){
						data.unshift(anyRecords[i]);					
					}
				}else{
					data.unshift(anyRecords);
				}
			}
			var json={
				fields:['valueCode','valueName'],
			    data : data
			};
			if(!Ext.isEmpty(id)){
				json["id"]=id;
			}
			return Ext.create('Ext.data.Store',json);
		}else{
			return [];
		}
	},
	*//**
	 * 根据数据字典名称获取对应的combo组件
	 * @param termsCode 词条代码
	 * @param config combo的一些配置信息
	 * @param anyRecords 如果想增加一些记录到这个数据字典中，可以通过这个参数传入，
	 * 					 些参数可以是一个数据数组，也可以是一个数据
	 * @param id 如果想要通过store id 查询store的话就传id,否则可以不用传
	 * @returns
	 *//*
	getDataDictionaryCombo: function(termsCode, config, anyRecords, id, valueCodes){
		if(Ext.isEmpty(config)){
			config = {};
		}
		var store = DataDictionary.getDataDictionaryStore(termsCode, id, anyRecords, valueCodes),
			cfg = Ext.apply(config, {
				store: store,
				displayField: 'valueName',
			    valueField: 'valueCode'
			});
		return Ext.create('Ext.form.ComboBox', cfg);

	},	
	*//**
	 *将业务字典的displayValue（数据字典显示值）转换成描述submitValue（提交值）
	 * 使用方法rendererDictionary(displayValue,’abc’);
	 * @param value  所要转换的值
	 * @param termsCode 词条代码
	 *//*
	rendererDisplayToSubmit: function(displayValue, termsCode) {
		var data = DataDictionary.getDataByTermsCode(termsCode);
		if (!Ext.isEmpty(displayValue) && !Ext.isEmpty(data)) {
			for ( var i = 0; i < data.length; i++) {
				if (displayValue == data[i].valueName) {
				     return data[i].valueCode;
				}
			}
		}
		return displayValue;
	},
	*//**
	 *将业务字典的submitValue（提交值）转换成描述displayValue（数据字典显示值）
	 * 使用方法rendererDictionary(value,’abc’);
	 * @param value  所要转换的值
	 * @param termsCode 词条代码
	 *//*
	rendererSubmitToDisplay: function(submitValue, termsCode) {
		var data = DataDictionary.getDataByTermsCode(termsCode);
		if (!Ext.isEmpty(submitValue) && !Ext.isEmpty(data)) {
			for ( var i = 0; i < data.length; i++) {
				if (submitValue == data[i].valueCode) {
				     return data[i].valueName;
				}
			}
		}
		return submitValue;
	}
});*/
/**********************************************************************/

/**
 * 主界面菜单Store
 */
Ext.define('Wechat.store.login.MenuStore', {
	extend: 'Ext.data.TreeStore',
    root: {
		text:'WeChat系统',
		id : 'ewechat_1'//,
		//expanded: true
	},
	proxy:{
		type:'ajax',
		url:'menuAction!loadTree.action',
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

//切换部门的窗口
/*Ext.define('Wechat.main.CurrentDeptChangeWindow', {
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
    									text : '查询',//'查询',
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
			Ext.create('Ext.data.Store', {
				autoLoad: true,
			    storeId:'currentDeptStore',
			    pageSize: 10,
			    fields: ['code', 'name'],
			  	proxy: {
			         type: 'ajax',
			         actionMethods : 'POST',
			         url: '../login/loginAction!currentUserChangeDepts.action',
			         reader: {
			             type: 'json',
			             root: 'userManagerDepts',
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
			        { header: '部门编码', dataIndex: 'code' },
			        { header: '部门名称',  dataIndex: 'name', flex: 1 }
			    ],
			    listeners: {
			    	'itemdblclick': function(view, record, item, index, e, eOpts){
			    		me.doChangeCurrentDept(record.get('code'));
			    	}
			    },
			    bbar: Ext.create('Ext.toolbar.Paging', {
	                store: Ext.data.StoreManager.lookup('currentDeptStore')
	            })
			});
		}
		return this.deptGridPanel;
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
	    			me.doChangeCurrentDept(record.get('code'));
	    		}
			}
	    }];
		me.callParent([cfg]);
	}
});
*/
Ext.define('Wechat.main.topPanel', {
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
//	currentDeptChangeWindow : null,
//    onChangeUserDeptSpace:function(){
//    	var me = this;
//		if(me.currentDeptChangeWindow == null){
//			me.currentDeptChangeWindow = Ext.create('Wechat.main.CurrentDeptChangeWindow');
//		}
//		me.currentDeptChangeWindow.show();
//    },
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
Ext.define('Wechat.main.MainNav',{
	extend: 'Ext.tree.Panel',
	id:'mainNav',//菜单CSS Class以此id为准
	componentCls:'ye1',
	cls:'ye1',
	bodyCls:'ye1-body',
	region : 'west',
	store:Ext.create('Wechat.store.login.MenuStore'),
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
    rootVisible: false,
    //使用vista风格的箭头图标，默认为false
    useArrows: true,
	expandNodes: [],
	resTextfield: null,
	getResTextfield: function(){
		var me = this;
		if(this.resTextfield==null){
			this.resTextfield = Ext.create('Ext.form.field.Text',{
				height:25,
				columnWidth: 0.7,
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
		    	columnWidth: 0.3,
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
	    						Wechat.log(pathList[i]);
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
	    								Wechat.log('展开失败');
	    							}
	    						});	    						
	    					}
		    	        };
		    	        var failureFun = function(json) {
		    	            if (Ext.isEmpty(json)) {
		    	                Wechat.showErrorMes('请求超时'); // 请求超时
		    	            } else {
		    	                var message = json.message;
		    	                Wechat.showErrorMes(message);
		    	            }
		    	        };
		    	        //Ajax请求得到所有查询到的节点全路径
		    	        Wechat.requestJsonAjax('../login/menuAction!queryTreePathForName.action', params, successFun, failureFun);
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
	var treePanel = Ext.create('Wechat.main.MainNav');
	var topPanel = Ext.create('Wechat.main.topPanel');
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
            bodyStyle: 'background-color:#f0f5f6; padding-left:11px; padding-right:11px;',
            itemCls: 'ui_tab_panel_itemCls',
            id:'tabPanel'
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
