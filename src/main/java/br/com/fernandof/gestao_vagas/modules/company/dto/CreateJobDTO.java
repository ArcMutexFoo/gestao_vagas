package br.com.fernandof.gestao_vagas.modules.company.dto;

public record CreateJobDTO(
        String description,
        String benefits,
        String level
) {}
