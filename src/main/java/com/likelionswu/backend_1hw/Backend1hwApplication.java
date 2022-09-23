package com.likelionswu.backend_1hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaAuditing
@PropertySource("classpath:/env.properties")
public class Backend1hwApplication {

	public static void main(String[] args) {
		SpringApplication.run(Backend1hwApplication.class, args);
	}

}
