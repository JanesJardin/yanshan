package com.wangdakeji.wongder.modular.stats.controller;

import com.wangdakeji.wongder.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 产品数据统计计控制器
 *
 * @author cj
 * @Date 2018-01-05 01:01:21
 */
@Controller
@RequestMapping("/productstats")
public class ProductstatsController extends BaseController {

    private String PREFIX = "/stats/productstats/";

    /**
     * 跳转到数据统计首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "productstats.html";
    }

    /**
     * 跳转到添加数据统计
     */
    @RequestMapping("/productstats_add")
    public String productstatsAdd() {
        return PREFIX + "productstats_add.html";
    }

    /**
     * 跳转到修改数据统计
     */
    @RequestMapping("/productstats_update/{productstatsId}")
    public String productstatsUpdate(@PathVariable Integer productstatsId, Model model) {
        return PREFIX + "productstats_edit.html";
    }

    /**
     * 获取数据统计列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增数据统计
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除数据统计
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改数据统计
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 数据统计详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
