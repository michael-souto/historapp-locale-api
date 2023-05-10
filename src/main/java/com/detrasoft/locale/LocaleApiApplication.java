package com.detrasoft.locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.detrasoft")
@SpringBootApplication(scanBasePackages = {"com.detrasoft",})
@EntityScan(basePackages = {"com.detrasoft",})
@EnableJpaRepositories(basePackages = {"com.detrasoft.locale",})
public class LocaleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocaleApiApplication.class, args);
	}

}
