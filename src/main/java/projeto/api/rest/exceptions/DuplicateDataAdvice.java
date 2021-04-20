package projeto.api.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DuplicateDataAdvice {

    @ResponseBody
    @ExceptionHandler(DuplicateDataException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String duplicateDataHandler(DuplicateDataException ex) {
        return ex.getMessage();
    }
}
