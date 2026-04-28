package br.com.fernandof.gestao_vagas.modules.candidate.useCases;

import br.com.fernandof.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.fernandof.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.fernandof.gestao_vagas.modules.candidate.dto.AuthCandidateResponseDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthCandidateUseCase {

    @Value("${security.token.secret.candidate}")
    private String secret;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(
            AuthCandidateRequestDTO authCandidateRequestDTO
    ) throws AuthenticationException {
        var candidate = candidateRepository.findByUsername(
                authCandidateRequestDTO.username()
        ).orElseThrow(() -> new UsernameNotFoundException("username/password incorrect"));

        var passwordMatches = passwordEncoder.matches(
                authCandidateRequestDTO.password(),
                candidate.getPassword()
        );

        if (!passwordMatches) {
            throw new AuthenticationException();
        }


        var algorythm = Algorithm.HMAC256(secret);
        var token = JWT.create()
                .withIssuer("gestao_vagas")
                .withClaim("roles", List.of("candidate"))
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(candidate.getId().toString())
                .sign(algorythm);

        return new AuthCandidateResponseDTO(token);
    }
}
