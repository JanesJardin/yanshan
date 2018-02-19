package com.wangdakeji.wongder.rest;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Wongder REST Web程序启动类
 *
 * @author cj
 * @date 2017年9月29日09:00:42
 */
public class WongderRestServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WongderRestApplication.class);
    }

}
