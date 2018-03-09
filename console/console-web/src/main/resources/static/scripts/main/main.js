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
		var params = {}
        var successFun = function(response) {
            var resp = response.result;
            if(response.success){
                //设置当前登录用户信息
                login.currentUser = resp.currentUser;
                //设置当前服务器时间
                login.currentServerTime = new Date(resp.currentServerTime+1000);
                //设置当前部门信息
                login.currentDept = resp.currentDept;
            }else{
                Caiwei.showErrorMes(resp.resMsg);
            }
        };
        var failureFun = function(response){
            Caiwei.showErrorMes(response.resMsg);
        }
        Caiwei.requestJsonAjax('currentUserInfo', params, successFun, failureFun);
	};
	login.queryCurrentInfo();


	//系统业务字典
	login.clientVersionNo = 0;
	login.dataDictionary = new Ext.util.HashMap();
	login.queryDictionaryInfo = function(isAsync) {
		//Ajax请求业务字典信息
		Ext.Ajax.request({
			url:'searchAllDataDictionary',
			method: 'POST',
			async: isAsync || false,
			success: function(response) {
				var result = Ext.decode(response.responseText).result;
				var	dataDictionary = result.termsCodeDOS;
				login.clientVersionNo = result.clientVersionNo;
				for(var i=0;i<dataDictionary.length;i++){
					login.dataDictionary.add(dataDictionary[i].termsCode,dataDictionary[i].termsValueDOS);
				}
			}
		});
	};
	login.isDictionaryHasChanged = function() {
		//判断数据字典内容是否有更新
		Ext.Ajax.request({
			url: 'hasDictionaryChanged',
			method: 'POST',
			params: {
				clientVersionNo: login.clientVersionNo
			},
			success: function(response) {
				var result = Ext.decode(response.responseText);
				var changeFlag = result.result;
				if(changeFlag != "keep") {
					login.clientVersionNo = result.clientVersionNo;
					login.queryDictionaryInfo(true);
				}
			}
		});
	};
	login.queryDictionaryInfo();
	setInterval(function() {
		login.queryCurrentInfo();
		login.isDictionaryHasChanged();
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
			return login.currentUser.employeeDO;
		}
		return null; 			
	},
	//获得当前用户部门信息
	getCurrentUserDept: function(){
		return login.currentDept;
	},
	//获得当前用户所拥有角色的编码集合
	getCurrentUserRoleCodes: function(){
		if(login.currentUser){
			return login.currentUser.roleCodes;
		}
		return null;
	}
});
/**********************************************************************/
/**********************************************************************
 * 业务字典提供方法
 */
//业务字典信息类
Ext.define('DataDictionary', {
	singleton: true,
	/*
	 * 通过词条代码获得业务字典数据
	 * @param termsCode 词条代码
	 * @param valueCodes 条目编码数组
	 * @returns 业务字典数据
	 */
	getDataByTermsCode: function(termsCode, valueCodes){
		if(login.dataDictionary != null && termsCode != null){
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
	/*
	 * 通过多个词条代码获得业务字典数据数组
	 * @param termsCodes 词条代码数组
	 * @returns 业务字典数据数组
	 */
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
	/*
	 * 根据数据字典名称获取对应的store,如果没有则返回[],不影响整个页面的渲染
	 * @param termsCode 词条代码
	 * @param id 如果想要通过store id 查询store的话就传id,否则可以不用传
	 * @param anyRecords 如果想增加一些记录到这个数据字典中，可以通过这个参数传入，
	 * 					 些参数可以是一个数据数组，也可以是一个数据
	 * @param valueCodes 条目编码数组
	 * @returns
	 */

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
	/*
	 * 根据数据字典名称获取对应的combo组件
	 * @param termsCode 词条代码
	 * @param config combo的一些配置信息
	 * @param anyRecords 如果想增加一些记录到这个数据字典中，可以通过这个参数传入，
	 * 					 些参数可以是一个数据数组，也可以是一个数据
	 * @param id 如果想要通过store id 查询store的话就传id,否则可以不用传
	 * @returns
	 */
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
	/*
	 *将业务字典的displayValue（数据字典显示值）转换成描述submitValue（提交值）
	 * 使用方法rendererDictionary(displayValue,’abc’);
	 * @param value  所要转换的值
	 * @param termsCode 词条代码
	 */
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
	/*
	 *将业务字典的submitValue（提交值）转换成描述displayValue（数据字典显示值）
	 * 使用方法rendererDictionary(value,’abc’);
	 * @param value  所要转换的值
	 * @param termsCode 词条代码
	 */
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
});
/**********************************************************************/

