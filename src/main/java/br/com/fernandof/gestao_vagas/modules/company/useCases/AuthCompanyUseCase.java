package br.com.fernandof.gestao_vagas.modules.company.useCases;

import br.com.fernandof.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.fernandof.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = companyRepository.findByUsername(authCompanyDTO.username()).orElseThrow(() -> {
            throw new UsernameNotFoundException("company not found");
        });

        var passwordMatches = passwordEncoder.matches(authCompanyDTO.password(), company.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }
    }
}
