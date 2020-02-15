package com.moinros.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    static {
        Config.init();
    }

    @Bean
    public DruidDataSource druidDataSource() {
        // 配置数据库信息
        DruidDataSource source = new DruidDataSource();
        // 配置Driver.class
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // 数据库连接URL,账号,密码通过读取外部配置文件读取
        source.setUrl(Config.get("file.server.datasource.url"));
        source.setUsername(Config.get("file.server.datasource.username"));
        source.setPassword(Config.get("file.server.datasource.password"));
        return source;
    }

}
