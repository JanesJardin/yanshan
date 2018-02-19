package com.wangdakeji.wongder.modular.stats.controller;

import com.wangdakeji.wongder.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 酒店数据统计控制器
 *
 * @author cj
 * @Date 2018-01-05 01:01:55
 */
@Controller
@RequestMapping("/hotelstats")
public class HotelstatsController extends BaseController {

    private String PREFIX = "/stats/hotelstats/";

    /**
     * 跳转到酒店数据统计首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "hotelstats.html";
    }

    /**
     * 跳转到添加酒店数据统计
     */
    @RequestMapping("/hotelstats_add")
    public String hotelstatsAdd() {
        return PREFIX + "hotelstats_add.html";
    }

    /**
     * 跳转到修改酒店数据统计
     */
    @RequestMapping("/hotelstats_update/{hotelstatsId}")
    public String hotelstatsUpdate(@PathVariable Integer hotelstatsId, Model model) {
        return PREFIX + "hotelstats_edit.html";
    }

    /**
     * 获取酒店数据统计列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增酒店数据统计
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除酒店数据统计
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改酒店数据统计
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 酒店数据统计详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
