package Customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Globalexceptions{
    @ExceptionHandler(IdnotfoundException.class)
    public ResponseEntity<String> noid(IdnotfoundException idnotfoundException){
        return new ResponseEntity<>(idnotfoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}



