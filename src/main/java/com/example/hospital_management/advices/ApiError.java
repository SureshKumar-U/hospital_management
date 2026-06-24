package com.example.hospital_management.advices;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter
@Setter
public class ApiError {

    private LocalDateTime localtime;
    private String error;
    private HttpStatus statusCode;

    public ApiError(){
        this.localtime = LocalDateTime.now();
    }

    public ApiError(String error, HttpStatus statusCode){
        this();
        this.error = error;
        this.statusCode = statusCode;
    }
}
