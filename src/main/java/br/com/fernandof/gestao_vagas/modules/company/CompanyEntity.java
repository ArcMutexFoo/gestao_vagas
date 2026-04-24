package br.com.fernandof.gestao_vagas.modules.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
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
    private String websiteUrl;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
