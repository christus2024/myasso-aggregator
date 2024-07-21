package fr.it4innov.myasso.association.controller;

import fr.it4innov.myasso.association.client.RestEndpoint.AssociationEndpoint;
import fr.it4innov.myasso.association.client.dto.AssociationDTO;
import fr.it4innov.myasso.association.client.dto.CreerAssociationDTO;
import fr.it4innov.myasso.association.service.AssociationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@RestController
@RequestMapping("/association")
public class AssociationController  {

    private final AssociationService associationService;

    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }

    @PostMapping
    public ResponseEntity<AssociationDTO>  create(@RequestBody CreerAssociationDTO nouvelleAssociation ){

        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( associationService.createAssociation( nouvelleAssociation ) );
    }
    @PutMapping
    public ResponseEntity<AssociationDTO>  update( @RequestBody AssociationDTO updateAssociationDTO ){

        return ResponseEntity.ok(associationService.updateAssociation( updateAssociationDTO ));
    }

    @GetMapping("/{associationId}")
    public ResponseEntity<AssociationDTO> getOne(@PathVariable Long associationId){

        return ResponseEntity.ok(associationService.getAssociation( associationId ));
    }

    @GetMapping
    public ResponseEntity< List<AssociationDTO> > getAll(){

        return ResponseEntity.ok(associationService.getAllAssociation());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long associationId){
        associationService.deleteAssociation(associationId);
        return ResponseEntity.noContent().build();
    }




}
