/**
 * 酒店数据统计管理初始化
 */
var Hotelstats = {
    id: "HotelstatsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Hotelstats.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Hotelstats.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Wongder.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Hotelstats.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加酒店数据统计
 */
Hotelstats.openAddHotelstats = function () {
    var index = layer.open({
        type: 2,
        title: '添加酒店数据统计',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Wongder.ctxPath + '/hotelstats/hotelstats_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看酒店数据统计详情
 */
Hotelstats.openHotelstatsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '酒店数据统计详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Wongder.ctxPath + '/hotelstats/hotelstats_update/' + Hotelstats.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除酒店数据统计
 */
Hotelstats.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Wongder.ctxPath + "/hotelstats/delete", function (data) {
            Wongder.success("删除成功!");
            Hotelstats.table.refresh();
        }, function (data) {
            Wongder.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("hotelstatsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询酒店数据统计列表
 */
Hotelstats.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Hotelstats.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Hotelstats.initColumn();
    var table = new BSTable(Hotelstats.id, "/hotelstats/list", defaultColunms);
    table.setPaginationType("client");
    Hotelstats.table = table.init();
});
