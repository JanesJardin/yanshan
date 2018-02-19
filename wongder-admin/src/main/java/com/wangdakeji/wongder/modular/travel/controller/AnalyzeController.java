package com.wangdakeji.wongder.modular.travel.controller;

import com.wangdakeji.wongder.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 行程分析控制器
 *
 * @author cj
 * @Date 2018-01-05 00:58:35
 */
@Controller
@RequestMapping("/analyze")
public class AnalyzeController extends BaseController {

    private String PREFIX = "/travel/analyze/";

    /**
     * 跳转到行程分析首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "analyze.html";
    }

    /**
     * 跳转到添加行程分析
     */
    @RequestMapping("/analyze_add")
    public String analyzeAdd() {
        return PREFIX + "analyze_add.html";
    }

    /**
     * 跳转到修改行程分析
     */
    @RequestMapping("/analyze_update/{analyzeId}")
    public String analyzeUpdate(@PathVariable Integer analyzeId, Model model) {
        return PREFIX + "analyze_edit.html";
    }

    /**
     * 获取行程分析列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增行程分析
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除行程分析
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改行程分析
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 行程分析详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
