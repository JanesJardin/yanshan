package com.wangdakeji.wongder.modular.travel.controller;

import com.wangdakeji.wongder.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 行程住宿管理控制器
 *
 * @author cj
 * @Date 2018-01-05 00:57:12
 */
@Controller
@RequestMapping("/travel")
public class TravelController extends BaseController {

    private String PREFIX = "/travel/travel/";

    /**
     * 跳转到行程住宿管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "travel.html";
    }

    /**
     * 跳转到添加行程住宿管理
     */
    @RequestMapping("/travel_add")
    public String travelAdd() {
        return PREFIX + "travel_add.html";
    }

    /**
     * 跳转到修改行程住宿管理
     */
    @RequestMapping("/travel_update/{travelId}")
    public String travelUpdate(@PathVariable Integer travelId, Model model) {
        return PREFIX + "travel_edit.html";
    }

    /**
     * 获取行程住宿管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增行程住宿管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除行程住宿管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改行程住宿管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 行程住宿管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
