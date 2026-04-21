package br.com.fernandof.gestao_vagas.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    // regex to validate no spaces
    @Pattern(regexp = "^(?!\\s*$).+", message = "the [username] field must not contain spaces")
    private String username;

    @Email(message = "the field [email] is required")
    private String email;

    @Length(
            min = 8,
            max = 25,
            message = "the [password] field must be between 8 and 25 characters long"
    )
    private String password;
    private String description;
    private String curriculum;
}
