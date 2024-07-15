package fr.it4innov.myasso.association.service;

import fr.it4innov.myasso.association.domaine.DocumentAssociation;
import fr.it4innov.myasso.association.domaine.dto.DocumentAssociationDTO;
import fr.it4innov.myasso.association.repository.DocumentAssociationRepository;
import fr.it4innov.myasso.association.service.mapper.DocumentAssociationMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 06/06/2024
 */
@Slf4j
@AllArgsConstructor
@Service
public class DocumentAssociationServiceImpl  implements DocumentAssociationService{

    private final DocumentAssociationRepository documentAssociationRepository;
    private final DocumentAssociationMapper documentAssociationMapper;
    @Override
    public void saveDocument( String libele, String category, String description, List< Path > listPath ) {
        List<DocumentAssociation> listDocument = listPath.stream().map(
                path -> {
                    return DocumentAssociation.builder()
                            .extention( FilenameUtils.getExtension( path.getFileName().toString() ) )
                            .libele( libele )
                            .description( description )
                            .categorie( category )
                            .path( path.toAbsolutePath().toString() )
                            .build();
                }).toList();
        documentAssociationRepository.saveAll( listDocument );

    }

    @Override
    public void saveOneDocument( String libele, String category, String description, Path path ) {
        DocumentAssociation document = DocumentAssociation.builder()
                .extention( FilenameUtils.getExtension( path.getFileName().toString() ) )
                .libele( libele )
                .description( description )
                .categorie( category )
                .path( path.toAbsolutePath().toString() )
                .build();
        documentAssociationRepository.save( document );
    }

    @Override
    public void delete( String codeDocument ) {

    }

    @Override
    public DocumentAssociationDTO getOne(String codeDocument ) {
        return documentAssociationMapper.toDto( documentAssociationRepository.findOneByCodeDocument(codeDocument).orElse(null) );
    }

    @Override
    public List< DocumentAssociationDTO >  getByCategory( String categorie ) {
        return documentAssociationMapper.toDtos(documentAssociationRepository.findByCategorie(categorie)  );
    }
}
