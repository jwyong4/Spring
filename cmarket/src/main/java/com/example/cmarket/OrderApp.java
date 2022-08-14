package com.example.cmarket;

import com.example.cmarket.order.Order;
import com.example.cmarket.order.OrderService;
import com.example.cmarket.user.User;
import com.example.cmarket.user.UserGrade;
import com.example.cmarket.user.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        /**
         *         기존 AppConfig를 직접 가져와 주입해주는 방식
         *         AppConfig appConfig = new AppConfig();
         *         UserService userService = appConfig.userService();
         *         OrderService orderService = appConfig.orderService();
         */
        // AnnotationConfigApplicationContext를 이용해 컨테이너에 등록된 AppConfig bean을 가져오는 형식으로 바꿈
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = ac.getBean("userService", UserService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long userId = 0L;
        User user = new User(userId, "kimlucky", UserGrade.GRADE_1);
        userService.signup(user);

        Order order = orderService.createOrder(userId, "coffee", 5000);

        System.out.println("order = " + order);

//        CurrentDiscountInfo discountInfo = new CurrentDiscountInfo();
//
//        User user = new User(0L, "kimcoding", UserGrade.GRADE_1);
//        int discountedPrice = discountInfo.discount(user, 5000);
//
//        if(discountedPrice == 500) {
//            System.out.println("회원 등급에 알맞은 할인이 적용되었습니다.");
//            System.out.println("1등급 회원으로 5000 -> " + discountedPrice);
//        }
//        user = new User(0L, "leejava", UserGrade.GRADE_2);
//        discountedPrice = discountInfo.discount(user, 5000);
//
//        if(discountedPrice == 1000) {
//            System.out.println("회원 등급에 알맞은 할인이 적용되었습니다.");
//            System.out.println("2등급 회원으로 5000 -> " + discountedPrice);
        }
    }

