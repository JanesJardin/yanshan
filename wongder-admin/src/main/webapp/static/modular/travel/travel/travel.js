/**
 * 行程住宿管理管理初始化
 */
var Travel = {
    id: "TravelTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Travel.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Travel.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Wongder.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Travel.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加行程住宿管理
 */
Travel.openAddTravel = function () {
    var index = layer.open({
        type: 2,
        title: '添加行程住宿管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Wongder.ctxPath + '/travel/travel_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看行程住宿管理详情
 */
Travel.openTravelDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '行程住宿管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Wongder.ctxPath + '/travel/travel_update/' + Travel.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除行程住宿管理
 */
Travel.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Wongder.ctxPath + "/travel/delete", function (data) {
            Wongder.success("删除成功!");
            Travel.table.refresh();
        }, function (data) {
            Wongder.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("travelId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询行程住宿管理列表
 */
Travel.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Travel.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Travel.initColumn();
    var table = new BSTable(Travel.id, "/travel/list", defaultColunms);
    table.setPaginationType("client");
    Travel.table = table.init();
});
