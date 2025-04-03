package leandro.marcos.spring_study.resources.exceptions;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import leandro.marcos.spring_study.services.exceptions.ResourceNotFound;
import leandro.marcos.spring_study.services.exceptions.StandartError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionListener {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFound ex, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError error = new StandartError();
        error.setStatus(status.value());
        error.setMessage(ex.getMessage());
        error.setError("Resource not found");
        error.setTimestamp(Instant.now());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
