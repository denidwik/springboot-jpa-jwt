package pl.rmitula.authapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignUpRequest {

    private String firstName;

    private String lastName;

    @NotBlank
    @Size(min = 4, max = 40)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email = "denidwiks@gmail.com";

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
}
