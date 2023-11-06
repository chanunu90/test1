package cha.test.test1.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //실제 어드바이스 유형을 나타낸것(@Before @after 같이 동작 타이밍)
    //execution 는 포인트컷 표현식을 쓸수 있게해주는데 aspectj에 포함되어있다.
    //service로 시작되는 java파일 실행시 이걸 타게 할수 있다.
    // @Before("execution(* *..service.*.*(..))")
    @Before("execution(* *..service.*.calculator(long))")
    // @Around("execution(* *..service.*.*(..))") 
    public void logBeforeBusinessLogic() {
        System.out.println("서비스를 실행할때 AOP로 로깅실행");
    }
}
