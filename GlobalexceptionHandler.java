package com.example.Student.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalexceptionHandler
{                    //we see custom..
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?>handleCustomExcption(StudentNotFoundException ex)
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>handleGeneralExcption(Exception ex)
    {
        return new ResponseEntity<>("Something went Wrong...!!",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
