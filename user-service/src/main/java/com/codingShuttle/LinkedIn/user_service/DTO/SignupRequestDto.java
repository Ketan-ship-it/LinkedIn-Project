package com.codingShuttle.LinkedIn.user_service.DTO;

import lombok.Data;

@Data
public class SignupRequestDto {
    private String name;
    private String email;
    private String password;
}
