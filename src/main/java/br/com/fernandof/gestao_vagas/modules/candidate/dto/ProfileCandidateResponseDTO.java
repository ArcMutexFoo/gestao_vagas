package br.com.fernandof.gestao_vagas.modules.candidate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
public record ProfileCandidateResponseDTO(
        UUID id,
        String name,
        String username,
        String description,
        String email
) {
}
