package pl.rmitula.authapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String userName;

    public JwtAuthenticationResponse(String accessToken, String userName) {
        this.accessToken = accessToken; this.userName = userName;
    }
}
