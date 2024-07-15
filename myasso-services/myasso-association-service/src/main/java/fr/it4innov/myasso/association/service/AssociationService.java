package fr.it4innov.myasso.association.service;

import fr.it4innov.myasso.association.domaine.dto.AssociationDTO;

import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
public interface AssociationService {

    public AssociationDTO createAssociation(AssociationDTO association );

    public AssociationDTO updateAssociation( AssociationDTO updateAssociationDTO );

    public AssociationDTO getAssociation(Long associationId );

    public List<AssociationDTO> getAllAssociation();

    public void deleteAssociation(Long associationId);

}
