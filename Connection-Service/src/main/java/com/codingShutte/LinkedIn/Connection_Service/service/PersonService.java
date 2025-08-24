package com.codingShutte.LinkedIn.Connection_Service.service;

import com.codingShutte.LinkedIn.Connection_Service.entity.Person;
import com.codingShutte.LinkedIn.Connection_Service.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getFistDegreeConnections(Long userId){
        return personRepository.getFirstDegreeConnections(userId);
    }

}
