package com.kempca.bootrestapisample.person;

import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public List<Person> all() {
        return  Streamable.of(personRepository.findAll()).toList();
    }

    @GetMapping("/person/{id}")
    public Person one(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PostMapping("/person")
    public Person newPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

}
