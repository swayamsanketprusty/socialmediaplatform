package com.example.registermvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.onlineplatform")
public class RegisterMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterMvcApplication.class, args);
	}

}
