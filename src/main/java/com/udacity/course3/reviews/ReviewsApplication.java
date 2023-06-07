package com.udacity.course3.reviews;

//import org.flywaydb.core.Flyway;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class ReviewsApplication {

	private static String DB_URL="";
	private static String DB_USERNAME="";
	private static String DB_PASSWORD="";

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);

		setDbProperties();
		runFlywayMigrations();
	}

	public static void runFlywayMigrations() {
		Flyway flyway = Flyway.configure().dataSource(DB_URL, DB_USERNAME, DB_PASSWORD).load();
		flyway.baseline();
		flyway.migrate();
	}

	public static void setDbProperties() {
		// Read db configs from application.properties
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("application.properties");
		try {
			prop.load(stream);
			DB_URL = prop.getProperty("spring.datasource.url");
			DB_USERNAME = prop.getProperty("spring.datasource.username");
			DB_PASSWORD = prop.getProperty("spring.datasource.password");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}