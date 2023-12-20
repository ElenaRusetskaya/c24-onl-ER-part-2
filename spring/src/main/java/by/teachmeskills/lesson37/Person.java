package by.teachmeskills.lesson37;

public class Person {
    private String name;
    private String year;

    public Person(String firstName, String secondName) {
        super();
        this.name = firstName;
        this.year = secondName;
    }
    @Override
    public String toString() {
        return "Person: Name - " + name + ", Year - " + year;
    }
}
