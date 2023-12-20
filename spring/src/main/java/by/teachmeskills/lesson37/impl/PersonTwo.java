package by.teachmeskills.lesson37.impl;

import by.teachmeskills.lesson37.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonTwo extends Person {

    public PersonTwo() {
        super("John", "26");
    }
}
