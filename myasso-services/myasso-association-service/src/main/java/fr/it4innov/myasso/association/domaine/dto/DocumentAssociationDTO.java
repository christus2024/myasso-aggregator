package fr.it4innov.myasso.association.domaine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class DocumentAssociationDTO {

    private Long id;
    private String codeDocument;
    private String libele;
    private String description;
    private Long tailleFichier;
    private String extention;
    private LocalDate dateArchivage;
    private String categorie;
    private String path;
    private Long associationId;


}
