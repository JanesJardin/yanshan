/**
 * 初始化数据统计详情对话框
 */
var ProductstatsInfoDlg = {
    productstatsInfoData : {}
};

/**
 * 清除数据
 */
ProductstatsInfoDlg.clearData = function() {
    this.productstatsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductstatsInfoDlg.set = function(key, val) {
    this.productstatsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProductstatsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProductstatsInfoDlg.close = function() {
    parent.layer.close(window.parent.Productstats.layerIndex);
}

/**
 * 收集数据
 */
ProductstatsInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
ProductstatsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/productstats/add", function(data){
        Wongder.success("添加成功!");
        window.parent.Productstats.table.refresh();
        ProductstatsInfoDlg.close();
    },function(data){
        Wongder.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productstatsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProductstatsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/productstats/update", function(data){
        Wongder.success("修改成功!");
        window.parent.Productstats.table.refresh();
        ProductstatsInfoDlg.close();
    },function(data){
        Wongder.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.productstatsInfoData);
    ajax.start();
}

$(function() {

});
