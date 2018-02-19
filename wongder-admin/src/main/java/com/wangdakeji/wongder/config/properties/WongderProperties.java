package com.wangdakeji.wongder.config.properties;

import com.wangdakeji.wongder.core.util.ToolUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * wongder项目配置
 *
 * @author cj
 * @Date 2017/5/23 22:31
 */
@Component
@Data
@ConfigurationProperties(prefix = WongderProperties.PREFIX)
public class WongderProperties {

    public static final String PREFIX = "wongder";

    private Boolean kaptchaOpen = false;

    private Boolean swaggerOpen = false;

    private String fileUploadPath;

    private Boolean haveCreatePath = false;

    private Boolean springSessionOpen = false;

    private Integer sessionInvalidateTime = 30 * 60;  //session 失效时间（默认为30分钟 单位：秒）

    private Integer sessionValidationInterval = 15 * 60;  //session 验证失效时间（默认为15分钟 单位：秒）

    public String getFileUploadPath() {
        //如果没有写文件上传路径,保存到临时目录
        if (ToolUtil.isEmpty(fileUploadPath)) {
            return ToolUtil.getTempPath();
        } else {
            //判断有没有结尾符,没有得加上
            if (!fileUploadPath.endsWith(File.separator)) {
                fileUploadPath = fileUploadPath + File.separator;
            }
            //判断目录存不存在,不存在得加上
            if (haveCreatePath == false) {
                File file = new File(fileUploadPath);
                file.mkdirs();
                haveCreatePath = true;
            }
            return fileUploadPath;
        }
    }

}
