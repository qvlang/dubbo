package com.lang.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.lang.dubbo.service.impl") //扫描dubbo服务所在包
@MapperScan(basePackages = "com.lang.dubbo.mapper") //扫描batis mapper包
@PropertySource("classpath:provider.properties")
@EnableTransactionManagement(proxyTargetClass = true) //开启事务
public class SApplication {
    public static void main(String[] args) {
        SpringApplication.run(SApplication.class, args);
    }
}
