package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.demo.repositry.AnswerRepository;

@SpringBootApplication
@EnableEurekaClient
public class DoConnectUserApplication {
	/**
	 * @see this is the main class of user microservice
	 * @author Vishal Bharti
	 * @since 02-Jan-2022
	 */
	@Autowired
	public AnswerRepository answerRepository;

	public static void main(String[] args) {
		SpringApplication.run(DoConnectUserApplication.class, args);
		System.out.println("User Service");
		System.out.println("Changes");

	}

}
