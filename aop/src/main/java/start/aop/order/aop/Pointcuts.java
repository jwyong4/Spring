package start.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

// 포인트컷을 공용으로 사용하기 위해 외부 클래스에 모아두는 예제
public class Pointcuts {

    // 외부에서 접근할 때 접근 제한자는 public 이어야 한다.
    @Pointcut("execution(* start.aop.order..*(..))")
    public void allOrder(){}

    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    @Pointcut("allOrder() && allService()")
    public void orderAndService(){}
}
