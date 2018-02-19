package com.wangdakeji.wongder;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Wongder Web tomcat等程序启动类
 *
 * @author cj
 * @date 2017-05-21 9:43
 */
public class WongderServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WongderApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        super.onStartup(servletContext);
    }
}
