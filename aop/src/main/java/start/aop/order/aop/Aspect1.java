package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect // AOP 구현
public class Aspect1 {

    // 해당 패키지와 하위 패키지를 지정한 AspectJ PointCut, order 패키지 안의 메서드들은 AOP 적용 대상이 됨
    @Around("execution(* start.aop.order..*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable { // logging은 Advice가 됨
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}