package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
    /*
	@Autowired
	Repo repo;

	@Bean
	public CommandLineRunner demo(Repo repo) {
		return (args) -> {
			repo.save(new Zamestnanec("Natalia","1105142501"));
		};
	}
    */

}
