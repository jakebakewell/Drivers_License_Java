package com.jb.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jb.license.models.Person;
import com.jb.license.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPeople() {
        return personRepository.findAll();
    }
	
	public Person createPerson(Person p) {
        return personRepository.save(p);
    }
	
	public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
	
	public void deletePerson(Long id) {
    	personRepository.deleteById(id);
    }
	
	public Person findByName(String firstName, String lastName) {
		return personRepository.findPersonByFirstNameAndLastName(firstName, lastName);
	}
}
