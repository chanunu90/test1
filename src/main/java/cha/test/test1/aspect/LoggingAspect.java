package cha.test.test1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    //실제 어드바이스 유형을 나타낸것(@Before @after 같이 동작 타이밍)
    //execution 는 포인트컷 표현식을 쓸수 있게해주는데 aspectj에 포함되어있다.
    //service로 시작되는 java파일 실행시 이걸 타게 할수 있다.
    // @Before("execution(* *..service.*.*(..))")
    @Before("execution(* *..service.*.getSysDate())")
    // @Around("execution(* *..service.*.*(..))") 
    public void logBeforeBusinessLogic() {
        System.out.println("서비스를 실행할때 AOP로 로깅실행");
    }


    //해당 메서드의 실행 시간도 여기서 체크가 가능하다.
    // @Before("execution(* *..service.*.calculator(long))")
    // public void calculatorBeforeBusinessLogic() {

    //     long start = System.nanoTime();
    //     log.info("계산시작" + start);
    // }

    // @After("execution(* *..service.*.calculator(long))")
    // public void calculatorAfterBusinessLogic() {

    //     long end = System.nanoTime();
    //     log.info("계산끝" + end);
    // }
    //다른 방법을 써보자
    @Pointcut("execution(* *..service.*.calculator(long))")
    private void calculatorTarget() {
        //모듈화를 위하여~
    }

    //직접 호출
    @Around("calculatorTarget()")
    public Object calculatorBusinessLogic(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            log.info("결과값" + result);
            return result; // joinPoint.proceed()의 결과를 반환
        } finally {
             long end = System.nanoTime();
            //  log.info("총 걸린시간은" + (joinPoint.getTarget().getClass().getSimpleName()) + ((end-start)/1000000000) + "초");
            Signature signature = joinPoint.getSignature();
            String methodName = signature.getName();

            // log.info("총 걸린시간은" + methodName + " " + ((float)(end-start)/1000000000) + "초");
            log.info("총 걸린시간은 {} {} 초", methodName, ((float)(end - start) / 1000000000));
        }
    }

}
