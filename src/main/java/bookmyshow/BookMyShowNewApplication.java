package bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication

public class BookMyShowNewApplication extends SpringBootServletInitializer {
	//This constructor has been added to resolve broken pipe issue.

	public static void main(String[] args) {

		SpringApplication.run(BookMyShowNewApplication.class, args);
	}


}
