package su.vistar.testtask_netcracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dantonov
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    
    
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message, null, false, false);
    }
    
    

}
