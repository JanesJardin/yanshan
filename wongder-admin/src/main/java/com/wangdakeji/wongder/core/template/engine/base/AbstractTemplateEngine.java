package com.wangdakeji.wongder.core.template.engine.base;

import com.wangdakeji.wongder.core.template.config.*;
import lombok.Data;

/**
 * 模板生成父类
 *
 * @author cj
 * @date 2017-05-08 20:17
 */
@Data
public class AbstractTemplateEngine {

    protected ContextConfig contextConfig;                //全局配置
    protected ControllerConfig controllerConfig;          //控制器的配置
    protected PageConfig pageConfig;                      //页面的控制器
    protected DaoConfig daoConfig;                        //Dao配置
    protected ServiceConfig serviceConfig;                //Service配置

    public void initConfig() {
        if (this.contextConfig == null) {
            this.contextConfig = new ContextConfig();
        }
        if (this.controllerConfig == null) {
            this.controllerConfig = new ControllerConfig();
        }
        if (this.pageConfig == null) {
            this.pageConfig = new PageConfig();
        }
        if (this.daoConfig == null) {
            this.daoConfig = new DaoConfig();
        }
        if (this.serviceConfig == null) {
            this.serviceConfig = new ServiceConfig();
        }

        this.controllerConfig.setContextConfig(this.contextConfig);
        this.controllerConfig.init();

        this.serviceConfig.setContextConfig(this.contextConfig);
        this.serviceConfig.init();

        this.daoConfig.setContextConfig(this.contextConfig);
        this.daoConfig.init();

        this.pageConfig.setContextConfig(this.contextConfig);
        this.pageConfig.init();
    }

}

