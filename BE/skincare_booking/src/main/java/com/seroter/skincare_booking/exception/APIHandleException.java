package com.seroter.skincare_booking.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice   //Đánh dấu đây là 1 class để bắt lỗi
public class APIHandleException {

    // Canh bắt lỗi cho mình
    // MethodArgumentNotValidException => lỗi do thư viện quăng ra

    // nếu gặp lỗi MethodArgumentNotValidException => hàm này sẽ được chạy

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleDuplicate(MethodArgumentNotValidException exception){
        String message = "";

            for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
                message += fieldError.getDefaultMessage() + "\n";
            }
           return new ResponseEntity("Duplicate", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handleDuplicate(SQLIntegrityConstraintViolationException exception){
        return new ResponseEntity("Duplicate", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleNullPointer(NullPointerException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
