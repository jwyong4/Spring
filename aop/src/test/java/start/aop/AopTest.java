package start.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import start.aop.order.OrderRepository;
import start.aop.order.OrderService;
import start.aop.order.aop.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Slf4j
@SpringBootTest
//@Import(Aspect1.class) // Aspect1 을 AOP로 사용하기 위하여 Bean으로 등록
//@Import(Aspect2.class) // @Pointcut을 이용해 Advice에서 PointCut을 분리하거나 합치는 예제
//@Import(Aspect3.class) // 트랜잭션이 동작하는 것처럼 로그 출력 기능 추가
//@Import(Aspect4.class) // 포인트컷을 공용으로 사용하기 위해 외부 클래스에 모아둔 것을 가져오는 예제
//@Import({Aspect5.LogAspect.class, Aspect5.TxAspect.class}) // Advice 순서를 지정하기 위해 클래스로 나눈 예제
@Import({Aspect6.class}) // 어드바이스 종류 예제
public class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void aopInfo() {
        log.info("isAopProxy, orderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository={}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    void success() {
        orderService.orderItem("itemA");
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
    }
}