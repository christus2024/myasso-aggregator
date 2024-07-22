package fr.it4innov.myasso.association.exception;

import lombok.Getter;

public enum BussinessStatusErrorCode {
    DataAlreadyExistException("404", "ezezeze"),
    DataNotFoundException("405", "ezezeze");

    @Getter
    private String errorCode;

    @Getter
    private String errorMessage;
    BussinessStatusErrorCode(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
