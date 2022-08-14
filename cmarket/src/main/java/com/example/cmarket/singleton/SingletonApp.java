package com.example.cmarket.singleton;

import com.example.cmarket.AppConfig;
import com.example.cmarket.singleton.SingletonService;
import com.example.cmarket.user.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonApp {
    static AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    static UserService userService1 = ac.getBean("userService", UserService.class);
    static UserService userService2 = ac.getBean("userService", UserService.class);

    public static void main(String[] args) {
        System.out.println("userService1 : " + userService1);
        System.out.println("userService2 : " + userService2);
    }
}
