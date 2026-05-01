package br.com.fernandof.gestao_vagas.modules.candidate.useCases;

import br.com.fernandof.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.fernandof.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID candidatoId) {
        var candidate = candidateRepository.findById(candidatoId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        return new ProfileCandidateResponseDTO(
                candidate.getId(),
                candidate.getName(),
                candidate.getUsername(),
                candidate.getDescription(),
                candidate.getEmail()
        );
    }
}
