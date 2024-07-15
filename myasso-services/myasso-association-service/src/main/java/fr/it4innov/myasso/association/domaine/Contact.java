package fr.it4innov.myasso.association.domaine;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.URL;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@Embeddable
public class Contact {
    @Email
    private String email;
    private String telephome;
    private String mobile;
    @URL
    private String site;
    private boolean active;
}
