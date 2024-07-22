package fr.it4innov.myasso.association.repository;

import fr.it4innov.myasso.association.domaine.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long > {
}
