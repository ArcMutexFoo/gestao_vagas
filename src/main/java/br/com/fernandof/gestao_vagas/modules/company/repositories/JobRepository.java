package br.com.fernandof.gestao_vagas.modules.company.repositories;

import br.com.fernandof.gestao_vagas.modules.company.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository
        extends JpaRepository<JobEntity, UUID> {
}
