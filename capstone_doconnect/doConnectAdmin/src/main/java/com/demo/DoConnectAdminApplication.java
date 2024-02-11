package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.demo.model.AdminBean;
import com.demo.repositry.AdminRepositry;

@SpringBootApplication
@EnableEurekaClient
public class DoConnectAdminApplication {

	// Instance variable of UserRepositry
	@Autowired
	private AdminRepositry userRepositry;

	/**
	 * @see This is main function
	 * @since 03-Jan-2022
	 * @author Vishal Bharti
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DoConnectAdminApplication.class, args);
		System.out.println("Admin Service");
	}

	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}

}
