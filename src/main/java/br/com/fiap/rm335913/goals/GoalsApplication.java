package br.com.fiap.rm335913.goals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class GoalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoalsApplication.class, args);
	}

}
