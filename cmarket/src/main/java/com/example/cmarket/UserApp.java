package com.example.cmarket;

import com.example.cmarket.user.User;
import com.example.cmarket.user.UserGrade;
import com.example.cmarket.user.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 회원 로직 테스트
public class UserApp {
    public static void main(String[] args) {
        /**
         *         기존 AppConfig를 직접 가져와 주입해주는 방식
         *         AppConfig appConfig = new AppConfig();
         *         UserService userService = appConfig.userService();
         */
        // 컨테이너에 등록된 AppConfig bean을 가져오는 형식으로 바꿈
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = ac.getBean("userService", UserService.class);

        User user = new User(0L, "kimcoding", UserGrade.GRADE_2);
        userService.signup(user);

        User currentUser = userService.findUser(0L);
        System.out.println("signup user : " + user.getName());
        System.out.println("current user : " + currentUser.getName());

        if (user.getName().equals(currentUser.getName())) {
            System.out.println("새롭게 가입한 사용자와 현재 사용자가 같습니다.");
        }
    }
}
