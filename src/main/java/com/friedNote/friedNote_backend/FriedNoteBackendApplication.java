package com.friedNote.friedNote_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ConfigurationPropertiesScan
@SpringBootApplication
@EnableJpaAuditing
@ConfigurationPropertiesScan
public class FriedNoteBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriedNoteBackendApplication.class, args);
	}

}
