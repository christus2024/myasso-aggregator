package fr.it4innov.myasso.association.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import fr.it4innov.myasso.myassoutils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * @author Christus TCHASSI
 * @Date 06/06/2024
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class S3Service {
    private final AmazonS3 s3client;

    @Value("${aws.s3.bucket}")
    private String bucketName;


    public String uploadFile(MultipartFile file)  {
        StringBuilder stringBuilder = new StringBuilder();
        var fileExtention= StringUtils.getFilenameExtension( file.getOriginalFilename() );
        String filenameWithoutExt = FilenameUtils.removeExtension( file.getName() );
        String updateFilename = stringBuilder.append( filenameWithoutExt ).append( DateUtils.dateToString( new Date() ) ).append( fileExtention ).toString();

        var metadata = new ObjectMetadata();
        metadata.setContentType( fileExtention );
        metadata.setContentType( file.getContentType() );
        metadata.setContentLength( file.getSize() );

        PutObjectResult putObjectResult = null;
        try {
            putObjectResult = s3client.putObject(bucketName, updateFilename, file.getInputStream(), metadata);
            log.info( String.valueOf( putObjectResult.getMetadata() ) );
        } catch ( IOException e ) {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors du telechargement du fichier" , e);
        }
        return updateFilename;

    }
    public URL getUrl( String filename){
        return s3client.getUrl( bucketName, filename );
    }

    public S3Object getFile( String filename) {
        return s3client.getObject(bucketName, filename);
    }
}
