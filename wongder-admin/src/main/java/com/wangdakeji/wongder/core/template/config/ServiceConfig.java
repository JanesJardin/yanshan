package com.wangdakeji.wongder.core.template.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Service模板生成的配置
 *
 * @author cj
 * @date 2017-05-07 22:12
 */
@Data
public class ServiceConfig {

    private ContextConfig contextConfig;

    private String servicePathTemplate;

    private String serviceImplPathTemplate;

    private String packageName;

    private List<String> serviceImplImports;

    private String ctxPackagePath="com.wangdakeji.wongder.modular.";

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("org.springframework.stereotype.Service");
        imports.add( ctxPackagePath+ contextConfig.getModuleName() + ".service.I" + contextConfig.getBizEnBigName() + "Service");
        this.serviceImplImports = imports;
        this.servicePathTemplate = "\\src\\main\\java\\"+ctxPackagePath.replace(".","\\")+ contextConfig.getModuleName() + "\\service\\I{}Service.java";
        this.serviceImplPathTemplate = "\\src\\main\\java\\"+ctxPackagePath.replace(".","\\") + contextConfig.getModuleName() + "\\service\\impl\\{}ServiceImpl.java";
        this.packageName = ctxPackagePath + contextConfig.getModuleName() + ".service";
    }

}
