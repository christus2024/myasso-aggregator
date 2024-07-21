package fr.it4innov.myasso.association.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.SystemProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Christus TCHASSI
 * @Date 06/06/2024
 */
@Slf4j
@Service
public class ImportFichierService {

        @Value("${myasso.doc_path}")
        private String DOC_PATH ;


        /**
         * Importer plusieurs fichers et les stocker dans une store
         * @param sousDossier
         * @param multipartFile fichiers envoyés par l'utilisateur
         */

        public List<Path> importFiles( String sousDossier, MultipartFile[] multipartFile) {
            List<Path> listPath = new ArrayList<>();
            final String lowerCaseSousRepertoire = sousDossier.toLowerCase();
            StringBuilder sb = new StringBuilder();
            Arrays.stream(multipartFile).forEach( fichier -> {
                try {
                    // création du sous-dossier  s'il n'existe pas encore
                    final Path nasPathForCategory = Paths.get( DOC_PATH + lowerCaseSousRepertoire);
                    Files.createDirectories(nasPathForCategory);
                    String fileExtention = FilenameUtils.getExtension( fichier.getName() );
                    String filenameWithoutExt = FilenameUtils.removeExtension( fichier.getName() );
                    String updateFilename = sb.append( filenameWithoutExt ).append( dateToString( new Date() ) ).append( fileExtention ).toString();

                    Path path = Paths.get( DOC_PATH + SystemProperties.FILE_SEPARATOR
                            + lowerCaseSousRepertoire + SystemProperties.FILE_SEPARATOR
                            + updateFilename);
                    listPath.add( path );
                    fichier.transferTo(path);

                } catch ( IOException e) {
                    log.error("Erreur lors de l'import du fichier {} sur dans le sous-dossier {}", fichier.getOriginalFilename(), lowerCaseSousRepertoire);
                    throw new RuntimeException(e);
                }
            });
            return listPath;
        }
    public Path importFile( String sousDossier, MultipartFile multipartFile) {
        final String lowerCaseSousRepertoire = sousDossier.toLowerCase();
        StringBuilder sb = new StringBuilder();
            try {
                // création du sous-dossier  s'il n'existe pas encore
                final Path nasPathForCategory = Paths.get( DOC_PATH + lowerCaseSousRepertoire);
                Files.createDirectories(nasPathForCategory);
                String fileExtention = FilenameUtils.getExtension( multipartFile.getName() );
                String filenameWithoutExt = FilenameUtils.removeExtension( multipartFile.getName() );
                String updateFilename = sb.append( filenameWithoutExt ).append( dateToString( new Date() ) ).append( fileExtention ).toString();
                Path path = Paths.get( DOC_PATH + SystemProperties.FILE_SEPARATOR
                        + lowerCaseSousRepertoire + SystemProperties.FILE_SEPARATOR
                        + updateFilename);
                multipartFile.transferTo(path);
                return path;

            } catch ( IOException e) {
                log.error("Erreur lors de l'import du fichier {} sur dans le sous-dossier {}", multipartFile.getOriginalFilename(), lowerCaseSousRepertoire);
                throw new RuntimeException(e);
            }
        }

        private String dateToString( Date date ){
            String pattern = "yyyyMdd_HHmmss_SSS";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        }



    }


