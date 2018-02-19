package com.wangdakeji.wongder.rest.config;

import com.wangdakeji.wongder.core.config.DefaultFastjsonConfig;
import com.wangdakeji.wongder.rest.modular.auth.converter.WithSignMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 签名校验messageConverter
 *
 * @author cj
 * @date 2017-08-25 16:04
 */
@Configuration
public class MessageConverConfig {

    @Bean
    public WithSignMessageConverter withSignMessageConverter() {
        WithSignMessageConverter withSignMessageConverter = new WithSignMessageConverter();
        DefaultFastjsonConfig defaultFastjsonConfig = new DefaultFastjsonConfig();
        withSignMessageConverter.setFastJsonConfig(defaultFastjsonConfig.fastjsonConfig());
        withSignMessageConverter.setSupportedMediaTypes(defaultFastjsonConfig.getSupportedMediaType());
        return withSignMessageConverter;
    }
}
