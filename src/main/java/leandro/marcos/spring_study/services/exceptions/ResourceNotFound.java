package leandro.marcos.spring_study.services.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message){
        super(message);
    }

    public ResourceNotFound(){
        super();
    }
}
