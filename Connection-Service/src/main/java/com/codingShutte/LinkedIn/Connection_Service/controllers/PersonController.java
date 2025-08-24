package com.codingShutte.LinkedIn.Connection_Service.controllers;

import com.codingShutte.LinkedIn.Connection_Service.entity.Person;
import com.codingShutte.LinkedIn.Connection_Service.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{userId}/first")
    public ResponseEntity<List<Person>> getFirstDegreeConnections(@PathVariable Long userId){
        List<Person> firstConnections = personService.getFistDegreeConnections(userId);
        return ResponseEntity.ok(firstConnections);
    }

}
