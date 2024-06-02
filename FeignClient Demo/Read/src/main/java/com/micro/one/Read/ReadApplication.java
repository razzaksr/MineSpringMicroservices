package com.micro.one.Read;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:apps.properties")
public class ReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadApplication.class, args);
	}

}
