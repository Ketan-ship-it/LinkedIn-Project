package com.codingShuttle.LinkedIn.posts_service.feignClients;

import com.codingShuttle.LinkedIn.posts_service.DTO.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "connections-service" , path = "/connections")
public interface ConnectionClient {

    @GetMapping("/core/first")
    ResponseEntity<List<PersonDTO>> getFirstDegreeConnections();

}
