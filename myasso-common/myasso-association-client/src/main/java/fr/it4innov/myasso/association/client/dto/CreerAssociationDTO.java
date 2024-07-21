package fr.it4innov.myasso.association.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class CreerAssociationDTO {
    @NotNull
    private String denomination ;
    @NotNull(message = "l'identifiant du super admin de l'association doit etre renseigné")
    private String codeSuperAdmin;
}
