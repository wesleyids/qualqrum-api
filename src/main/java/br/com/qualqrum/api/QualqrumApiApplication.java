package br.com.qualqrum.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"br.com.qualqrum.api.*"})
@SpringBootApplication
public class QualqrumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualqrumApiApplication.class, args);
	}

}
