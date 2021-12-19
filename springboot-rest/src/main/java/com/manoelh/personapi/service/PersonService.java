package com.manoelh.personapi.service;

import com.manoelh.personapi.dto.MessageResponseDTO;
import com.manoelh.personapi.dto.PersonDTO;
import com.manoelh.personapi.entity.Person;
import com.manoelh.personapi.exception.personNotFoundException;
import com.manoelh.personapi.mapper.PersonMapper;
import com.manoelh.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        personMapper = PersonMapper.INTANCE;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = this.personRepository.save(personToSave);

        return createMessageResponse(savedPerson.getId(), "The person was saved with ID: ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = this.personRepository.findAll();
        return allPeople.stream().map (personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findOnePerson(Long id) throws personNotFoundException {
        Person person = verifyIfPersonExists(id);

        return personMapper.toDTO(person);
    }

    public void deletePerson(Long id) throws personNotFoundException {
        verifyIfPersonExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updatePerson(Long id, PersonDTO personDTO) throws personNotFoundException {
        verifyIfPersonExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = this.personRepository.save(personToUpdate);

        return createMessageResponse(updatedPerson.getId(), "The person was updated with ID: ");
    }

    private Person verifyIfPersonExists(Long id) throws personNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new personNotFoundException(id) );
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder().message(message +id)
                .build();
    }
}
