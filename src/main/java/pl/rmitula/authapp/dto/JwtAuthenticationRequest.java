package pl.rmitula.authapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationRequest {
    public String token;
}
