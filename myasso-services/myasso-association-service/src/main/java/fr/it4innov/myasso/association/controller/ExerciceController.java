package fr.it4innov.myasso.association.controller;

import fr.it4innov.myasso.association.client.dto.ExerciceDTO;
import fr.it4innov.myasso.association.service.AssociationService;
import fr.it4innov.myasso.association.service.ExerciceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@RestController
@RequestMapping("/exercice")
public class ExerciceController {

    private final AssociationService associationService;
    private final ExerciceService exerciceService;

    public ExerciceController(AssociationService associationService, ExerciceService exerciceService) {
        this.associationService = associationService;
        this.exerciceService = exerciceService;
    }

    @PostMapping
    public ResponseEntity<ExerciceDTO>  create(@RequestBody ExerciceDTO exercice ){

        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( exerciceService.createExercice( exercice ) );
    }
    @PutMapping
    public ResponseEntity<ExerciceDTO>  update( @RequestBody ExerciceDTO updateExerciceDTO ){

        return ResponseEntity.ok(exerciceService.updateAssociation( updateExerciceDTO ));
    }
    @PutMapping("/update/{codeExercice}")
    public ResponseEntity<ExerciceDTO>  update( @PathVariable String codeExercice, @RequestBody ExerciceDTO updateExerciceDTO ){

        return ResponseEntity.ok(exerciceService.updateStatutExercice( codeExercice, updateExerciceDTO ));
    }

    @GetMapping("/{exerciceId}")
    public ResponseEntity<ExerciceDTO> getOne(@PathVariable String codeExercice){

        return ResponseEntity.ok(exerciceService.getExerciceByCodeExercice( codeExercice ));
    }

    @GetMapping
    public ResponseEntity< List<ExerciceDTO> > getAll(){

        return ResponseEntity.ok(exerciceService.getAllAssociation());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(String codeExercice){
        exerciceService.deleteAssociation(codeExercice);
        return ResponseEntity.noContent().build();
    }

}
