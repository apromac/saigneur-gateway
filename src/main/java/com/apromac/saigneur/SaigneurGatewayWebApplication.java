package com.apromac.saigneur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SaigneurGatewayWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaigneurGatewayWebApplication.class, args);
	}

}
