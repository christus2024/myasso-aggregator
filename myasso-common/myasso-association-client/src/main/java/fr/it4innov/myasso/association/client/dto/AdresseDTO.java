package fr.it4innov.myasso.association.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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
public class AdresseDTO {

    private Long id;
    private String adresse;
    private String codePostal;
    private String ville;
    private String pays;
    private boolean active;
}
