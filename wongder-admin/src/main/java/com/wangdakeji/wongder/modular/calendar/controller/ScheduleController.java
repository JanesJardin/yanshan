package com.wangdakeji.wongder.modular.calendar.controller;

import com.wangdakeji.wongder.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 团期安排控制器
 *
 * @author cj
 * @Date 2018-01-05 00:59:48
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController {

    private String PREFIX = "/calendar/schedule/";

    /**
     * 跳转到团期安排首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "schedule.html";
    }

    /**
     * 跳转到添加团期安排
     */
    @RequestMapping("/schedule_add")
    public String scheduleAdd() {
        return PREFIX + "schedule_add.html";
    }

    /**
     * 跳转到修改团期安排
     */
    @RequestMapping("/schedule_update/{scheduleId}")
    public String scheduleUpdate(@PathVariable Integer scheduleId, Model model) {
        return PREFIX + "schedule_edit.html";
    }

    /**
     * 获取团期安排列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增团期安排
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除团期安排
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改团期安排
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 团期安排详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
