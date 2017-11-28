package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
public class BasicApplication {

	private static final Logger log = LoggerFactory.getLogger(BasicApplication.class);
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BasicApplication.class, args);
		log.debug("SUCCESS!");
		System.out.println(context.getBean(TaijCongfiguration.class));
	}
	
	/**
	 * 3.	访问 http://localhost:8080/em/metrics能访问到访问http://localhost:8080/xyz的信息
	 */
	@Autowired
	private CounterService counterService;
	
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener() {
		final String XYZ_URL = "/xyz";

		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(XYZ_URL))
					counterService.increment("xyz.hits");
			}
		};
	}
}
