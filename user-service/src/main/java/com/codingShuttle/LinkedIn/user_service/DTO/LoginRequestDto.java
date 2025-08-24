package com.codingShuttle.LinkedIn.user_service.DTO;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
