package com.codingShutte.LinkedIn.Connection_Service.controllers;

import com.codingShutte.LinkedIn.Connection_Service.entity.Person;
import com.codingShutte.LinkedIn.Connection_Service.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/first")
    public ResponseEntity<List<Person>> getFirstDegreeConnections(){
        List<Person> firstConnections = personService.getFistDegreeConnections();
        return ResponseEntity.ok(firstConnections);
    }

}
