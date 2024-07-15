package fr.it4innov.myasso.association.repository;

import fr.it4innov.myasso.association.domaine.DocumentAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@Repository
public interface DocumentAssociationRepository extends JpaRepository<DocumentAssociation, Long > {
    Optional< DocumentAssociation> findOneByCodeDocument( String codeDocument );

    List< DocumentAssociation> findByCategorie( String categorie );
}
