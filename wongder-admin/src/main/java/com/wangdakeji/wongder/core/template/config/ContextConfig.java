package com.wangdakeji.wongder.core.template.config;

import com.wangdakeji.wongder.core.util.ToolUtil;
import lombok.Data;

/**
 * 全局配置
 *
 * @author cj
 * @date 2017-05-08 20:21
 */
@Data
public class ContextConfig {

    private String projectPath = Class.class.getClass().getResource("/").getPath();//"/home/wangda/IdeaProjects/Wongder";//模板输出的项目目录
    private String bizChName;   //业务名称
    private String bizEnName;   //业务英文名称
    private String bizEnBigName;//业务英文名称(大写)
    private String moduleName = "system";  //模块名称

    private Boolean controllerSwitch = true;    //是否生成控制器代码开关
    private Boolean indexPageSwitch = true;     //主页
    private Boolean addPageSwitch = true;       //添加页面
    private Boolean editPageSwitch = true;      //编辑页面
    private Boolean jsSwitch = true;            //js
    private Boolean infoJsSwitch = true;        //详情页面js
    private Boolean daoSwitch = true;           //dao
    private Boolean serviceSwitch = true;       //service

    public void setBizEnName(String bizEnName) {
        this.bizEnName = bizEnName;
        this.bizEnBigName = ToolUtil.firstLetterToUpper(this.bizEnName);
    }


}
