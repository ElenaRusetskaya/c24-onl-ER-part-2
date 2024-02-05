package by.teachmeskills.lesson40;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootRunner {
    public static void main(String[] args) {
        SpringApplication.run(by.teachmeskills.lesson41.SpringBootRunner.class, args);
    }
}
