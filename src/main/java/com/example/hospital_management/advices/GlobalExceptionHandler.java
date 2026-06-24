package com.example.hospital_management.advices;

import com.example.hospital_management.exceptions.BadRequestException;
import com.example.hospital_management.exceptions.ResouceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResouceNotFoundException exception){
       ApiError apiError  = new ApiError(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
      return  new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException exception){
        ApiError apiError = new ApiError(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
