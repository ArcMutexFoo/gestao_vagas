package br.com.fernandof.gestao_vagas.modules.candidate.dto;

import lombok.Builder;

@Builder
public record AuthCandidateResponseDTO(String AccessToken) {
}
