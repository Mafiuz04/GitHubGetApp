package com.Mafiuz04.DepoGet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DepoGetApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepoGetApplication.class, args);
	}

}
