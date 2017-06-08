package com.sld.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sld")
public class SdocApplication {

	public static void main(String[] args) {

		SpringApplication.run(SdocApplication.class, args);
	}
}
