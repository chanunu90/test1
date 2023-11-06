package cha.test.test1.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FirstService {
    

    String getSysDate();

    Long calculator(long num);




}
