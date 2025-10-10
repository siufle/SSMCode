package com.xq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration //表明当前类是一个配置类 相当于applicationContext.xml
@ComponentScan(basePackages = "com.xq") //打开包扫描 相当于<context:component-scan>
@Import(value = {DataSourceConfig.class}) //导入子配置类
public class SpringConfiguration {


}
