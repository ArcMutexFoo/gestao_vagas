package br.com.fernandof.gestao_vagas.modules.candidate.controllers;

import br.com.fernandof.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.fernandof.gestao_vagas.modules.candidate.useCases.AuthCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthCandidateController {

    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;

    @PostMapping("/candidates")
    public ResponseEntity<Object> auth(
            @RequestBody AuthCandidateRequestDTO requestDTO
    ) {

        try {
            var token = this.authCandidateUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }


    }
}
