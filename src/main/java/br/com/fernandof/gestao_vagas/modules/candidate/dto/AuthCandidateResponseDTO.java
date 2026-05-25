package br.com.fernandof.gestao_vagas.modules.candidate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Date;

@Builder
public record AuthCandidateResponseDTO(
        @JsonProperty("access_token")
        String AccessToken,

        @JsonProperty("expires_in")
        Long ExpiresIn
) {}
