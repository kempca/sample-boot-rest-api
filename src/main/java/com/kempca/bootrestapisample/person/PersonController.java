package com.kempca.bootrestapisample.person;

import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public List<Person> people() {
        return Streamable.of(personRepository.findAll()).toList();
    }

    @GetMapping("/person/search/findByLastName")
    public List<Person> people(@RequestParam String lastName) {
        return personRepository.findByLastName(lastName);
    }

    @GetMapping("/person/{id}")
    public Person personById(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PostMapping("/person")
    public Person newPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

}
