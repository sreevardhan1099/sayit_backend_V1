package com.st.sayit;

import Customexceptions.Globalexceptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(Globalexceptions.class)
@SpringBootApplication
public class SayitBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SayitBackendApplication.class, args);
	}

}
