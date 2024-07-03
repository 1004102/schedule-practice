package com.sparta.schedulepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SchedulePracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulePracticeApplication.class, args);
	}

}
