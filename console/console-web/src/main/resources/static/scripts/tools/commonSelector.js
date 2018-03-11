//下拉单选框
Ext.define('Caiwei.commonSelector.CommonCombSelector', {
	extend : 'Caiwei.commonselector.DynamicComboSelector',
	minChars : 0,
	disableKeyFilter: true,
	isPaging : false,// 分页
	isEnterQuery : true,// 回车查询
	listWidth : 200,// 设置下拉框宽度
	active : null,
	myActive : 'Y',
	record : null,
	displayField : null,
	valueField : null, 
	displayField : null,// 显示名称
	valueField : null,// 值
	queryParam : null,// 查询参数
	realValue : null,
	setCombValue : function(displayText, valueText) {
		var me = this, key = me.displayField + '', value = me.valueField
				+ '';
		var m = Ext.create(me.store.getModel().getName());
		m.set(key, displayText);
		m.set(value, valueText);
		me.record = m;
		me.store.loadRecords([m]);
		me.setValue(valueText);
		me.realValue = valueText;
	},
	listeners: {
        /*change: function(comb, newValue, oldValue, eOpts){
        		if(comb.isExpanded==true){
					comb.collapse();
				}
				if(newValue != oldValue){
					comb.realValue = null;
				}
        },*/
        //失去焦点时校验是否做出选择，未做出选择清空下拉框
		blur:function(comb, the, eOpts){
			if (Ext.isEmpty(comb.realValue)) {
				comb.setRawValue(null);
				comb.setValue(null);
			}else{
				var display = comb.record.data[comb.displayField];
				if(!Ext.Object.equals(display,comb.getRawValue())){
					comb.setRawValue(null);
					comb.setValue(null);
					comb.realValue = null;
				}
			}
		},
		select:function(comb, records, obs){
			comb.record = records;
			var data = records.data;
			comb.realValue = data[comb.valueField];
			//显示情况控件
			comb.getTrigger('clear').show();
		},
		keyup : function(combo, event, eOpts){
			//下拉框输入值
			var value = combo.getRawValue();
			//情况控件
			var clearTrigger = combo.getTrigger('clear');
	        if(!Ext.isEmpty(value)){
	        	//输入不为空显示情况控件
	        	clearTrigger.show();
	        }else{
	        	//隐藏情况控件
	        	clearTrigger.hide();
	        }
	        //关闭下拉框
	        //combo.collapse();
			if(combo.isEnterQuery == true && event.getKey() == event.ENTER){
				var rawValue = combo.getRawValue();
				combo.store.loadPage(1,{
					scope: this,
					callback: function(records, operation, success) {
						if(records.length>0){
							//展开下拉框
							combo.expand();
						}
						combo.setRawValue(rawValue);
					}
				});
			}
		}
    },
	
	getBeforeLoad : function(store, operation, e) {
		var me = this;
		var me = this, searchParams = operation.getParams();
		if (Ext.isEmpty(searchParams)) {
			searchParams = {};
		}
		var prefix = me.queryParam.substring(0, me.queryParam
						.lastIndexOf('.'))
				+ '.';
		var param = prefix + me.myQueryParam;
		if (!Ext.isEmpty(me.myQueryParam)) {
			searchParams[param] = me.getRawValue();
			searchParams[me.queryParam] = null;
		} else {
			searchParams[me.queryParam] = me.rawValue;
			if(!Ext.isEmpty(me.myQueryParam)){
				searchParams[param] = null;
			}
		}
		/*var activeParam = prefix + 'active';
		var act = Ext.isEmpty(me.active) ? me.myActive : me.active;
		searchParams[activeParam] = act;*/
		Ext.apply(store.proxy.extraParams, searchParams);
	},
	triggers:{
		clear : {
				cls : 'x-form-clear-trigger',
				handler : function(){
					this.setRawValue(null);
					this.setValue(null);
					this.realValue = null;
					this.getTrigger('clear').hide();
				},
				hidden : true
		}
	},
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.active = config.active; 
		me.store.addListener('select', function(comb, records, obs) {
			var record = records[0];
			me.record = record;
			me.realValue = record[me.valueField];
		});
		me.callParent([cfg]);
		/*me.on('blur',me.getBlur,me); 
		me.on('select',me.getSelect,me); 
		me.on('change',me.getChange,me);
		me.on('keyup',me.getKeyup,me);*/
	},
	getRecord : function() {
		var me = this;
		return me.record;
	}
});




/**
 * #########################################
 * #######      数据字典下拉框开始          #######
 * #########################################
 */
//数据字典下拉单选框
Ext.define('Caiwei.commonSelector.DataDictionaryCommonSelector', {
	extend : 'Ext.form.field.ComboBox',
	alias: 'widget.dataDictionarySelector',
    displayField: 'valueName',
    valueField: 'valueCode',
    queryMode : 'local',
    editable : false,
    setTermsCode:function(termsCode){
    	var store = getDataDictionary().getDataDictionaryStore(termsCode);
		if(!Ext.isEmpty(store)&&!Ext.isEmpty(this.anyRecords)){
			store.insert(0,this.anyRecords);
		}
    	this.setStore(store);
    },
    
    constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		var store = getDataDictionary().getDataDictionaryStore(config.termsCode);
		if(!Ext.isEmpty(store)&&!Ext.isEmpty(config.anyRecords)){
			//store.add(config.anyRecords);
			store.insert(0,config.anyRecords);//新增的数据在第一个位置(“全部”)
		}
		me.store = store;
		me.callParent([cfg]);
	}
});
/**
 * #########################################
 * #######      数据字典下拉框结束          #######
 * #########################################
 */

/**
 * #########################################
 * #######      是否下拉框开始          #######
 * #########################################
 */
Ext.define('Caiwei.model.baseinfo.YesNoModel',{
	extend : 'Ext.data.Model',
	fields : [{
		name : 'name',
		type : 'string'
	},{
		name : 'value',
		type : 'string'
	}]
});

Ext.define('Caiwei.commonSelector.YesNoAllStore', {
	extend : 'Ext.data.Store',
	model: 'Caiwei.model.baseinfo.YesNoModel',
    data : [{'name':'全部','value':''},{'name':'是','value':'Y'},{'name':'否','value':'N'}]
});

Ext.define('Caiwei.commonSelector.YesNoStore', {
	extend : 'Ext.data.Store',
	model: 'Butterfly.model.baseinfo.YesNoModel',
    data : [{'name':'是','value':'Y'},{'name':'否','value':'N'}]
});

Ext.define('Caiwei.commonSelector.YesOrNoSelector', {
	extend : 'Ext.form.ComboBox',
	alias : 'widget.yesnocombselector',
	listWidth : this.width,// 下拉列表宽度，从外面传入
	multiSelect : false,// 从外面传入
	displayField : 'name',// 显示名称
	valueField : 'value',// 值
	isShowAll : false,// 是否显示全部
	constructor : function(config) {
		var me = this, 
		cfg = Ext.apply({}, config); 
		if (config.isShowAll){
			me.store = Ext.create('Caiwei.commonSelector.YesNoAllStore');
		}else{
			me.store = Ext.create('Caiwei.commonSelector.YesNoStore');
		}
		me.callParent([cfg]);
	}
});
//是和否checkBox
Ext.define('Caiwei.commonCheckBox.YesOrNoCheckBox', {
	extend : 'Ext.form.field.Checkbox',
	alias : 'widget.yesnocheckbox',
	inputValue: 'Y',         //选中的值
    uncheckedValue: 'N',
    getValue : function(){
    	if(this.checked){
    		return 'Y';
    	}else{
    		return 'N';
    	}
    }
});
/**
 * #########################################
 * #######      是否下拉框结束          #######
 * #########################################
 */
/**
 * #########################################
 * #######      组织相关下拉框开始          #######
 * #########################################
 */
/**
 * 用户model
 */
Ext.define('Caiwei.baseinfo.commonSelector.UserModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'id'
			}, {
				name : 'userCode'
				//用户名
			}, {
				name : 'empCode'
				//员工工号
			}, {
				name : 'empName'
				//员工姓名
			}, {
				name : 'passWord'
				//密码
			}, {
				name : 'deptCode'
				//称谓
			}, {
				name : 'lastLogin'
				//登录时间
			}, {
				name : 'notes'
				//备注
			}]
});
//用户下拉框store
Ext.define('Caiwei.commonUserSelector.UserCombStore', {
	extend : 'Ext.data.Store',
	model : 'Caiwei.baseinfo.commonSelector.UserModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '/console/user/searchUserByParam',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			rootProperty : 'userDOS',
			totalProperty : 'totalCount'
		}
	}
});
//用户单选
Ext.define('Caiwei.commonUserSelector.DynamicUserSelector', {
	extend : 'Caiwei.commonSelector.CommonCombSelector',
	alias : 'widget.dynamicusercombselector',
	displayField : 'empName',// 显示名称
	valueField : 'userCode',// 值
	isEnable : null,//当前是否可用（Y，N--根据启用时间，失效时间判定）
	active : null,
	queryParam : 'userDO',// 查询参数
	showContent : '{empName}&nbsp;&nbsp;&nbsp;{title}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Caiwei.commonUserSelector.UserCombStore');
		
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}

			if (!Ext.isEmpty(config.isEnable)) {
				searchParams['userDO.active'] = config.isEnable;
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['userDO.active'] = config.active;
			}else{
				searchParams['userDO.active'] = 'Y';
			}
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});

/**
 * 员工model
 * 
 */
Ext.define('Caiwei.baseinfo.commonSelector.EmployeModel',{
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
Ext.define('Caiwei.commonEmployeSelector.EmployeCombStore',{
	extend : 'Ext.data.Store',
	model : 'Caiwei.baseinfo.commonSelector.EmployeModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '/console/user/searchEmployeeByParam',
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
Ext.define('Butterfly.commonEmpSelector.EmployeeCommonSelector',{
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.dynamicemployeecombselector',
	displayField : 'employeeName',// 显示名称
	valueField : 'employeeCode',// 值
	active : null,
	queryParam : 'commonEmployeeVo.employeeSearchConditionEntity.queryParam',// 查询参数
	showContent : '{employeeName}&nbsp;&nbsp;&nbsp;{jobName}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Butterfly.commonEmployeSelector.EmployeCombStore');
		
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['commonEmployeeVo.employeeSearchConditionEntity.active'] = config.active;
			}else{
				searchParams['commonEmployeeVo.employeeSearchConditionEntity.active'] = 'Y';
			}
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});


/**
 * 组织model
 */
Ext.define('Butterfly.baseinfo.commonSelector.OrgModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'id'
			}, {
				name : 'code'
			}, {
				name : 'logistCode'
			}, {
				name : 'name'
			}, {
				name : 'cityCode'
			}, {
				name : 'countyCode'
			}, {
				name : 'provinceCode'
			}, {
				name : 'active'
			}, {
				name : 'isDivision'
			}, {
				name : 'isBigRegion'
			}, {
				name : 'isRoadArea'
			}, {
				name : 'isSalesDepartment'
			}, {
				name : 'isTransferCenter'
			}, {
				name : 'isFleet'
			},{
				name : 'isPlatform'
			}]
});
//组织下拉框store
Ext.define('Butterfly.commonOrgSelector.OrgCombStore', {
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.OrgModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/commonOrgSearchAction!seacrhOrgByParam.action',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			rootProperty : 'commonOrgVo.commonOrgEntityList',
			totalProperty : 'totalCount'
		}
	}
});
//组织单选
Ext.define('Butterfly.commonOrgSelector.DynamicOrgSelector', {
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.dynamicorgcombselector',
	displayField : 'name',// 显示名称
	valueField : 'code',// 值
	type : 'ORG',// 部门类型 一种部门类型，传递此值
	types : null,// 部门类型 多种部门类型传递次值 两个类型的值之间用","隔开
	isDivision : null,// 查询事业部 配置此值
	isBigRegion : null,// 查询大区 配置此值
	isRoadArea : null,// 查询路区 配置此值
	isSalesDepartment : null,// 查询门店 配置此值
	isTransferCenter : null,// 查询场站 配置此值
	isFleet : null,// 查询车队 配置此值
	isPlatform : null,// 查询平台 配置此值
	logistCode : null,//物流代码	
	arrive:null,//是否可到达
	depart:null,//是否可出发
	queryParam : 'commonOrgVo.orgSearchConditionEntity.queryParam',// 查询参数
	showContent : '{name}&nbsp;&nbsp;&nbsp;{logistCode}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Butterfly.commonOrgSelector.OrgCombStore');
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			// 传递的部门类型是多种
			var types = null;
			if (!Ext.isEmpty(config.types)) {
				types = config.types.split(',');
				searchParams['commonOrgVo.orgSearchConditionEntity.types'] = types;
			}
			if (!Ext.isEmpty(config.type)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.type'] = config.type;
			}else{
				searchParams['commonOrgVo.orgSearchConditionEntity.type'] = me.type;
			}
			if (!Ext.isEmpty(config.isDivision)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.isDivision'] = config.isDivision;
			}
			if (!Ext.isEmpty(config.isBigRegion)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.isBigRegion'] = config.isBigRegion;
			}
			if (!Ext.isEmpty(config.isLoadArea)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.isRoadArea'] = config.isRoadArea;
			}
			if (!Ext.isEmpty(config.isSalesDepartment)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.isSalesDepartment'] = config.isSalesDepartment;
			}
			if (!Ext.isEmpty(config.isTransferCenter)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.isTransferCenter'] = config.isTransferCenter;
			}
			if (!Ext.isEmpty(config.isFleet)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.isFleet'] = config.isFleet;
			}
			if (!Ext.isEmpty(config.isPlatform)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.isPlatform'] = config.isPlatform;
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['commonOrgVo.orgSearchConditionEntity.active'] = config.active;
			}else{
				searchParams['commonOrgVo.orgSearchConditionEntity.active'] = 'Y';
			}
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});
/**
 * #########################################
 * #######      组织相关下拉框结束         #######
 * #########################################
 */
/**
 * #########################################
 * #######      省市区相关下拉框开始        #######
 * #########################################
 */
//行政区域Model
Ext.define('Butterfly.baseinfo.commonSelector.DistrictModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'districtCode',
				type : 'string'
			}, {
				name : 'districtName',
				type : 'string'
			}, {
				name : 'districtType',
				type : 'string'
			}, {
				name : 'parentDistrictName',
				type : 'string'
			},{
				name : 'parentDistrictCode',
				type : 'string'
			}]
});
//行政区域store
Ext.define('Butterfly.baseinfo.commonSelector.DistrictStore', {
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.DistrictModel',
	pageSize : 50,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/districtAction!queryDistrictByName.action',
		actionMethods : 'POST',// 否则可能会出现中文乱码
		reader : {
			type : 'json',
			rootProperty : 'districtVo.districtList',
			totalProperty : 'totalCount'
		}
	}
});
/**
 * 国家store
 */
Ext.define('Butterfly.baseinfo.commonSelector.NationStore', {
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.DistrictModel',
	pageSize : 50,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/districtAction!queryAllNation.action',
		actionMethods : 'POST',// 否则可能会出现中文乱码
		reader : {
			type : 'json',
			rootProperty : 'districtVo.districtList',
			totalProperty : 'totalCount'
		}
	}
});
/**
 * 省份store
 */
Ext.define('Butterfly.baseinfo.commonSelector.ProvinceStore', {
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.DistrictModel',
	pageSize : 50,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/districtAction!queryProvince.action',
		actionMethods : 'POST',// 否则可能会出现中文乱码
		reader : {
			type : 'json',
			rootProperty : 'districtVo.districtList',
			totalProperty : 'totalCount'
		}
	}
});

/**
 * 城市store
 */
Ext.define('Butterfly.baseinfo.commonSelector.CityStore', {
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.DistrictModel',
	pageSize : 50,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/districtAction!queryCity.action',
		actionMethods : 'POST',// 否则可能会出现中文乱码
		reader : {
			type : 'json',
			rootProperty : 'districtVo.districtList',
			totalProperty : 'totalCount'
		}
	}
});

/**
 * 区县store
 */
Ext.define('Butterfly.baseinfo.commonSelector.AreaStore', {
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.DistrictModel',
	pageSize : 50,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/districtAction!queryArea.action',
		actionMethods : 'POST',// 否则可能会出现中文乱码
		reader : {
			type : 'json',
			rootProperty : 'districtVo.districtList',
			totalProperty : 'totalCount'
		}
	}
});
/**
 * 省市区单个下拉框
 */
Ext.define('Butterfly.commonSelector.DistrictSelector', {
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.commondistrictselector',
	eventType : ['callparent'],// 一般callparent包含focus事件，如果有callparent,则focus事件可不用传递
	displayField : 'districtName',// 显示名称
	valueField : 'districtCode',
	queryParam : 'districtVo.district.districtName',// 查询参数
	districtType: null,//省市县类别
	showContent : '{districtName}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.store = Ext.create('Butterfly.baseinfo.commonSelector.DistrictStore');
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			if(!Ext.isEmpty(config.districtType)){
				searchParams['districtVo.district.districtType'] = config.districtType;
			} 
			Ext.apply(store.proxy.extraParams, searchParams);
		});
		me.callParent([cfg]);
	}
});

//联动container	
Ext.define('Butterfly.commonselector.LinkageContainer',{
	extend: 'Ext.form.FieldContainer',
	alias: 'widget.linkagecontainer',
	defaultType: 'linkagecomboselector',
	getItemValue: function(itemId){
		var me = this,
			item = me.items.get(itemId);
		if(item!=null){
			return item.getValue();
		}
		return null;
	},
	getValue: function(){
		var me = this,
			values = new Array();
		for(var i=0;i<me.items.length;i++){
			values[i] = me.getItemValue(me.items.items[i].itemId);
		}
		return values;
	}
});

/**
 * 联动查询组件
 */
Ext.define('Butterfly.commonselector.LinkageComboSelector',{
	extend: 'Hoau.commonselector.DynamicComboSelector',
	alias: 'widget.linkagecomboselector',
	minChars : 0,
	isPaging : false,// 分页
	isEnterQuery : true,// 回车查询
	parentParamsAndItemIds: null,//级联父组件参数
	realValue : null,
	listeners:{
        //失去焦点时校验是否做出选择，未做出选择清空下拉框
		blur:function(comb, the, eOpts){
			if (Ext.isEmpty(comb.realValue)) {
				comb.setRawValue(null);
				comb.setValue(null);
			}else{
				var display = comb.record.data[comb.displayField];
				if(!Ext.Object.equals(display,comb.getRawValue())){
					comb.setRawValue(null);
					comb.setValue(null);
					comb.realValue = null;
				}
			}
		},
		select:function(comb, records, obs){
			comb.record = records;
			var data = records.data;
			comb.realValue = data[comb.valueField];
			//显示情况控件
			comb.getTrigger('clear').show();
		},
		keyup : function(combo, event, eOpts){
			//下拉框输入值
			var value = combo.getRawValue();
			//情况控件
			var clearTrigger = combo.getTrigger('clear');
	        if(!Ext.isEmpty(value)){
	        	//输入不为空显示情况控件
	        	clearTrigger.show();
	        }else{
	        	//隐藏情况控件
	        	clearTrigger.hide();
	        }
	        //关闭下拉框
	        //combo.collapse();
			if(combo.isEnterQuery == true && event.getKey() == event.ENTER){
				var rawValue = combo.getRawValue();
				combo.store.loadPage(1,{
					scope: this,
					callback: function(records, operation, success) {
						if(records.length>0){
							//展开下拉框
							combo.expand();
						}
						combo.setRawValue(rawValue);
					}
				});
			}
		}
	},
	/*eventType: ['callparent'],//事件(传入)
	getFocus: function(){
		var me = this;
		me.on('focus',function(){
			me.setValue(null);
			me.store.loadPage(1,{
				scope: this,
				callback: function(records, operation, success) {
					if(records.length>0){
						me.expand();
					}
				}
			});
		});
	},*/
	/*getCallParent: function(){
		var me = this,
			cmp;
		if(!Ext.isEmpty(me.parentParamsAndItemIds)){
			Ext.Object.each(me.parentParamsAndItemIds, function(queryParam, itemId, parentParamsAndItemIds) {
				cmp = me.up().items.get(itemId);
				if(!cmp.hasListener('select')){
					cmp.on('select',function(combo){
						me.setValue(null);
						me.store.loadPage(1,{
							scope: this,
							callback: function(records, operation, success) {
								me.focus(false, 100);
								me.expand();
							}
						});
					});
				}
			});
		}
	},*/
	triggers:{
		clear : {
				cls : 'x-form-clear-trigger',
				handler : function(){
					this.setRawValue(null);
					this.setValue(null);
					this.realValue = null;
					this.getTrigger('clear').hide();
				},
				hidden : true
		}
	},
	initComponent:function(){
		var me = this;
		/*me.on('boxready',function(){
			var callparent = null;
			for(var i = 0;i<me.eventType.length;i++){
				if(me.eventType[i]=='focus'){
					me.getFocus();
				}else if(me.eventType[i]=='callparent'){
					callparent = 'callparent';
					me.getCallParent();
				}
			}
			//调用父类方法会自动包含focus事件
			if(callparent=='callparent'){
				me.un('focus');
			}
		});*/
		this.callParent(arguments);
		//增加级联查询条件
		me.store.on('beforeLoad', function(st,operation,e){
			var cmp=null, searchParams=operation.getParams();
			if(Ext.isEmpty(searchParams)){
				searchParams={};
			}
			searchParams[me.queryParam] = me.rawValue;
			if(!Ext.isEmpty(me.parentParamsAndItemIds)){
				Ext.Object.each(me.parentParamsAndItemIds, function(queryParam, itemId, parentParamsAndItemIds) {
					cmp = me.up().items.get(itemId);
					searchParams[queryParam] = cmp.getValue();
				});
			}
			Ext.apply(st.proxy.extraParams, searchParams);
		});
	}
});	

Ext.define('Butterfly.commonSelector.linkReginCombSelector', {
	extend : 'Butterfly.commonselector.LinkageContainer',
	alias : 'widget.linkregincombselector',
//	fieldLabel : '联动选择',
	type : 'N-P-C-C',// type ：N-P-C-C 国省市县 P-C-C :省市县 C-C:市县 P-C:省市
	width : 600,
	nationWidth : 150,// 国家长度
	nationLabel : '',// 国家label
	nationName : '',// 国家名称--对应name
	nationIsBlank : true,
	nationLabelWidth:null,
	provinceWidth : 150,// 省份长度
	provinceLabel : '',// 省份label
	provinceLabelWidth:null,
	provinceName : '',// 省份名称—对应name
	provinceIsBlank : true,
	cityWidth : 150,// 城市长度
	cityLabel : '',// 城市label
	cityName : '',// 城市name
	cityIsBlank : true,
	cityLabelWidth:null,
	areaWidth : 150,// 县长度
	areaLabel : '',// 县label
	areaName : '',// 县name
	areaIsBlank : true,
	areaLabelWidth:null,
	layout : 'column',
	labelWid : 20,
	readOnly : false,
	setReadOnly : function(flag){
		var me =this;
		me.getNation().setReadOnly(flag);
		me.getProvince().setReadOnly(flag);
		me.getCity().setReadOnly(flag);
		me.getCounty().setReadOnly(flag);
	},
	getDefults : function(config) {
		return {
			labelWidth : config.labelWid,
			minChars : 0,
			labelSeparator : ''
		}
	},
	setReginValue : function(displayText, valueText, order) {// 0：国家的值，1：省的值，2：市的值，3：县的值
		var me = this;
		var regionObj=null;
		if(!Ext.isEmpty(order)){
			if(order == '0'){
				regionObj=me.nation;
			}else if(order == '1'){
				regionObj=me.province;
			}else if(order == '2'){
				regionObj=me.city;
			}else if(order == '3'){
				regionObj=me.county;
			}
		}
		var  key = regionObj.displayField + '', value =regionObj.valueField
				+ '';
		var m = Ext.create(regionObj.store.getModel().getName());
		m.set(key, displayText);
		m.set(value, valueText);
		regionObj.store.loadRecords([m]);
		regionObj.setValue(valueText);
	},
	nation:null,
	getNation:function(nationWidth,nationLabel,nationName,nationIsBlank,nationLabelWidth,configType,provinceObj){
		if(Ext.isEmpty(this.nation)){
			this.nation=Ext.widget('linkagecomboselector',{
				configType :configType,
				provinceObj : provinceObj,
				/*editable:false,*/
				eventType : ['focus'],// 一般callparent包含focus事件，如果有callparent,则focus事件可不用传递
				name : 'province',
				itemId : 'Butterfly_baseinfo_Nation_ID',
				store : Ext.create('Butterfly.baseinfo.commonSelector.NationStore'),// 从外面传入
				listeners : {
					'change' : function(ths, the, eOpts){
						if(ths.configType == 'N-P-C-C'){
							ths.provinceObj.setReadOnly(false);
							var provObj=ths.provinceObj.getEl();
							if(!Ext.isEmpty(provObj)){
								provObj.query('input')[0].readOnly = 'readOnly';	
							}
						} 
					}
				},
				displayField : 'districtName',// 显示名称
				valueField : 'districtCode',
				width : nationWidth,
				fieldLabel : nationLabel,
				name : nationName,
				labelWidth:nationLabelWidth,
				allowBlank : nationIsBlank,
				queryParam : 'districtVo.district.queryParam'
			});
		}
		return this.nation;
	},
	province:null,
	getProvince:function(provinceWidth,provinceLabel,provinceName,provinceIsBlank,provinceLabelWidth,configType,cityObj){
		if(Ext.isEmpty(this.province)){
			this.province=Ext.widget('linkagecomboselector',{
				configType:configType,
				cityObj : cityObj,
				/*editable:false,*/
				itemId : 'Butterfly_baseinfo_Province_ID',
				eventType : ['callparent'],
				store : Ext.create('Butterfly.baseinfo.commonSelector.ProvinceStore'),// 从外面传入
				listeners : {
					'change' : function(ths, the, eOpts){
						ths.cityObj.disable();
						ths.cityObj.setValue(null);
						ths.cityObj.realValue = null;
						/*var cityObj=ths.cityObj.getEl();*/
						/*if(!Ext.isEmpty(cityObj)){
							cityObj.query('input')[0].readOnly = 'readOnly';	
						}*/
					},
					'select' : function(ths, the, eOpts){
						ths.cityObj.enable();
						ths.cityObj.getStore().load();
					}
				},
				displayField : 'districtName',// 显示名称
				valueField : 'districtCode',
				minChars : 0,
				width : provinceWidth,
				fieldLabel : provinceLabel,
				name : provinceName,
				labelWidth:provinceLabelWidth,
				allowBlank : provinceIsBlank,
				isPaging: false, 
				parentParamsAndItemIds : {
					'districtVo.district.parentDistrictCode' : 'Butterfly_baseinfo_Nation_ID'
				},// 此处城市不需要传入
				queryParam : 'districtVo.district.queryParam'
			
			});
		}
		return this.province;
	},
	city:null,
	getCity:function(cityWidth,cityLabel,cityName,cityIsBlank,cityLabelWidth,configType,countyObj){
		if(Ext.isEmpty(this.city)){
				this.city=Ext.widget('linkagecomboselector',{
					configType:configType,
					countyObj : countyObj,
					/*editable:false,*/
					itemId : 'Butterfly_baseinfo_City_ID',
					eventType : ['callparent'],// 一般callparent包含focus事件，如果有callparent,则focus事件可不用传递
					store : Ext.create('Butterfly.baseinfo.commonSelector.CityStore'),// 从外面传入
					listeners : {
						'change' : function(ths, the, eOpts){
							ths.countyObj.disable();
							ths.countyObj.setValue(null);
							ths.countyObj.realValue = null;
							/*ths.countyObj.setReadOnly(false);
							var countyObj=ths.countyObj.getEl();
							if(!Ext.isEmpty(countyObj)){
								countyObj.query('input')[0].readOnly = 'readOnly';	
							}*/
						},
						'select' : function(ths, the, eOpts){
							ths.countyObj.enable();
							ths.countyObj.getStore().load();
						}
					},
					displayField : 'districtName',// 显示名称
					valueField : 'districtCode',
					minChars : 0,
					width : cityWidth,
					fieldLabel : cityLabel,
					name : cityName,
					labelWidth:cityLabelWidth,
					allowBlank : cityIsBlank,
					isPaging: false,  
					parentParamsAndItemIds : {
						'districtVo.district.parentDistrictCode' : 'Butterfly_baseinfo_Province_ID'
					},// 此处城市不需要传入
					queryParam : 'districtVo.district.queryParam'
			});
		}
		return this.city;
	},
	county:null,
	getCounty:function(areaWidth,areaLabel,areaNames,areaIsBlank,areaLabelWidth){
		if(Ext.isEmpty(this.county)){
			this.county=Ext.widget('linkagecomboselector',{
				store : Ext.create('Butterfly.baseinfo.commonSelector.AreaStore'),// 从外面传入
				displayField : 'districtName',// 显示名称
				valueField : 'districtCode',
				minChars : 0,
				/*editable:false,*/
				width : areaWidth,
				fieldLabel : areaLabel,
				name : areaNames,
				allowBlank : areaIsBlank,
				labelWidth:areaLabelWidth,
				isPaging: false, 
				parentParamsAndItemIds : {
					'districtVo.district.parentDistrictCode' : 'Butterfly_baseinfo_City_ID'
				},// 此处区域不需要传入
				queryParam : 'districtVo.district.queryParam'
				});
			}
		return  this.county;
	},
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.defaults = me.getDefults(config);
		var county = me.getCounty(config.areaWidth,config.areaLabel,config.areaName,config.areaIsBlank,config.areaLabelWidth);
		var city = me.getCity(config.cityWidth,config.cityLabel,config.cityName,config.cityIsBlank,config.cityLabelWidth,config.type,county);
		var province = me.getProvince(config.provinceWidth,config.provinceLabel,config.provinceName,config.provinceIsBlank,config.provinceLabelWidth,config.type,city);
		var nation = me.getNation(config.nationWidth,config.nationLabel,config.nationName,config.nationIsBlank,config.nationLabelWidth,config.type,province);
		me.items=[nation,province,city,county];
		if (config.type == 'N-P-C-C') {
			/*province.setReadOnly(true);   
			city.setReadOnly(true);   
			county.setReadOnly(true);*/  
			/*province.cls='readonlyhaveborder'; 
			city.cls='readonlyhaveborder';
			county.cls='readonlyhaveborder';*/			
			/*me.items=[nation,province,city,county];*/
		} else if (config.type == 'P-C-C') {
			if(config.readOnly){
				/*province.disable();
				city.disable();   
				county.disable();*/
				province.setReadOnly(true);
				city.setReadOnly(true);
				county.setReadOnly(true);
			}else{
				city.disable();   
				county.disable();
			}
			/*city.cls='readonlyhaveborder';
			county.cls='readonlyhaveborder';*/
			province.eventType=['focus'];
			province.parentParamsAndItemIds = null;
			me.items=[province,city,county];
		} else if (config.type == 'P-C') {
			if(config.readOnly){
				/*province.disable();
				city.disable();*/
				province.setReadOnly(true);
				city.setReadOnly(true);
			}else{
				city.disable();
			}
			/*city.cls='readonlyhaveborder';*/
			province.eventType=['focus'];
			province.parentParamsAndItemIds = null;
			me.items=[province,city];
		} else if (config.type == 'C-C') {
			if(config.readOnly){
				/*city.disable();
				county.disable(); */
				city.setReadOnly(true);
				county.setReadOnly(true);
			}else{
				county.disable(true); 
			}
			/*county.cls='readonlyhaveborder';*/
			city.eventType=['focus'];
			city.parentParamsAndItemIds = null;
			me.items=[city,county];
		}
		me.callParent([cfg]);
	}
});
/**
 * #########################################
 * #######      省市区相关下拉框结束        #######
 * #########################################
 */
/**
 * #########################################
 * #######      产品相关下拉框开始         #######
 * #########################################
 */
//产品Model
Ext.define('Butterfly.baseinfo.commonSelector.ProductModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'id'
			}, {
				name : 'code'
			}, {
				name : 'name'
			}, {
				name : 'active'
			}, {
				name : 'notes'
			}, {
				name : 'levels'
			}, {
				name : 'parentCode'
			}, {
				name : 'parentName'
			}, {
				name : 'shortName'
			}]
 });
//产品store
Ext.define('Butterfly.baseinfo.commonSelector.ProductStore', {
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.ProductModel',
	pageSize : 10,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/productAction!queryProductCommonToLevelByCondition.action',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			rootProperty : 'productVo.productEntityList',
			totalProperty : 'totalCount'
		}
	}
});
//产品类型公共选择器信息
Ext.define('Butterfly.commonSelector.CommonProductSelector', {
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.commonproductselector', 
	displayField : 'name',// 显示名称
	valueField : 'code',// 值
	active : 'Y', 
	levelses : '3',//多个产品层级以","分隔
	parentCode : null, //父级产品编号
	queryParam : 'productVo.productEntity.queryParam',// 查询参数
	showContent : '{name}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.store = Ext.create('Butterfly.baseinfo.commonSelector.ProductStore'); 
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			var levelses = null; 
			if (!Ext.isEmpty(config.levelses)) {
				levelses = config.levelses.split(',');
				searchParams['productVo.productEntity.levelsList'] = levelses;
			}else{
				levelses = me.levelses.split(',');
				searchParams['productVo.productEntity.levelsList'] =levelses;
			}
			if (!Ext.isEmpty(config.parentCode)) {
				searchParams['productVo.productEntity.parentCode'] = config.parentCode;
			}
			searchParams['productVo.productEntity.active'] = me.active; 	
			Ext.apply(store.proxy.extraParams, searchParams);
		});
		me.callParent([cfg]);
	}
});
/**
 * #########################################
 * #######      产品相关下拉框结束         #######
 * #########################################
 */
/**
 * #########################################
 * #######      车辆相关下拉框开始        #######
 * #########################################
 */
//自备车model
Ext.define('Butterfly.baseinfo.commonSelector.OwnTruckModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'id'
			}, {
				name : 'vehicleNo'    //车牌号(唯一)
			}/*, {
				name : 'orgCode'      //部门编码
			}, {
				name : 'orgName'      //部门名称
			}*/, {
				name : 'status'       //车辆状态
			}, {
				name : 'brand'       //车辆品牌
			}, {
				name : 'usedType'       //车辆用途
			}, {
				name : 'vehicleLength'       //车长
			}, {
				name : 'vehicleWidth'       //车宽
			}, {
				name : 'vehicleHeight'       //车高
			}, {
				name : 'ratedLoad'       //额定载重
			}, {
				name : 'gps'       //是否有GPS
			}, {
				name : 'vehicleType'       //车辆类型
			}/*, {
				name : 'registDate'       //登记日期
			}*/]
 });

//自备车下拉框store
Ext.define('Butterfly.commonOwnTruckSelector.OwnTruckCombStore',{
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.OwnTruckModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/commonOwnTruckSearchAction!seacrhOwnTruckByParam.action',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			rootProperty : 'commonOwnTruckVo.commonOwnTruckList',
			totalProperty : 'totalCount'
		}
	}
});
 
/**
 * 自备车单选
 */
Ext.define('Butterfly.commonOwnTruckSelector.OwnTruckCommonSelector',{
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.owntruckselector',
	displayField : 'vehicleNo',// 显示名称
	valueField : 'vehicleNo',// 值
	active : null,
	queryParam : 'commonOwnTruckVo.ownTruckSearchConditionEntity.queryParam',// 查询参数
	showContent : '{vehicleNo}&nbsp;&nbsp;&nbsp;{brand}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Butterfly.commonOwnTruckSelector.OwnTruckCombStore');
		
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['commonOwnTruckVo.ownTruckSearchConditionEntity.active'] = config.active;
			}else{
				searchParams['commonOwnTruckVo.ownTruckSearchConditionEntity.active'] = 'Y';
			}
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});
/**
 * #########################################
 * #######      车辆相关下拉框结束        #######
 * #########################################
 */

/**
 * #########################################
 * #######      外雇司机信息相关下拉框开始        #######
 * #########################################
 */
//外雇司机信息model
Ext.define('Butterfly.baseinfo.commonSelector.LeasedDriverModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'id'
			}, {
				name : 'driverName'    //司机姓名
			}, {
				name : 'address'       //地址
			}, {
				name : 'driverPhone'       //司机电话
			}, {
				name : 'vehicleNo'       //车牌号
			}, {
				name : 'idCard'       //身份证
			}, {
				name : 'driverLicense'       //驾驶证编号
			}, {
				name : 'qualification'       //从业资格证(号码)
			}, {
				name : 'licenseType'       //驾驶证类型
			}, {
				name : 'beginTime'       //驾照签发日期
			}, {
				name : 'expirationDate'       //有效期限
			}, {
				name : 'active'       //是否可用
			}]
 });

//外雇司机信息下拉框store
Ext.define('Butterfly.commonLeasedDriverSelector.LeasedDriverCombStore',{
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.LeasedDriverModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/commonLeasedDriverSearchAction!seacrhLeasedDriverByParam.action',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			root : 'commonLeasedDriverVo.commonLeasedDriverList',
			totalProperty : 'totalCount'
		}
	}
});
 
/**
 * 外雇司机信息单选
 */
Ext.define('Butterfly.commonLeasedDriverSelector.LeasedDriverCommonSelector',{
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.leaseddriverselector',
	displayField : 'driverName',// 显示名称
	valueField : 'driverName',// 值
	active : null,
	queryParam : 'commonLeasedDriverVo.leasedDriverSearchConditionEntity.queryParam',// 查询参数
	showContent : '{driverName}&nbsp;&nbsp;&nbsp;{licenseType}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Butterfly.commonLeasedDriverSelector.LeasedDriverCombStore');
		
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['commonLeasedDriverVo.leasedDriverSearchConditionEntity.active'] = config.active;
			}else{
				searchParams['commonLeasedDriverVo.leasedDriverSearchConditionEntity.active'] = 'Y';
			}
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});
/**
 * #########################################
 * #######      外雇司机信息下拉框结束        #######
 * #########################################
 */

/**
 * #########################################
 * #######      偏线公司（合作公司）相关下拉框开始        #######
 * #########################################
 */
//偏线公司信息model
Ext.define('Butterfly.baseinfo.commonSelector.BusinessPartnerModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'id'
			}, {
				name : 'agentCompanyCode'    //（合作公司）编码
			}, {
				name : 'agentCompanyName'    //（合作公司）名称
			}, {
				name : 'simpleName'       //简称
			}, {
				name : 'contact'       //联系人
			}, {
				name : 'contactPhone'       //联系电话
			}, {
				name : 'contactMobile'      //联系人手机
			}, {
				name : 'address'       //详细地址
			}, {
				name : 'active'       //是否可用
			}]
 });

//偏线公司信息下拉框store
Ext.define('Butterfly.commonBusinessPartnerSelector.BusinessPartnerCombStore',{
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.BusinessPartnerModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/commonBusinessPartnerSearchAction!seacrhBusinessPartnerByParam.action',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			root : 'commonBusinessPartnerVo.commonBusinessPartnerList',
			totalProperty : 'totalCount'
		}
	}
});
 
/**
 * 偏线公司信息单选
 */
Ext.define('Butterfly.commonBusinessPartnerSelector.BusinessPartnerCommonSelector',{
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.businesspartnerselector',
	displayField : 'agentCompanyName',// 显示名称
	valueField : 'agentCompanyCode',// 值
	active : null,
	queryParam : 'commonBusinessPartnerVo.businessPartnerSearchConditionEntity.queryParam',// 查询参数
	showContent : '{agentCompanyName}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Butterfly.commonBusinessPartnerSelector.BusinessPartnerCombStore');
		
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['commonBusinessPartnerVo.businessPartnerSearchConditionEntity.active'] = config.active;
			}else{
				searchParams['commonBusinessPartnerVo.businessPartnerSearchConditionEntity.active'] = 'Y';
			}
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});
/**
 * #########################################
 * #######       偏线公司（合作公司）信息下拉框结束        #######
 * #########################################
 */
/**
 * #########################################
 * #######      偏线网点相关下拉框开始        #######
 * #########################################
 */
//偏线网点信息model
Ext.define('Butterfly.baseinfo.commonSelector.OuterBranchModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'id'
			}, {
				name : 'agentDeptCode'    //编码
			}, {
				name : 'agentDeptName'    //名称
			}, {
				name : 'simpleName'       //简称
			}, {
				name : 'contact'       //联系人
			}, {
				name : 'contactPhone'       //联系电话
			}, {
				name : 'contactMobile'      //联系人手机
			}, {
				name : 'pinyin'       //拼音
			}, {
				name : 'address'       //详细地址
			}, {
				name : 'active'       //是否可用
			}]
 });

//偏线网点信息下拉框store
Ext.define('Butterfly.commonOuterBranchSelector.OuterBranchCombStore',{
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.OuterBranchModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/commonOuterBranchSearchAction!seacrhOuterBranchByParam.action',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			root : 'commonOuterBranchVo.commonOuterBranchList',
			totalProperty : 'totalCount'
		}
	}
});
 
/**
 * 偏线网点信息单选
 */
Ext.define('Butterfly.commonOuterBranchSelector.OuterBranchCommonSelector',{
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.outerBranchselector',
	displayField : 'agentDeptName',// 显示名称
	valueField : 'agentDeptCode',// 值
	active : null,
	queryParam : 'commonOuterBranchVo.outerBranchSearchConditionEntity.queryParam',// 查询参数
	showContent : '{agentDeptName}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Butterfly.commonOuterBranchSelector.OuterBranchCombStore');
		
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['commonOuterBranchVo.outerBranchSearchConditionEntity.active'] = config.active;
			}else{
				searchParams['commonOuterBranchVo.outerBranchSearchConditionEntity.active'] = 'Y';
			}
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});
/**
 * #########################################
 * #######       偏线网点信息下拉框结束        #######
 * #########################################
 */




/**
 * #########################################
 * #######      价卡城市相关下拉框开始        #######
 * #########################################
 */
/**
 * 价卡城市model
 * 
 */
Ext.define('Butterfly.baseinfo.commonSelector.CardCityModel',{
	extend : 'Ext.data.Model',
	fields : [{
				name : 'id'
			}, {
				name : 'cityNo'
			}, {
				name : 'cityName'
			}, {
				name : 'effective'
			}, {
				name : 'remarks'
			}, {
				name : 'province'
			}, {
				name : 'cityType'
			}]
});

//价卡城市下拉框store
Ext.define('Butterfly.commonCardCitySelector.CardCityCombStore',{
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.CardCityModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/commonCardCitySearchAction!seacrhCardCityByParam.action',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			rootProperty : 'commonCardCityVo.commonCardCityList',
			totalProperty : 'totalCount'
		}
	}
});

/**
 * 价卡城市单选
 */
Ext.define('Butterfly.commonCardCitySelector.CardCityCommonSelector',{
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.dynamiccardcitycombselector',
	displayField : 'cityName',// 显示名称
	valueField : 'cityNo',// 值
	active : null,
	queryParam : 'commonCardCityVo.cardCitySearchConditionEntity.queryParam',// 查询参数
	showContent : '{cityName}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Butterfly.commonCardCitySelector.CardCityCombStore');
		
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['commonCardCityVo.cardCitySearchConditionEntity.active'] = config.active;
			}else{
				searchParams['commonCardCityVo.cardCitySearchConditionEntity.active'] = 'Y';
			}
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});


/**
 * #########################################
 * #######      价卡城市相关下拉框结束       #######
 * #########################################
 */



/**
 * #########################################
 * #######      附件上传按钮开始          #######
 * #########################################
 */
//数据字典下拉单选框
Ext.define('Butterfly.manage.FileUploads', {
	extend : 'Ext.container.Container',
	alias: 'widget.fileUploadsButton',
    displayField: 'valueName',
    valueField: 'valueCode',
    queryMode : 'local',
    editable : false,
    xtype: 'form-fileuploads',
    controller: 'form-fileuploads',
    items: [{
        items: [ {
            xtype: 'filefield',
            hideLabel: true,
            reference: 'basicFile'
        }]
    }]
});
/**
 * #########################################
 * #######      附件上传按钮结束          #######
 * #########################################
 */


/**
 * #########################################
 * #######      财务组织查询相关下拉框开始        #######
 * #########################################
 */
/**
 * 财务组织model
 * 
 */
Ext.define('Butterfly.baseinfo.commonSelector.CommonFinanceOrgModel',{
	extend : 'Ext.data.Model',
	fields : [{
				name : 'companyCode'
			}, {
				name : 'companyName'
			}, {
				name : 'departName'
			}]
});

//财务组织下拉框store
Ext.define('Butterfly.commonCardCitySelector.CommonFinanceOrgStore',{
	extend : 'Ext.data.Store',
	model : 'Butterfly.baseinfo.commonSelector.CommonFinanceOrgModel',
	pageSize : 20,
	proxy : {
		type : 'ajax',
		url : '../baseinfo/commonFinanceOrgAction!queryFinanceOrgByParam.action',
		actionMethods : 'POST',
		reader : {
			type : 'json',
			rootProperty : 'commonFinanceOrgVo.commonFinanceOrgEntityList',
			totalProperty : 'totalCount'
		}
	}
});

/**
 * 财务组织单选
 */
Ext.define('Butterfly.commonFinanceOrgSelector.commonFinanceOrgSelector',{
	extend : 'Butterfly.commonSelector.CommonCombSelector',
	alias : 'widget.dynamicommonFinanceOrgselector',
	displayField : 'companyName',// 显示名称
	valueField : 'companyCode',// 值
	orgCode : null,//管理部门code
	active : null,
	queryParam : 'commonFinanceOrgVo.commonFinanceOrgEntity.queryParam',// 查询参数
	showContent : '{companyName}',// 显示表格列
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);    
		me.store = Ext.create('Butterfly.commonCardCitySelector.CommonFinanceOrgStore');
		
		me.store.addListener('beforeload', function(store, operation, eOpts) {
			var searchParams = operation.getParams();
			if (Ext.isEmpty(searchParams)) {
				searchParams = {};
			}
			if (!Ext.isEmpty(config.orgCode)) {
				searchParams['commonFinanceOrgVo.commonFinanceOrgEntity.companyCode'] = config.orgCode;
			}
			if (!Ext.isEmpty(config.active)) {
				searchParams['commonFinanceOrgVo.commonFinanceOrgEntity.active'] = 'Y';
			}
			searchParams['commonFinanceOrgVo.commonFinanceOrgEntity.active'] = 10;
			Ext.apply(store.proxy.extraParams, searchParams);  
		})
		me.callParent([cfg]);
	}
});


/**
 * #########################################
 * #######     财务组织查询相关下拉框结束       #######
 * #########################################
 */



