package fr.it4innov.myasso.association.service.mapper;


import fr.it4innov.myasso.association.domaine.Adresse;
import fr.it4innov.myasso.association.domaine.dto.AdresseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 05/06/2024
 */
@Mapper(componentModel = "spring")
public interface AdresseMapper {
    @Mapping( target = "adresse", source = "adresseDTO.adresse")
    Adresse toEntity(AdresseDTO adresseDTO);
    @Mapping( target = "adresse", source = "adresse.adresse")
    AdresseDTO toDTO(Adresse adresse);

    List<AdresseDTO> toDtos(List<Adresse> listAdresse );
    List<Adresse> toEntities(List<AdresseDTO> listAdresseDTO );
}

