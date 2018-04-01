Ext.define('Caiwei.model.login.UserVO', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'userCode',
		type : 'string'
	}, {
		name : 'passWord',
		type : 'string'
	} ]
});

/**
 * 登录表单
 */
Ext.define('Caiwei.view.login.LoginForm', {
	extend : 'Ext.form.Panel',
	frame : true,
	width : 410,
	id : 'loginFormId',
	defaultType : 'textfield',
	cls : 'ui_login_form',
	fieldDefaults: {
        margin: '0 0 20 0'
    },
	items : [{
		id : 'usernameId',
		allowBlank : false,
		name : 'userCode',
		cls : 'ui_login_input_user',
		fieldCls : 'ui_login_input_size',
		emptyText : '请输入您的用户名'
	},{
		allowBlank : false,
		name : 'passWord',
		cls : 'ui_login_input_lock',
		fieldCls : 'ui_login_input_size',
		emptyText : '请输入您的密码',
		inputType : 'password'
	}],
	initComponent : function() {
		this.defaults = {
			anchor : '100%',
			labelWidth : 60
		};
		this.callParent();
	}
});

function login(){
	var userVO = {
		userCode: Ext.getDom('userCode').value,
		passWord: Ext.getDom('passWord').value
	}
	var successFun = function(json) {
		window.location.href = "";
	};
	var failureFun = function(json) {
		if (Ext.isEmpty(json)) {
			document.getElementById("msg").innerText = "连接超时!";
		} else {
			var message = json.resMsg;
			//Caiwei.showErrorMes(message); // 提示失败原因
			document.getElementById("msg").innerText = message+"!";
		}
	};
	console.requestJsonAjax('login', userVO, successFun, failureFun); // 发送AJAX请求
}

Ext.onReady(function() {
	Ext.QuickTips.init();
	// var loginForm = Ext.create('Caiwei.view.login.LoginForm');
	// Ext.create('Ext.panel.Panel', {
	// 	renderTo : 'login_form_div',
	// 	items : [ loginForm ]
	// });
	Ext.getDom('userCode').focus(false,100)
});