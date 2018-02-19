/**
 * 图纸管理管理初始化
 */
var Product = {
    id: "ProductTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Product.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Product.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Wongder.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Product.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加图纸管理
 */
Product.openAddProduct = function () {
    var index = layer.open({
        type: 2,
        title: '添加图纸管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Wongder.ctxPath + '/product/product_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看图纸管理详情
 */
Product.openProductDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '图纸管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Wongder.ctxPath + '/product/product_update/' + Product.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除图纸管理
 */
Product.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Wongder.ctxPath + "/product/delete", function (data) {
            Wongder.success("删除成功!");
            Product.table.refresh();
        }, function (data) {
            Wongder.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("productId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询图纸管理列表
 */
Product.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Product.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Product.initColumn();
    var table = new BSTable(Product.id, "/product/list", defaultColunms);
    table.setPaginationType("client");
    Product.table = table.init();
});
