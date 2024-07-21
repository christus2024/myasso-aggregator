package com.example.basespringbootproject.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErrorValidationHandler {

    private String objectName;

    private String fieldName;

    private Object rejectedValue;

    private String message;
}
