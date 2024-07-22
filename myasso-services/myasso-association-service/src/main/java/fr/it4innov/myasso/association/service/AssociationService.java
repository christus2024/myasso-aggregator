package fr.it4innov.myasso.association.service;

import fr.it4innov.myasso.association.client.dto.AssociationDTO;
import fr.it4innov.myasso.association.client.dto.CreerAssociationDTO;

import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
public interface AssociationService {

    public AssociationDTO createAssociation(CreerAssociationDTO association );

    public AssociationDTO updateAssociation( AssociationDTO updateAssociationDTO );

    public AssociationDTO getAssociation(Long associationId );

    public List<AssociationDTO> getAllAssociation();

    public void deleteAssociation(Long associationId);

}
