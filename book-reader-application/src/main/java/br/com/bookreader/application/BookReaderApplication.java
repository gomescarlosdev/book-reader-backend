package br.com.bookreader.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = {"br.com.bookreader.data_access.repository"})
@EntityScan(basePackages = {"br.com.bookreader.domain.entity"})
@ComponentScan(basePackages = {
		"br.com.bookreader.*", "org.modelmapper.*"
})
public class BookReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookReaderApplication.class, args);
	}

}
