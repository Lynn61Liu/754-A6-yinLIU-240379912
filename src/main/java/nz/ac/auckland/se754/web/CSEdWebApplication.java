package nz.ac.auckland.se754.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("nz.ac.auckland.se754.web")
public class CSEdWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CSEdWebApplication.class, args);
	}
}
