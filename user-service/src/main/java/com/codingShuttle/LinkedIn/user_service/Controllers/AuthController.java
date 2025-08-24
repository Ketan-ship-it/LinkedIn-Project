package com.codingShuttle.LinkedIn.user_service.Controllers;

import com.codingShuttle.LinkedIn.user_service.DTO.LoginRequestDto;
import com.codingShuttle.LinkedIn.user_service.DTO.SignupRequestDto;
import com.codingShuttle.LinkedIn.user_service.DTO.UserDto;
import com.codingShuttle.LinkedIn.user_service.Services.AuthService;
import com.codingShuttle.LinkedIn.user_service.advice.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignupRequestDto signupRequestDto){
        UserDto userDto = authService.signUp(signupRequestDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> logIn(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(new ApiResponse<>(authService.login(loginRequestDto)));
    }

}
