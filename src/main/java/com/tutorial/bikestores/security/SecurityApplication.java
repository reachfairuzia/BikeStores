package com.tutorial.bikestores.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SecurityApplication.class, args);
		printBeans(context);
	}

	private static void printBeans(ApplicationContext context) {
		System.out.println("=".repeat(200));
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
	}

}
