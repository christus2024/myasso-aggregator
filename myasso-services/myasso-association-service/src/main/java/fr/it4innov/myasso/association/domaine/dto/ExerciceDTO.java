package fr.it4innov.myasso.association.domaine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.it4innov.myasso.association.domaine.StatutExercice;
import lombok.*;

import java.time.LocalDate;

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
public class ExerciceDTO  {

    private Long id;
    private String libele;
    private String observation;
    @Builder.Default
    private LocalDate dateDebut = LocalDate.now();
    private String dateFin;
    @Builder.Default
    private StatutExercice statutExercice = StatutExercice.OUVERT;
    private Long associationId;
}
