package com.example.demo;

import com.example.demo.domain.lombok.Comment;
import com.example.demo.domain.lombok.Link;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
		System.out.println("Welcome to springit!!!");
	}

//	@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			Link link = new Link("Getting started with Springboot 2", "https://therealdanvega.com/spring-boot-2");
			linkRepository.save(link);

			Comment comment = new Comment("This spring boot 2 link is awesome", link);
			commentRepository.save(comment);

			link.addComment(comment);


//			Link firstLink = linkRepository.findByTitle("Getting started with Springboot 2");
//			System.out.println(firstLink.getTitle());

			List<Link> links = linkRepository.findAllByTitleLikeOrderByCreationDateDesc("Getting started with Springboot 2");
			System.out.println("Links size : " + links.size());
			links.stream().forEach(eLink -> System.out.println("Link : " + eLink.getTitle()));
		};
	}

}
