package fr.it4innov.myasso.association.domaine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.it4innov.myasso.association.domaine.Langue;
import fr.it4innov.myasso.association.domaine.Monaie;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL)
public class AssociationDTO {

    private Long id;
    @NotNull
    private String codeAssociation;
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
    private Langue langue = Langue.FRANCAIS;
    @Builder.Default
    private Monaie monaie = Monaie.EURO;
    private String presentation;
    private String siegeSocial;
    private boolean isActif;
    @Builder.Default
    private List<AdresseDTO> listAdresse = new ArrayList<>();
    @Builder.Default
    private List<ContactDTO> listContact = new ArrayList<>();

    private List< DocumentAssociationDTO > listDocumentAssociation;
    private  List<ExerciceDTO> listExercice;
}
