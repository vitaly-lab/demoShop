package com.example.demoshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoShopApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(DemoShopApplication.class, args);
//	}
public static void main(String[] args) {

	ConfigurableApplicationContext context = SpringApplication.run(DemoShopApplication.class, args);
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
	System.out.println(encoder.encode("pass"));
}
}
