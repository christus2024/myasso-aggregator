package fr.it4innov.myasso.association.client.RestEndpoint;

import fr.it4innov.myasso.association.client.dto.ExerciceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;

import java.util.List;

/**
 * @author Christus
 * @date 21/07/2024
 */
@HttpExchange("exercice")
public interface ExerciceEndpoint {

    @PostExchange
    public ResponseEntity<ExerciceDTO> create(@RequestBody ExerciceDTO exercice);
    @PutExchange
    public ResponseEntity<ExerciceDTO> update(@RequestBody ExerciceDTO updateExerciceDTO);
    @PutExchange("/update/{codeExercice}")
    public ResponseEntity<ExerciceDTO> update(@PathVariable String codeExercice, @RequestBody ExerciceDTO updateExerciceDTO);

    @GetExchange("/{exerciceId}")
    public ResponseEntity<ExerciceDTO> getOne(@PathVariable String codeExercice);

    @GetExchange
    public ResponseEntity<List<ExerciceDTO>> getAll();

    @DeleteExchange
    public ResponseEntity<Void> delete(String codeExercice);
}
