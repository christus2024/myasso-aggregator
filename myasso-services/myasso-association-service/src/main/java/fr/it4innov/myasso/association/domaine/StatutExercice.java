package fr.it4innov.myasso.association.domaine;

import lombok.Getter;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
public enum StatutExercice {
    OUVERT("ouvert", "ExerciceDTO en cours"),
    FERME("fermé", "ExerciceDTO en cloturé");

    @Getter
    private  final String valeur;
    @Getter
    private final String description;


    StatutExercice( String valeur, String description ) {
        this.valeur = valeur;
        this.description = description;
    }
}
