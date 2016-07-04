package su.vistar.testtask_netcracker.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import su.vistar.testtask_netcracker.dto.ResponseMessageDto;
import su.vistar.testtask_netcracker.exception.BadRequestException;
import su.vistar.testtask_netcracker.exception.NotFoundException;

/**
 *
 * @author dantonov
 */

@ControllerAdvice
public class ExceptionHandlerController {
    
    
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseMessageDto notFoundException(NotFoundException ex) {
        ResponseMessageDto message = new ResponseMessageDto(ex.getMessage());
        return message;
    }
    
    
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseMessageDto badRequestException(BadRequestException ex) {
        ResponseMessageDto message = new ResponseMessageDto(ex.getMessage());
        return message;
    }

}
