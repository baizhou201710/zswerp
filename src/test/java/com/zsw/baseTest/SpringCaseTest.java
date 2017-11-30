package com.zsw.baseTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/10 14:41
 */
//指定bean注入的配置文件
@ContextConfiguration(locations = {"classpath:spring.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringCaseTest extends AbstractJUnit4SpringContextTests {
}
