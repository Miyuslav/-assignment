package net.javaguides.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private String id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    private String email;
    @NotEmpty(message = "password should not be empty")
    private String password;
}
