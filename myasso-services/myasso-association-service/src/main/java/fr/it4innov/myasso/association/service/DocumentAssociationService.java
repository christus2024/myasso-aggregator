package fr.it4innov.myasso.association.service;

import fr.it4innov.myasso.association.client.dto.DocumentAssociationDTO;

import java.nio.file.Path;
import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 06/06/2024
 */
public interface DocumentAssociationService {

    void saveDocument( String libele, String category, String description, List< Path> listPath );

    void saveOneDocument( String libele, String category, String description, Path path );

    void delete( String codeDocument );

    DocumentAssociationDTO getOne(String codeDocument );

    List<DocumentAssociationDTO> getByCategory( String categorie );
}
