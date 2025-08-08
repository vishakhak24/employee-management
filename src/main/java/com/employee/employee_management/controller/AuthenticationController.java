package com.employee.employee_management.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee_management.dto.LoginUserDto;
import com.employee.employee_management.dto.RegisterUserDto;
import com.employee.employee_management.model.LoginResponse;
import com.employee.employee_management.model.User;
import com.employee.employee_management.service.AuthenticationService;
import com.employee.employee_management.service.JwtService;


@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	
	@Autowired
    private JwtService jwtService;
    
	@Autowired
    private AuthenticationService authenticationService;

   
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
