package com.kempca.bootrestapisample;

import com.kempca.bootrestapisample.person.Person;
import com.kempca.bootrestapisample.person.PersonRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class InitializeData {

    private PersonRepository personRepository;

    public InitializeData(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void initializeData() {
        personRepository.save(new Person("Bob", "Smith", LocalDate.of(1980, 04, 16)));
    }
}
