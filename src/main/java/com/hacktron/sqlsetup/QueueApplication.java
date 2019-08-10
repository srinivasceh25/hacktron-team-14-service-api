package com.hacktron.sqlsetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueApplication.class, args);
	}
}
