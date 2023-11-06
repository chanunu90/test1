package cha.test.test1.dbtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cha.test.test1.mappers.TestMapper;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class dbtest {

	@Autowired
    private TestMapper mapper;

	@Test
	public void datedTest() {

		log.info("실행은 됨");

        log.info(mapper.sysdateTest());

	}

}
