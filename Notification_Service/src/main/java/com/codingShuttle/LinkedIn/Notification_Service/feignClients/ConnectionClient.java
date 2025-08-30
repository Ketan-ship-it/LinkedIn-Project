package com.codingShuttle.LinkedIn.Notification_Service.feignClients;

import com.codingShuttle.LinkedIn.Notification_Service.DTO.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "connections-service" , path = "/connections")
public interface ConnectionClient {

    @GetMapping("/core/first")
    List<PersonDTO> getFirstDegreeConnections(@RequestHeader("X-User-Id") Long userId);

}
