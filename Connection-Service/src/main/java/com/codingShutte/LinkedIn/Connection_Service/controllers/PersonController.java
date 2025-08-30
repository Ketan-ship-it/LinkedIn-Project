package com.codingShutte.LinkedIn.Connection_Service.controllers;

import com.codingShutte.LinkedIn.Connection_Service.DTO.PersonDTO;
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
    public List<PersonDTO> getFirstDegreeConnections(){
        return personService.getFistDegreeConnections();
    }

    @PostMapping("/request/{userId}")
    public ResponseEntity<Boolean> sendConnectionRequest(@PathVariable Long userId) {
        return ResponseEntity.ok(personService.sendConnectionRequest(userId));
    }

    @PostMapping("/accept/{userId}")
    public ResponseEntity<Boolean> acceptConnectionRequest(@PathVariable Long userId) {
        return ResponseEntity.ok(personService.acceptConnectionRequest(userId));
    }

    @PostMapping("/reject/{userId}")
    public ResponseEntity<Boolean> rejectConnectionRequest(@PathVariable Long userId) {
        return ResponseEntity.ok(personService.rejectConnectionRequest(userId));
    }

}
