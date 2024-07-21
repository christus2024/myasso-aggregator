package fr.it4innov.myasso.association.domaine;

import fr.it4innov.myasso.association.client.dto.Langue;
import fr.it4innov.myasso.association.client.dto.Monaie;
import fr.it4innov.myasso.association.config.persistance.AbstractAuditingEntity;
import fr.it4innov.myasso.association.config.persistance.CustomIdEntityListener;
import fr.it4innov.myasso.association.config.persistance.Identifiable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@Slf4j
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(CustomIdEntityListener.class)
@DynamicUpdate
@SoftDelete(columnName = "deleted")
//@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class Association extends AbstractAuditingEntity implements Identifiable {

    @Column(unique = true, nullable = false, updatable = false)
    private String codeAssociation;
    @NotNull
    private String codeSuperAdmin;
    @NotNull
    private String denomination ;
    private String slogan;
    private String logoPath;

    private String reglementPath;
    private String statutPath;
    private String description;
    @Builder.Default
    private LocalDate dateCreation = LocalDate.now();
    private String fuseauHoraire;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Langue langue = Langue.FRANCAIS;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Monaie monaie = Monaie.EURO;

    private String presentation;
    private String siegeSocial;
    private boolean isActif;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "association_adresses",
            joinColumns = @JoinColumn(name = "association_id")
    )
    private List<Adresse> listAdresse;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "association_contacts",
            joinColumns = @JoinColumn(name = "association_id")
    )
    private List<Contact> listContact;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "association")
    private List<DocumentAssociation> listDocumentAssociation;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "association")
    private  List<Exercice> listExercice;

    /*@Column(insertable=false)
    private boolean deleted ;*/

    @Override
    public void setCustomId(String customId) {
        this.codeAssociation = customId;
    }

    @Override
    public String getCustomId() {
        return this.codeAssociation;
    }
}
