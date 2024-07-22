package fr.it4innov.myasso.association.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Christus
 * @date 20/07/2024
 */
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseError {
    private String apiPath;
    private String errorCode;
    private HttpStatus httpStatus;
    private String message;
    private Map<String,String> errorsValidation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime errorTime;

}
