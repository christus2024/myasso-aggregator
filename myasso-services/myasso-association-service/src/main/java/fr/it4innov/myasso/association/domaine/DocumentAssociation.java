package fr.it4innov.myasso.association.domaine;

import fr.it4innov.myasso.association.config.persistance.AbstractAuditingEntity;
import fr.it4innov.myasso.association.config.persistance.CustomIdEntityListener;
import fr.it4innov.myasso.association.config.persistance.Identifiable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(CustomIdEntityListener.class)
@Entity
public class DocumentAssociation extends AbstractAuditingEntity implements Identifiable {

    @Column(unique = true, nullable = false)
    private String codeDocument;
    private String libele;
    private String description;
    private Long tailleFichier;
    private String extention;
    private LocalDate dateArchivage;
    private String categorie;
    private String path;
    @ManyToOne
    private Association association;

    @Override
    public void setCustomId(String customId) {
        this.codeDocument = customId;
    }

    @Override
    public String getCustomId() {
        return this.codeDocument;
    }
}
