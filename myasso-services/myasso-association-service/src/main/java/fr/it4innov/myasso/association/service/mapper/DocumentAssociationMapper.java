package fr.it4innov.myasso.association.service.mapper;

import fr.it4innov.myasso.association.client.dto.DocumentAssociationDTO;
import fr.it4innov.myasso.association.domaine.DocumentAssociation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 05/06/2024
 */
@Mapper(componentModel = "spring")
public interface DocumentAssociationMapper {
    @Mapping(target = "association", ignore = true)
    DocumentAssociation toEntity(DocumentAssociationDTO documentAssociationDTO);

    @Mapping(target = "associationId", source = "association.id")
    DocumentAssociationDTO toDto( DocumentAssociation documentAssociation);

    List<DocumentAssociationDTO> toDtos( List<DocumentAssociation> listDocumentAssociation);
    List<DocumentAssociation> toEntities( List<DocumentAssociationDTO> listDocumentAssociationDTO);
}

