package com.example.cmarket;

import com.example.cmarket.discount.DiscountInfo;
import com.example.cmarket.discount.RateDiscountInfo;
import com.example.cmarket.order.OrderService;
import com.example.cmarket.order.OrderServiceImpl;
import com.example.cmarket.user.UserRepository;
import com.example.cmarket.user.UserRepositoryImpl;
import com.example.cmarket.user.UserService;
import com.example.cmarket.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 클래스 내부에 있는 bean 메서드 실행
@ComponentScan // 이 위치의 하위 패키지들의 모든 bean 등록
public class AppConfig {
    @Bean // 실행 후 생성된 객체들은 스프링 컨테이너에서 관리함
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }
    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(userRepository(), discountInfo());
    }
    @Bean
    public DiscountInfo discountInfo() { return new RateDiscountInfo(); }
}