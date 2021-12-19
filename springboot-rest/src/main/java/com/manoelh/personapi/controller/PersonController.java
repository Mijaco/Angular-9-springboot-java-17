package com.manoelh.personapi.controller;

import com.manoelh.personapi.dto.MessageResponseDTO;
import com.manoelh.personapi.dto.PersonDTO;
import com.manoelh.personapi.exception.personNotFoundException;
import com.manoelh.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/people")

public class
PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
        return this.personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAllPeople() {
        return this.personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findOnePerson(@PathVariable Long id) throws personNotFoundException {
        return this.personService.findOnePerson(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) throws personNotFoundException {
        this.personService.deletePerson(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws personNotFoundException {
        return this.personService.updatePerson(id, personDTO);
    }
}
