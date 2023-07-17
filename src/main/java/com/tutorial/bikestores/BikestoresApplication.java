package com.tutorial.bikestores;

import com.tutorial.bikestores.user.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.xml.stream.FactoryConfigurationError;

@SpringBootApplication
public class BikestoresApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BikestoresApplication.class, args);
//
//		BrandRepository repository = (BrandRepository) context.getBean("brandRepository");
//		for (Brand brand : repository.findAll()) {
//			System.out.println(brand);
//		}
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
