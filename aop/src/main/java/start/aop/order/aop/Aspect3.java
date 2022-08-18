package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class Aspect3 { // 트랜잭션이 동작하는 것처럼 로그 출력 기능 추가

    @Pointcut("execution(* start.aop.order..*(..))")
    private void allOrder(){}

    @Pointcut("execution(* *..* Service.*(..))") // 이름이 Service로 끝나는 것(클래스, 인터페이스)을 대상으로 하는 PointCut
    private void allService(){}

    @Around("allOrder()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
    @Around("allOrder() && allService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("트랜잭션 시작 -> {}", joinPoint.getSignature()); // 트랜잭션 시작
            Object result = joinPoint.proceed(); // 핵심 로직 실행
            log.info("트랜잭션 커밋 -> {}", joinPoint.getSignature()); // 문제 없으면 트랜잭션 커밋
            return result;
        }
        catch (Exception e) {
            log.info("트랜잭션 롤백 -> {}", joinPoint.getSignature()); // 예외가 있으면 트랜잭션 롤백
            throw e;
        }
        finally {
            log.info("리소스 릴리즈 -> {}", joinPoint.getSignature());
        }
    }
}
