package fr.it4innov.myasso.association.repository;

import fr.it4innov.myasso.association.domaine.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long > {

    Optional<Association> findOneByDenomination(String denomination);
}
