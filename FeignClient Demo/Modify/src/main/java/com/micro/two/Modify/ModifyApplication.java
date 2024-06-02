package com.micro.two.Modify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:apps.properties")
@EnableFeignClients
public class ModifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModifyApplication.class, args);
	}

}
