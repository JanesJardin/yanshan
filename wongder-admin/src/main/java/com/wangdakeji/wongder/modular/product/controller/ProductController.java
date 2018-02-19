package com.wangdakeji.wongder.modular.product.controller;

import com.wangdakeji.wongder.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 图纸管理控制器
 *
 * @author cj
 * @Date 2018-01-05 00:56:21
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    private String PREFIX = "/product/product/";

    /**
     * 跳转到图纸管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "product.html";
    }

    /**
     * 跳转到添加图纸管理
     */
    @RequestMapping("/product_add")
    public String productAdd() {
        return PREFIX + "product_add.html";
    }

    /**
     * 跳转到修改图纸管理
     */
    @RequestMapping("/product_update/{productId}")
    public String productUpdate(@PathVariable Integer productId, Model model) {
        return PREFIX + "product_edit.html";
    }

    /**
     * 获取图纸管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增图纸管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除图纸管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改图纸管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 图纸管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
