package leandro.marcos.spring_study.services.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
    public DatabaseException() {
        super();
    }

}
