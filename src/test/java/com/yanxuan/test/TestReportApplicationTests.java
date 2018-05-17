package com.yanxuan.test;

import com.yanxuan.test.dailyTest.BlogProperties;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestReportApplicationTests {

	@Autowired
	BlogProperties blogProperties;

	private Logger logger = Logger.getLogger(getClass());

	@Test
	public void contextLoads() {
//		BasicConfigurator.configure();
		logger.error(blogProperties.getName());
//		Assert.assertEquals("程序猿D",blogProperties.getName());
//		Assert.assertEquals("Spring Bot教程",blogProperties.getTitle());
	}

}
