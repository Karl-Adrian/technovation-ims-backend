package ke.technovation.mycrudapp.validated;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleValidationException(BindException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getFieldErrors().forEach(error ->
                errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());
    }
}

