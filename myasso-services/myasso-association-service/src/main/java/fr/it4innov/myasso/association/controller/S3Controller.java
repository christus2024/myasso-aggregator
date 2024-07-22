package fr.it4innov.myasso.association.controller;

import fr.it4innov.myasso.association.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Christus TCHASSI
 * @Date 06/06/2024
 */
@Slf4j
@RestController
@RequestMapping("/api/s3")
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping(path = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE})
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        s3Service.uploadFile(file);
        return "File uploaded";
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity< Resource > downloadFile( @PathVariable String fileName) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(s3Service.getFile(fileName).getObjectContent()));
    }

    @GetMapping("/view/{fileName}")
    public ResponseEntity<InputStreamResource> viewFile(@PathVariable String fileName) {
        var s3Object = s3Service.getFile(fileName);
        var content = s3Object.getObjectContent();
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG) // This content type can change by your file :)
                .header( HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+fileName+"\"")
                .body(new InputStreamResource(content));
    }
}
