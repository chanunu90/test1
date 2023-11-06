package cha.test.test1.service;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import cha.test.test1.mappers.TestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class FirstServiceImpl implements FirstService{

    final private TestMapper testMapper;

    @Override
    public String getSysDate() {
        // log.info("서비스 테스트" + testMapper.sysdateTest());

        return testMapper.sysdateTest();

    }

    @Override
    public Long calculator(long num) {
        long result = 1;
        for (long i = 1; i <= num; i++) 
        {
            result *= i;
        }
        
        return result;
    }

    

}
