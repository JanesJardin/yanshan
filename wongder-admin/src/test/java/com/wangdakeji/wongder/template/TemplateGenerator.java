package com.wangdakeji.wongder.template;

import com.wangdakeji.wongder.core.template.config.ContextConfig;
import com.wangdakeji.wongder.core.template.engine.SimpleTemplateEngine;
import com.wangdakeji.wongder.core.template.engine.base.WongderTemplateEngine;

import java.io.IOException;

/**
 * 测试Wongder模板引擎
 *
 * @author cj
 * @date 2017-05-09 20:27
 */
public class TemplateGenerator {

    public static void main(String[] args) throws IOException {
        ContextConfig contextConfig = new ContextConfig();
        contextConfig.setModuleName("stats");
        contextConfig.setBizChName("酒店数据统计");
        contextConfig.setBizEnName("hotelstats");
        contextConfig.setProjectPath("/home/wangda/IdeaProjects/Wongder2/wongder-admin/");

        //contextConfig.setAddPageSwitch(false);
        //contextConfig.setEditPageSwitch(false);

        WongderTemplateEngine wongderTemplateEngine = new SimpleTemplateEngine();
        wongderTemplateEngine.setContextConfig(contextConfig);
        wongderTemplateEngine.start();
    }

}
