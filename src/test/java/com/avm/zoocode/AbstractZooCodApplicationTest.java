package com.avm.zoocode;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = com.avm.zoocode.ZooCodeApplication.class)
@WebAppConfiguration
public abstract class AbstractZooCodApplicationTest {

}
