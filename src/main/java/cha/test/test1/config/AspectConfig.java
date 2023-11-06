package cha.test.test1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "cha.test.") // AOP를 적용할 패키지 스캔
@EnableAspectJAutoProxy // AspectJ AOP 지원을 활성화
public class AspectConfig {
    
    // Aspect 클래스 빈으로 등록
    @Bean
    public AspectConfig myAspect() {
        return new AspectConfig();
    }
}

