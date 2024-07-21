package fr.it4innov.myasso.association.service;
import fr.it4innov.myasso.association.client.dto.AssociationDTO;
import fr.it4innov.myasso.association.client.dto.CreerAssociationDTO;
import fr.it4innov.myasso.association.domaine.Association;
import fr.it4innov.myasso.association.exception.DataAlreadyExistException;
import fr.it4innov.myasso.association.exception.DataNotFoundException;
import fr.it4innov.myasso.association.repository.AssociationRepository;
import fr.it4innov.myasso.association.service.mapper.AssociationMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class AssociationServiceImpl implements AssociationService{

    private final AssociationRepository associationRepository;
    private final AssociationMapper associationMapper;

    @Override
    public AssociationDTO createAssociation(CreerAssociationDTO associationDTO ) {
        //verifier si l'association existe
        if ( associationRepository.findOneByDenomination(associationDTO.getDenomination()).isPresent())
            throw new DataAlreadyExistException("L'association existe deja");
        Association association = associationMapper.toEntity(associationDTO);
        return associationMapper.toDto(associationRepository.save(association));
    }

    @Override
    public AssociationDTO updateAssociation( AssociationDTO updateAssociationDTO ) {
        if ( updateAssociationDTO.getId() == null )
            throw new DataNotFoundException("L'id de l'association est manquant");
        Association association = associationMapper.toEntity(updateAssociationDTO);
        return associationMapper.toDto(associationRepository.save(association));
    }

    @Override
    public AssociationDTO getAssociation( Long associationId ) {
        Optional<Association> optionalAssociation = associationRepository.findById( associationId );

        return associationMapper.toDto( optionalAssociation.orElse( null ) );
    }

    @Override
    public List<AssociationDTO> getAllAssociation() {

        return associationRepository.findAll().stream()
                .map( associationMapper::toDto )
                .collect( Collectors.toList());
    }

    @Override
    public void deleteAssociation(Long associationId) {
        associationRepository.deleteById( associationId );

    }
}
