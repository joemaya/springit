package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.util.Arrays;

@SpringBootApplication
public class SpringitApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
		System.out.println("Welcome to springit!!!");
	}


//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args -> {
//			System.out.println("Printing out all the bean names in the application context");
//			System.out.println("----------------------------------------------------------");
//			String [] beans = applicationContext.getBeanDefinitionNames();
//			Arrays.sort(beans);
//			Arrays.stream(beans).forEach(bean -> System.out.println(bean));
//		};
//	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			log.error("Error");
			log.info("Info");
			log.debug("Debug");
			log.trace("Trace");
			log.warn("Warn");

		};
	}

}
