package com.codingShuttle.LinkedIn.Posts_Service.feignClients;

import com.codingShuttle.LinkedIn.Posts_Service.DTO.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "connections-service" , path = "/connections")
public interface ConnectionClient {

    @GetMapping("/core/first")
    ResponseEntity<List<PersonDTO>> getFirstDegreeConnections();

}
