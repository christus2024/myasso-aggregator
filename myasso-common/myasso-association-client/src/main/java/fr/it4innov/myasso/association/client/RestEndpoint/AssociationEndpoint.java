package fr.it4innov.myasso.association.client.RestEndpoint;

import fr.it4innov.myasso.association.client.dto.AssociationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;

import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */

@HttpExchange("/association")
public interface AssociationEndpoint {

    @PostExchange
    public ResponseEntity<AssociationDTO>  create(@RequestBody AssociationDTO association );
    @PutExchange
    public ResponseEntity<AssociationDTO>  update( @RequestBody AssociationDTO updateAssociationDTO );

    @GetExchange("/{associationId}")
    public ResponseEntity<AssociationDTO> getOne(@PathVariable Long associationId);

    @GetExchange
    public ResponseEntity< List<AssociationDTO> > getAll();

    @DeleteExchange
    public ResponseEntity<Void> delete(Long associationId);




}
