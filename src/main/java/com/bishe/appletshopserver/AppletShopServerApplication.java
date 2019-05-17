package com.bishe.appletshopserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bishe.appletshopserver"})
public class AppletShopServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppletShopServerApplication.class, args);
    }

}
