package pl.rmitula.authapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.rmitula.authapp.dto.JwtAuthenticationRequest;
import pl.rmitula.authapp.dto.JwtAuthenticationResponse;
import pl.rmitula.authapp.dto.LoginRequest;
import pl.rmitula.authapp.dto.SignUpRequest;
import pl.rmitula.authapp.service.AuthService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    @ResponseStatus(OK)
    public JwtAuthenticationResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    @ResponseStatus(OK)
    public Long register(@Valid @RequestBody SignUpRequest signUpRequest) {
        System.out.println("username : " + signUpRequest.getUsername());
        return authService.registerUser(signUpRequest);
    }

    @GetMapping("/checkToken")
    @ResponseStatus(OK)
    public Boolean checkToken(@RequestHeader(value = "Authorization") String token){
        return authService.checkToken(token);
    }

}
