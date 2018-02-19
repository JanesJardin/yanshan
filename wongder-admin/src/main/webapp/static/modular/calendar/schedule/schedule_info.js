/**
 * 初始化团期安排详情对话框
 */
var ScheduleInfoDlg = {
    scheduleInfoData : {}
};

/**
 * 清除数据
 */
ScheduleInfoDlg.clearData = function() {
    this.scheduleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ScheduleInfoDlg.set = function(key, val) {
    this.scheduleInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ScheduleInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ScheduleInfoDlg.close = function() {
    parent.layer.close(window.parent.Schedule.layerIndex);
}

/**
 * 收集数据
 */
ScheduleInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
ScheduleInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/schedule/add", function(data){
        Wongder.success("添加成功!");
        window.parent.Schedule.table.refresh();
        ScheduleInfoDlg.close();
    },function(data){
        Wongder.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.scheduleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ScheduleInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Wongder.ctxPath + "/schedule/update", function(data){
        Wongder.success("修改成功!");
        window.parent.Schedule.table.refresh();
        ScheduleInfoDlg.close();
    },function(data){
        Wongder.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.scheduleInfoData);
    ajax.start();
}

$(function() {

});
