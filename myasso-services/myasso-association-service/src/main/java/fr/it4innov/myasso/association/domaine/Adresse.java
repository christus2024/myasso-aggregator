package fr.it4innov.myasso.association.domaine;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Adresse {

    private String adresse;
    private String codePostal;
    private String ville;
    private String pays;
    private boolean active;
}
