package fr.it4innov.myasso.association.service;

import fr.it4innov.myasso.association.client.dto.ExerciceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Christus
 * @date 23/07/2024
 */
@Service
public class ExerciceServiceImpl implements ExerciceService{
    @Override
    public ExerciceDTO createExercice(ExerciceDTO exercice) {
        return null;
    }

    @Override
    public ExerciceDTO updateAssociation(ExerciceDTO updateExerciceDTO) {
        return null;
    }

    @Override
    public ExerciceDTO getExerciceByCodeExercice(String codeExercice) {
        return null;
    }

    @Override
    public List<ExerciceDTO> getAllAssociation() {
        return null;
    }

    @Override
    public void deleteAssociation(String codeExercice) {

    }

    @Override
    public ExerciceDTO updateStatutExercice(String codeExercice, ExerciceDTO updateExerciceDTO) {
        return null;
    }
}
