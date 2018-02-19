/**
 * 便签管理管理初始化
 */
var Note = {
    id: "NoteTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Note.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Note.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Wongder.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Note.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加便签管理
 */
Note.openAddNote = function () {
    var index = layer.open({
        type: 2,
        title: '添加便签管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Wongder.ctxPath + '/note/note_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看便签管理详情
 */
Note.openNoteDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '便签管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Wongder.ctxPath + '/note/note_update/' + Note.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除便签管理
 */
Note.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Wongder.ctxPath + "/note/delete", function (data) {
            Wongder.success("删除成功!");
            Note.table.refresh();
        }, function (data) {
            Wongder.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("noteId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询便签管理列表
 */
Note.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Note.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Note.initColumn();
    var table = new BSTable(Note.id, "/note/list", defaultColunms);
    table.setPaginationType("client");
    Note.table = table.init();
});
