package by.teachmeskills.lesson37;

import by.teachmeskills.lesson37.impl.PersonOne;
import by.teachmeskills.lesson37.impl.PersonTwo;
import by.teachmeskills.lesson37.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.security.auth.login.AppConfigurationEntry;

public class SpringApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurationEntry.class);

        PersonService PersonOnePersonService = (PersonService) applicationContext.getBean(PersonOne.class);
        PersonService PersonTwoPersonService = (PersonService) applicationContext.getBean(PersonTwo.class);

        PersonOnePersonService.addPerson("Bob");
        PersonTwoPersonService.addPerson("Ban");
        System.out.println(PersonOnePersonService.getPerson());
        System.out.println(PersonTwoPersonService.getPerson());
    }
}