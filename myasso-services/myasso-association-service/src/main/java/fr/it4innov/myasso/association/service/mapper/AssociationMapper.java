package fr.it4innov.myasso.association.service.mapper;

import fr.it4innov.myasso.association.client.dto.AssociationDTO;
import fr.it4innov.myasso.association.client.dto.CreerAssociationDTO;
import fr.it4innov.myasso.association.domaine.Association;
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
    Association toEntity(CreerAssociationDTO associationDTO);
    List<AssociationDTO> toDtos(List<Association> listAssociation);
    List<Association> toEntities(List<AssociationDTO> listAssociationDTO);

}
