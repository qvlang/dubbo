package com.lang.dubbo;

import com.lang.dubbo.config.DubboConfig;
import com.lang.dubbo.controller.UserController;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubbo(scanBasePackages = "com.lang.dubbo.controller")
@PropertySource("classpath:consumer.properties")
public class CApplication {
    public static void main(String[] args) throws IOException {
        // ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        SpringApplication.run(CApplication.class, args);
    }
}
