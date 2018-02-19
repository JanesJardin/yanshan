/**
 * 数据统计管理初始化
 */
var Stats = {
    id: "StatsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Stats.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Stats.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Wongder.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Stats.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加数据统计
 */
Stats.openAddStats = function () {
    var index = layer.open({
        type: 2,
        title: '添加数据统计',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Wongder.ctxPath + '/stats/stats_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看数据统计详情
 */
Stats.openStatsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '数据统计详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Wongder.ctxPath + '/stats/stats_update/' + Stats.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除数据统计
 */
Stats.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Wongder.ctxPath + "/stats/delete", function (data) {
            Wongder.success("删除成功!");
            Stats.table.refresh();
        }, function (data) {
            Wongder.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("statsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询数据统计列表
 */
Stats.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Stats.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Stats.initColumn();
    var table = new BSTable(Stats.id, "/stats/list", defaultColunms);
    table.setPaginationType("client");
    Stats.table = table.init();
});
