/**
 * 初始化数据统计详情对话框
 */
var StatsInfoDlg = {
    statsInfoData : {}
};

/**
 * 清除数据
 */
StatsInfoDlg.clearData = function() {
    this.statsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StatsInfoDlg.set = function(key, val) {
    this.statsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StatsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
StatsInfoDlg.close = function() {
    parent.layer.close(window.parent.Stats.layerIndex);
}

/**
 * 收集数据
 */
StatsInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
StatsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/stats/add", function(data){
        Wongder.success("添加成功!");
        window.parent.Stats.table.refresh();
        StatsInfoDlg.close();
    },function(data){
        Wongder.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.statsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
StatsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/stats/update", function(data){
        Wongder.success("修改成功!");
        window.parent.Stats.table.refresh();
        StatsInfoDlg.close();
    },function(data){
        Wongder.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.statsInfoData);
    ajax.start();
}

$(function() {

});
