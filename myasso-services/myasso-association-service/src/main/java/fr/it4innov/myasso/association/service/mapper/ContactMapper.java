package fr.it4innov.myasso.association.service.mapper;

import fr.it4innov.myasso.association.domaine.Contact;
import fr.it4innov.myasso.association.domaine.dto.ContactDTO;
import org.mapstruct.Mapper;

/**
 * @author Christus TCHASSI
 * @Date 05/06/2024
 */
@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toEntity(ContactDTO contactDTO);
    ContactDTO toDTO(Contact contact);
}

