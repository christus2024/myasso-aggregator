package fr.it4innov.myasso.association.exception;

/**
 * @author Christus TCHASSI
 * @Date 04/06/2024
 */
public class DataAlreadyExistException extends RuntimeException {
    public DataAlreadyExistException( String message ) {
        super(message);
    }
}
