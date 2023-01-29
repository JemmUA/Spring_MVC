package ua.jemm.webMVC.dao;

import org.springframework.stereotype.Component;
import ua.jemm.webMVC.model.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private int personId;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++personId, "Alex"));
        people.add(new Person(++personId, "Den"));
        people.add(new Person(++personId, "Helen"));
        people.add(new Person(++personId, "Andrew"));
        people.add(new Person(++personId, "Bob"));
    }

    public List<Person> getAll() {
        return people;
    }

    public Person getBiId(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++personId);
        people.add(person);

    }
}
