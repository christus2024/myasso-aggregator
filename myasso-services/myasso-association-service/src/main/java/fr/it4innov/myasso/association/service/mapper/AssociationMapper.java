package fr.it4innov.myasso.association.service.mapper;

import fr.it4innov.myasso.association.domaine.Association;
import fr.it4innov.myasso.association.domaine.dto.AssociationDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 04/06/2024
 */
@Mapper( componentModel = "spring", uses = {AdresseMapper.class, ContactMapper.class, ExerciceMapper.class})
public interface AssociationMapper {

    AssociationDTO toDto(Association association);
    Association toEntity(AssociationDTO associationDTO);
    List<AssociationDTO> toDtos(List<Association> listAssociation);
    List<Association> toEntities(List<AssociationDTO> listAssociationDTO);

}
