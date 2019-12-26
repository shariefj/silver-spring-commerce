package com.silver.commerce.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class TestScheduler {

	private static final Logger logger = LoggerFactory.getLogger(TestScheduler.class);
	
	  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	 //@Scheduled(fixedRate = 5000)
	 public void reportCurrentTime() {
		 logger.info("The time is now {}", dateFormat.format(new Date()));
		 
		// System.out.println("Time now is .....new Date");
	 
	}
	
}
