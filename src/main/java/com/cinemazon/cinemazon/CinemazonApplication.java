package com.cinemazon.cinemazon;

import com.cinemazon.cinemazon.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// @Import(WebConfig.class) TODO
public class CinemazonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemazonApplication.class, args);
	}

}
