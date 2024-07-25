package fr.it4innov.myasso.association.domaine;

import fr.it4innov.myasso.association.client.dto.StatutExercice;
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
public class Exercice extends AbstractAuditingEntity implements Identifiable {

    @Column(unique = true, nullable = false, updatable = false)
    private String codeExercice;
    private String libele;
    private String observation;
    private LocalDate dateDebut;
    private String dateFin;
    @Enumerated( EnumType.STRING)
    private StatutExercice statutExercice;
    @ManyToOne
    private Association association;

    @Override
    public void setCustomId(String customId) {
        this.codeExercice = customId;
    }

    @Override
    public String getCustomId() {
        return this.codeExercice;
    }
}
