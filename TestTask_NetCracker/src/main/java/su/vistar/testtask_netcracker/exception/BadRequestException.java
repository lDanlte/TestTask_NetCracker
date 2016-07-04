package su.vistar.testtask_netcracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dantonov
 */


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    
    
    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message, null, false, false);
    }

    
    
}
