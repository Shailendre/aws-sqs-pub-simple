package info.lazycompiler.awssqstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"info.lazycompiler.awssqstest"})
@SpringBootApplication
@EnableScheduling
public class AwsSqsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsTestApplication.class, args);
	}
}
