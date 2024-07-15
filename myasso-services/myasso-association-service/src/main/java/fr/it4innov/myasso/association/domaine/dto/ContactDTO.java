package fr.it4innov.myasso.association.domaine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.URL;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL)
public class ContactDTO {

    private Long id;
    @Email
    private String email;
    private String telephome;
    private String mobile;
    @URL
    private String site;
    private boolean active;

}
