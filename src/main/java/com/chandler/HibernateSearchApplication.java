package com.chandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.chandler.repository") //스프링 data JPA설정
public class HibernateSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateSearchApplication.class, args);
	}

}
