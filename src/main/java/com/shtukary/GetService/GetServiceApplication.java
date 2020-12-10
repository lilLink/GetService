package com.shtukary.GetService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.shtukary.GetService"})
public class GetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetServiceApplication.class, args);
	}

}
