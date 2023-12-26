package by.teachmeskills.lesson37.impl;

import by.teachmeskills.lesson37.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonOne extends Person {

    public PersonOne() {
        super("Bob", "25");
    }
}
