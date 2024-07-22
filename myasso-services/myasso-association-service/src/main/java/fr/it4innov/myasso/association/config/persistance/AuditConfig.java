package fr.it4innov.myasso.association.config.persistance;

/**
 * @author Christus
 * @date 15/07/2024
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef ="auditorAwareImpl")
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorAwareImpl() {
        return new AuditorAwareImpl();
    }

    /**
     * Cette classe permet de recuperer l'utilisateur courant qui va effectuer
     * une operation sur une entité. Elle est utilisée par la classe AuditingEntityListener
     * pour setter les attributs createdBy et lastModifiedBy
     */
    public  class AuditorAwareImpl implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor() {
            // Retourner l'utilisateur actuel (ex. : à partir de Spring Security)
            return Optional.of("ACCOUNT_MS");
        }
    }
}

