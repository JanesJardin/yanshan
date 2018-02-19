package com.wangdakeji.wongder.core.template.config;

import lombok.Data;

/**
 * Dao模板生成的配置
 *
 * @author cj
 * @date 2017-05-07 22:12
 */
@Data
public class DaoConfig {

    private ContextConfig contextConfig;

    private String daoPathTemplate;
    private String xmlPathTemplate;

    private String packageName;

    public void init() {
        this.daoPathTemplate = "\\src\\main\\java\\com\\wangdakeji\\wongder\\modular\\" + contextConfig.getModuleName() + "\\dao\\{}Dao.java";
        this.xmlPathTemplate = "\\src\\main\\java\\com\\wangdakeji\\wongder\\modular\\" + contextConfig.getModuleName() + "\\dao\\mapping\\{}Dao.xml";
        this.packageName = "com.wangdakeji.wongder.modular." + contextConfig.getModuleName() + ".dao";
    }

}
