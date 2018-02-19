package com.wangdakeji.wongder.core.util;

import com.wangdakeji.wongder.config.properties.WongderProperties;

/**
 * 验证码工具类
 *
 * @author cj
 * @Date 2017/5/23 22:34
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     *
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(WongderProperties.class).getKaptchaOpen();
    }
}