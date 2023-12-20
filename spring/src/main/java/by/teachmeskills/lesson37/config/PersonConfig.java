package by.teachmeskills.lesson37.config;

import by.teachmeskills.lesson37.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PersonConfig {
    @Bean
    public Person personOne() {
        return new Person("Bob", "25");
    }
    @Bean
    public Person personTwo() {
        return new Person("Ban", "26");
    }
}
