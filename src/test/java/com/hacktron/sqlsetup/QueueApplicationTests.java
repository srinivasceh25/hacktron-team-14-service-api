package com.hacktron.sqlsetup;

import com.hacktron.sqlsetup.controller.QueueController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueueApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void testGetQueues(){
		QueueController qCont =  mock(QueueController.class);
		when(qCont.createQueue(null)).thenReturn(null);
		assertEquals(qCont.getQueueById(null),null);
	}




}
