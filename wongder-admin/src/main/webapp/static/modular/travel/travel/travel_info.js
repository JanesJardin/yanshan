/**
 * 初始化行程住宿管理详情对话框
 */
var TravelInfoDlg = {
    travelInfoData : {}
};

/**
 * 清除数据
 */
TravelInfoDlg.clearData = function() {
    this.travelInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TravelInfoDlg.set = function(key, val) {
    this.travelInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TravelInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TravelInfoDlg.close = function() {
    parent.layer.close(window.parent.Travel.layerIndex);
}

/**
 * 收集数据
 */
TravelInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
TravelInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/travel/add", function(data){
        Wongder.success("添加成功!");
        window.parent.Travel.table.refresh();
        TravelInfoDlg.close();
    },function(data){
        Wongder.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.travelInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TravelInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/travel/update", function(data){
        Wongder.success("修改成功!");
        window.parent.Travel.table.refresh();
        TravelInfoDlg.close();
    },function(data){
        Wongder.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.travelInfoData);
    ajax.start();
}

$(function() {

});
