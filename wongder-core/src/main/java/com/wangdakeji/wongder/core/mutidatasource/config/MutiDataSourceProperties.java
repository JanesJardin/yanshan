package com.wangdakeji.wongder.core.mutidatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 默认多数据源配置
 *
 * @author cj
 * @date 2017-08-16 10:02
 */
@Data
@Component
@ConfigurationProperties(prefix = "wongder.muti-datasource")
public class MutiDataSourceProperties {

    //默认的数据源名称
    private String defaultDataSourceName = "dataSourceWongder";

    //默认多数据源的链接
    private String url = "jdbc:mysql://127.0.0.1:3306/biz?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";

    //默认多数据源的数据库账号
    private String username = "root";

    //默认多数据源的数据库密码
    private String password = "root";

    public void config(DruidDataSource dataSource) {
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }
}
