/**
 * 团期安排管理初始化
 */
var Schedule = {
    id: "ScheduleTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Schedule.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Schedule.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Wongder.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Schedule.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加团期安排
 */
Schedule.openAddSchedule = function () {
    var index = layer.open({
        type: 2,
        title: '添加团期安排',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Wongder.ctxPath + '/schedule/schedule_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看团期安排详情
 */
Schedule.openScheduleDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '团期安排详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Wongder.ctxPath + '/schedule/schedule_update/' + Schedule.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除团期安排
 */
Schedule.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Wongder.ctxPath + "/schedule/delete", function (data) {
            Wongder.success("删除成功!");
            Schedule.table.refresh();
        }, function (data) {
            Wongder.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("scheduleId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询团期安排列表
 */
Schedule.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Schedule.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Schedule.initColumn();
    var table = new BSTable(Schedule.id, "/schedule/list", defaultColunms);
    table.setPaginationType("client");
    Schedule.table = table.init();
});
