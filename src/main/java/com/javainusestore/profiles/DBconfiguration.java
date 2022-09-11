package com.javainusestore.profiles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBconfiguration {
	
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println("DB connection for Dev - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection for Dev H2";
	}
	
	@Profile("test")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("DB connection for Test - MySQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection for Test MySQL";
	}

}
