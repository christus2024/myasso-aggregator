package fr.it4innov.myasso.association.service;

import fr.it4innov.myasso.association.client.dto.ExerciceDTO;

import java.util.List;

public interface ExerciceService {

    ExerciceDTO createExercice(ExerciceDTO exercice);

    ExerciceDTO updateAssociation(ExerciceDTO updateExerciceDTO);

    ExerciceDTO getExerciceByCodeExercice(String codeExercice);

    List<ExerciceDTO> getAllAssociation();

    void deleteAssociation(String codeExercice);

    ExerciceDTO updateStatutExercice(String codeExercice, ExerciceDTO updateExerciceDTO);
}
