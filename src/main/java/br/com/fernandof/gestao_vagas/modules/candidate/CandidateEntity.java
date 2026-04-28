package br.com.fernandof.gestao_vagas.modules.candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    // regex to validate no spaces
    @Pattern(regexp = "\\S+", message = "the [username] field must not contain spaces")
    @NotBlank
    private String username;

    @Email(message = "the field [email] must be valid")
    private String email;

    @Length(
            min = 8,
            message = "the [password] field must be at least 8 characters long"
    )
    @Length(
            max = 255,
            message = "the [password] field must be less than 25 characters long"
    )
    private String password;
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
