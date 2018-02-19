package com.wangdakeji.wongder.modular.calendar.controller;

import com.wangdakeji.wongder.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 便签管理控制器
 *
 * @author cj
 * @Date 2018-01-05 01:00:11
 */
@Controller
@RequestMapping("/note")
public class NoteController extends BaseController {

    private String PREFIX = "/calendar/note/";

    /**
     * 跳转到便签管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "note.html";
    }

    /**
     * 跳转到添加便签管理
     */
    @RequestMapping("/note_add")
    public String noteAdd() {
        return PREFIX + "note_add.html";
    }

    /**
     * 跳转到修改便签管理
     */
    @RequestMapping("/note_update/{noteId}")
    public String noteUpdate(@PathVariable Integer noteId, Model model) {
        return PREFIX + "note_edit.html";
    }

    /**
     * 获取便签管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增便签管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除便签管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改便签管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 便签管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
