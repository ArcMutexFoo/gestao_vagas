package br.com.fernandof.gestao_vagas.modules.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record AuthCompanyResponseDTO(
        @JsonProperty("access_token")
        String accessToken,
        @JsonProperty("expires_in")
        Long expiresIn
) {
}
