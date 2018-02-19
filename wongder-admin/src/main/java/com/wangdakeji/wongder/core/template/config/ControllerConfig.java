package com.wangdakeji.wongder.core.template.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器模板生成的配置
 *
 * @author cj
 * @date 2017-05-07 22:12
 */
@Data
public class ControllerConfig {

    private ContextConfig contextConfig;

    private String controllerPathTemplate;
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("com.wangdakeji.wongder.core.base.controller.BaseController");
        imports.add("org.springframework.stereotype.Controller");
        imports.add("org.springframework.web.bind.annotation.RequestMapping");
        imports.add("org.springframework.web.bind.annotation.ResponseBody");
        imports.add("org.springframework.ui.Model");
        imports.add("org.springframework.web.bind.annotation.PathVariable");
        this.imports = imports;
        this.packageName = "com.wangdakeji.wongder.modular." + contextConfig.getModuleName() + ".controller";
        this.controllerPathTemplate = "\\src\\main\\java\\com\\wangdakeji\\wongder\\modular\\" + contextConfig.getModuleName() + "\\controller\\{}Controller.java";
    }

}
