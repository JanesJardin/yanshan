/**
 * 初始化行程分析详情对话框
 */
var AnalyzeInfoDlg = {
    analyzeInfoData : {}
};

/**
 * 清除数据
 */
AnalyzeInfoDlg.clearData = function() {
    this.analyzeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AnalyzeInfoDlg.set = function(key, val) {
    this.analyzeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AnalyzeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AnalyzeInfoDlg.close = function() {
    parent.layer.close(window.parent.Analyze.layerIndex);
}

/**
 * 收集数据
 */
AnalyzeInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
AnalyzeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/analyze/add", function(data){
        Wongder.success("添加成功!");
        window.parent.Analyze.table.refresh();
        AnalyzeInfoDlg.close();
    },function(data){
        Wongder.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.analyzeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AnalyzeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/analyze/update", function(data){
        Wongder.success("修改成功!");
        window.parent.Analyze.table.refresh();
        AnalyzeInfoDlg.close();
    },function(data){
        Wongder.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.analyzeInfoData);
    ajax.start();
}

$(function() {

});
