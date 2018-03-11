/**
 * Extjs编码规范：
 * 1.普通组件命名规范：Butterfly.'模块'.'功能菜单'.'**Form|Window|Grid|Store'
 * 	 (例如：Butterfly.baseinfo.goodsArea.queryForm)
 * 2.id命名规范:butterfly_'模块'_'功能'_'组件'_id
 * 	 (例如:butterfly_baseinfo_goodsArea_queryForm_id)
 * 3.公共选择器命名规范:Butterfly.common*.**|Selector|CheckBox
 *   (例如:Butterfly.commonSelector.DataDictionaryCommonSelector,Butterfly.commonCheckBox.YesOrNoCheckBox)
 * 4.常用工具类：在wing-common中的scripts中的butterfly-util.js
 * 5.数据字典使用:
 * 	 获取store:getDataDictionary().getDataDictionaryStore("GENDER")
 * 	 下拉框使用:
 * 	  var all = [{
 *			'valueName' : '全部',       //'全部'
 *			'valueCode' : ''
 *        }];
 * 	  {
 *        	name : 'status', 
 *        	fieldLabel : '车辆状态',        //'车辆状态'
 *    		width : 250,
 *    		value : '',
 *    		xtype : 'dataDictionarySelector',
 *   		termsCode : "termscode",
 *   		anyRecords : all
 *       }
 *    表格code转换value:
 *    renderer : function (value) {
 *    	butterfly.changeCodeToNameStore(getDataDictionary().getDataDictionaryStore("termscode"), value);
 * 	  }
 * 6.获取当前登录用户及部门信息:getUserContext();
 * 
 */

/**
 * 获取当前登录用户信息
 * 从父页面中获取当前登录用户信息
 */
function getUserContext(){
	return window.parent.UserContext;
}
/**
 * 获取数据字典信息
 * 从父页面中获取数据字典信息
 */
function getDataDictionary(){
	return window.parent.DataDictionary;
}

/**
 * 日期类型数据转换器
 */
function dateConvert(value, record) {
	if (value != null) {
		var date = new Date(value);
		return date;
	} else {
		return null;
	}
}

/**
 * 表格日期显示
 * @param value
 * @param format
 * @returns
 */
function dateRender(value,format){
	if(Ext.isEmpty(format)){
		format = 'Y-m-d';
	}
	if(!Ext.isEmpty(value)){
		return Ext.Date.format(new Date(value), format);
	}
	return value;
}

/**
 * 时间格式
 * @param value
 * @param format
 * @returns {*}
 */
function timeRender(value,format){
    if(Ext.isEmpty(format)){
        format = 'Y-m-d H:i:s';
    }
    if(!Ext.isEmpty(value)){
        return Ext.Date.format(new Date(value), format);
    }
    return value;
}


/**
 * 是和否Render
 * @param value
 * @param format
 * @returns
 */
function booleanTypeRender(value){
	if(Ext.isEmpty(value)){
		return value;
	}
	if(butterfly.booleanType.yes == value){
		return '是';
	}
	if(butterfly.booleanType.no == value){
		return '否';
	}
	return value;
}

/**
 * 保留2位小数 四舍五入
 */
function numberRound(value){
	return value.toFixed(2);
}

/**
 * 保留2位小数下取
 */
function numberFloor(value){
	return Math.floor(value*100)/100;
}

/**
 * 保留2位小数上取
 */
function numberCeil(value){
	return Math.ceil(value*100)/100;
	
}

/**
 * 字体图标按钮定义
 */
//新增按钮
Ext.define('Caiwei.commonButton.CommonAddButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.addbutton',
	glyph : 0xf055,
	cls: 'add-btn-item'
});
//删除按钮
Ext.define('Caiwei.commonButton.CommonDeleteButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.deletebutton',
	glyph : 0xf014,
	cls: 'delete-btn-item'
});
//修改编辑按钮
Ext.define('Caiwei.commonButton.CommonUpdateButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.updatebutton',
	glyph : 0xf044,
	cls: 'update-btn-item'
});
//设置按钮
Ext.define('Caiwei.commonButton.CommonSettingsButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.settingsbutton',
	glyph : 0xf085,
	cls: 'settings-btn-item'
});
//刷新
Ext.define('Caiwei.commonButton.CommonRefreshButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.refreshbutton',
	glyph : 0xf021,
	cls: 'settings-btn-item'
});
//下载按钮
Ext.define('Caiwei.commonButton.CommonDownloadButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.downloadbutton',
	glyph : 0xf08e,
	cls: 'download-btn-item'
});
//上传按钮
Ext.define('Caiwei.commonButton.CommonUploadButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.uploadbutton',
	glyph : 0xf093,
	cls: 'upload-btn-item'
});
//查询按钮
Ext.define('Caiwei.commonButton.CommonSearchButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.searchbutton',
	glyph : 0xf00e,
	cls: 'search-btn-item'
});
//关闭按钮
Ext.define('Caiwei.commonButton.CommonCloseButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.closebutton',
	glyph : 0xf00d,
	cls: 'delete-btn-item'
});

//支付按钮
Ext.define('Caiwei.commonButton.CommonPaypalButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.paypalbutton',
	glyph : 0xf1ed,
	cls: 'paypal-btn-item'
});

//人民币（金额处理）按钮
Ext.define('Caiwei.commonButton.CommonRmbButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.rmbbutton',
	glyph : 0xf157,
	cls: 'rmb-btn-item'
});

//打印按钮
Ext.define('Caiwei.commonButton.CommonPrintButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.printbutton',
	glyph : 0xf02f,
	cls: 'print-btn-item'
});

//图表按钮
Ext.define('Caiwei.commonButton.CommonChartButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.chartbutton',
	glyph : 0xf080,
	cls: 'chart-btn-item'
});

//汽车按钮
Ext.define('Caiwei.commonButton.CommonTruckButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.truckbutton',
	glyph : 0xf0d1,
	cls: 'truck-btn-item'
});

//拷贝（导入）按钮
Ext.define('Caiwei.commonButton.CommonExportButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.exportbutton',
	glyph : 0xf0c5,
	cls: 'export-btn-item'
});
//导入开单
Ext.define('Caiwei.commonButton.CommonLevelDownButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.develdownbutton',
	glyph : 0xf149,
	cls: 'export-btn-item'
});
//用户
Ext.define('Caiwei.commonButton.CommonUserButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.userbutton',
	glyph : 0xf007,
	cls: 'export-btn-item'
});

//提交
Ext.define('Caiwei.commonButton.CommonSubmitButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.submitbutton',
	glyph : 0xf00c,
	cls: 'export-btn-item'
});

//审核
Ext.define('Caiwei.commonButton.CommonAuditButton', {
	extend : 'Ext.button.Button',
	alias: 'widget.auditbutton',
	glyph : 0xf14a,
	cls: 'export-btn-item'
});

Ext.override(Ext.window.Window, {
	buttonAlign  : 'center'
});

