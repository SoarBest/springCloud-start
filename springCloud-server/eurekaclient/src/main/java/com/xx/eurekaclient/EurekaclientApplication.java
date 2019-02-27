package com.xx.eurekaclient;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
注册服务注解
 */
@EnableEurekaClient
@RestController
@SpringBootApplication
public class EurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientApplication.class, args);
    }
    //获取yml里的端口值 用来判断负载均衡是否正常
    @Value("${server.port}")
    String port;


    @RequestMapping("/hi")
    public String home(String name) {
        System.out.println( "hi "+name+",i am from port:" +port);
        return "hi "+name+",i am from port:" +port;
    }

}

