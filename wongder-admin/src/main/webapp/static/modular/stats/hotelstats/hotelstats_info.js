/**
 * 初始化酒店数据统计详情对话框
 */
var HotelstatsInfoDlg = {
    hotelstatsInfoData : {}
};

/**
 * 清除数据
 */
HotelstatsInfoDlg.clearData = function() {
    this.hotelstatsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
HotelstatsInfoDlg.set = function(key, val) {
    this.hotelstatsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
HotelstatsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
HotelstatsInfoDlg.close = function() {
    parent.layer.close(window.parent.Hotelstats.layerIndex);
}

/**
 * 收集数据
 */
HotelstatsInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
HotelstatsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/hotelstats/add", function(data){
        Wongder.success("添加成功!");
        window.parent.Hotelstats.table.refresh();
        HotelstatsInfoDlg.close();
    },function(data){
        Wongder.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hotelstatsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
HotelstatsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/hotelstats/update", function(data){
        Wongder.success("修改成功!");
        window.parent.Hotelstats.table.refresh();
        HotelstatsInfoDlg.close();
    },function(data){
        Wongder.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hotelstatsInfoData);
    ajax.start();
}

$(function() {

});
