/**
 * 行程分析管理初始化
 */
var Analyze = {
    id: "AnalyzeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Analyze.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Analyze.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Wongder.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Analyze.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加行程分析
 */
Analyze.openAddAnalyze = function () {
    var index = layer.open({
        type: 2,
        title: '添加行程分析',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Wongder.ctxPath + '/analyze/analyze_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看行程分析详情
 */
Analyze.openAnalyzeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '行程分析详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Wongder.ctxPath + '/analyze/analyze_update/' + Analyze.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除行程分析
 */
Analyze.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Wongder.ctxPath + "/analyze/delete", function (data) {
            Wongder.success("删除成功!");
            Analyze.table.refresh();
        }, function (data) {
            Wongder.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("analyzeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询行程分析列表
 */
Analyze.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Analyze.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Analyze.initColumn();
    var table = new BSTable(Analyze.id, "/analyze/list", defaultColunms);
    table.setPaginationType("client");
    Analyze.table = table.init();
});
