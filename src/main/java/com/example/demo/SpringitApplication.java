package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.swing.*;

@SpringBootApplication
public class SpringitApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
		System.out.println("Welcome to springit!!!");
	}

	@Bean
	@Profile("dev") 					// means this method will only be called if the profile is dev
	CommandLineRunner runner() {
		return args -> {
			System.out.println("This is something that we would only do in dev");
		};
	}

}
