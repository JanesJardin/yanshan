package com.wangdakeji.wongder.core.template.config;

import lombok.Data;

/**
 * 页面 模板生成的配置
 *
 * @author cj
 * @date 2017-05-07 22:12
 */
@Data
public class PageConfig {

    private ContextConfig contextConfig;

    private String pagePathTemplate;
    private String pageAddPathTemplate;
    private String pageEditPathTemplate;
    private String pageJsPathTemplate;
    private String pageInfoJsPathTemplate;

    public void init() {
        pagePathTemplate = "\\src\\main\\webapp\\WEB-INF\\view\\" + contextConfig.getModuleName() + "\\{}\\{}.html";
        pageAddPathTemplate = "\\src\\main\\webapp\\WEB-INF\\view\\" + contextConfig.getModuleName() + "\\{}\\{}_add.html";
        pageEditPathTemplate = "\\src\\main\\webapp\\WEB-INF\\view\\" + contextConfig.getModuleName() + "\\{}\\{}_edit.html";
        pageJsPathTemplate = "\\src\\main\\webapp\\static\\modular\\" + contextConfig.getModuleName() + "\\{}\\{}.js";
        pageInfoJsPathTemplate = "\\src\\main\\webapp\\static\\modular\\" + contextConfig.getModuleName() + "\\{}\\{}_info.js";
    }

}
