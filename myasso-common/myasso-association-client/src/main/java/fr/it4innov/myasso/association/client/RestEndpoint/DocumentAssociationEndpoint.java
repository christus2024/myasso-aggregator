package fr.it4innov.myasso.association.client.RestEndpoint;


import fr.it4innov.myasso.association.client.dto.DocumentAssociationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.service.annotation.PostExchange;


import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 */
@HttpExchange("/document")
public interface DocumentAssociationEndpoint {

    @PostExchange( value = "/imports" )
    public ResponseEntity< Void > importFiles( @PathVariable( "category" ) @NotNull final String category,
                                               @PathVariable( "libele" ) @NotNull final String libele,
                                               @PathVariable( "description" ) @NotNull final String description,
                                               @RequestParam(name = "files") MultipartFile[] multipartFile);
    @PostExchange( value = "/import" )
    public ResponseEntity< Void > importFile( @PathVariable( "category" ) @NotNull final String category,
                                               @PathVariable( "libele" ) @NotNull final String libele,
                                               @PathVariable( "description" ) @NotNull final String description,
                                               @RequestParam(name = "files") MultipartFile multipartFile);

    @GetExchange("/{codeDocument}")
    public ResponseEntity<DocumentAssociationDTO> getOne(@PathVariable String codeDocument);
    @GetExchange("/categorie/{categorie}")
    public ResponseEntity<List<DocumentAssociationDTO>> getByCategory(@PathVariable String categorie);


    @DeleteExchange("/{codeDocument}")
    public ResponseEntity<Void> deleteAssociation(@PathVariable String codeDocument );




}
