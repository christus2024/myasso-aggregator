package fr.it4innov.myasso.association.controller;

import fr.it4innov.myasso.association.client.RestEndpoint.DocumentAssociationEndpoint;
import fr.it4innov.myasso.association.client.dto.DocumentAssociationDTO;
import fr.it4innov.myasso.association.service.DocumentAssociationService;
import fr.it4innov.myasso.association.service.ImportFichierService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@RestController
@RequestMapping("/document")
public class DocumentAssociationController  {

    private final DocumentAssociationService documentAssociationService;
    private final ImportFichierService importFichierService;

    public DocumentAssociationController(DocumentAssociationService documentAssociationService, ImportFichierService importFichierService) {
        this.documentAssociationService = documentAssociationService;
        this.importFichierService = importFichierService;
    }

    @PostMapping( value = "/imports" )
    public ResponseEntity< Void > importFiles( @PathVariable( "category" ) @NotNull final String category,
                                               @PathVariable( "libele" ) @NotNull final String libele,
                                               @PathVariable( "description" ) @NotNull final String description,
                                               @RequestParam(name = "files") MultipartFile[] multipartFile) {
        List<Path> listPath = importFichierService.importFiles( category, multipartFile );
        documentAssociationService.saveDocument(libele, category, description, listPath);

        return ResponseEntity.noContent().build();
    }
    @PostMapping( value = "/import" )
    public ResponseEntity< Void > importFile( @PathVariable( "category" ) @NotNull final String category,
                                               @PathVariable( "libele" ) @NotNull final String libele,
                                               @PathVariable( "description" ) @NotNull final String description,
                                               @RequestParam(name = "files") MultipartFile multipartFile) {

        Path path = importFichierService.importFile( category, multipartFile );
        documentAssociationService.saveOneDocument(libele, category, description, path);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{codeDocument}")
    public ResponseEntity<DocumentAssociationDTO> getOne(@PathVariable String codeDocument){

    return ResponseEntity.ok(documentAssociationService.getOne(codeDocument));
    }
    @GetMapping("/categorie/{categorie}")
    public ResponseEntity<List<DocumentAssociationDTO>> getByCategory(@PathVariable String categorie){

        return ResponseEntity.ok(documentAssociationService.getByCategory(categorie));
    }


    @DeleteMapping("/{codeDocument}")
    public ResponseEntity<Void> deleteAssociation(@PathVariable String codeDocument ){
        documentAssociationService.delete(codeDocument);
        return ResponseEntity.noContent().build();
    }




}
