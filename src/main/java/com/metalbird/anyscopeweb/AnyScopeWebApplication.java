package com.metalbird.anyscopeweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AnyScopeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnyScopeWebApplication.class, args);
	}

}
