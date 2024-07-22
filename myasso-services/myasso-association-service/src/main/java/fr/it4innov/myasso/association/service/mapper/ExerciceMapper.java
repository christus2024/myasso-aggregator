package fr.it4innov.myasso.association.service.mapper;

import fr.it4innov.myasso.association.client.dto.ExerciceDTO;
import fr.it4innov.myasso.association.domaine.Exercice;
import org.mapstruct.Mapper;

/**
 * @author Christus TCHASSI
 * @Date 05/06/2024
 */
@Mapper(componentModel = "spring")
public interface ExerciceMapper {
    //@Mapping(target = "association", ignore = true)
    Exercice toEntity(ExerciceDTO exerciceDTO);
    //@Mapping(target = "associationId", source = "association.id")
    ExerciceDTO toDTO(Exercice exercice);
}

