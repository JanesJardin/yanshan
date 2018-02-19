package com.wangdakeji.wongder.rest.config;

import com.wangdakeji.wongder.rest.modular.auth.filter.AuthFilter;
import com.wangdakeji.wongder.rest.modular.auth.security.DataSecurityAction;
import com.wangdakeji.wongder.rest.modular.auth.security.impl.Base64SecurityAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web配置
 *
 * @author cj
 * @date 2017-08-23 15:48
 */
@Configuration
public class WebConfig {

    @Bean
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }

    @Bean
    public DataSecurityAction dataSecurityAction() {
        return new Base64SecurityAction();
    }
}
