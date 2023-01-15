package com.study.springboothyejin.web.controller.advice;

import com.study.springboothyejin.web.dto.CMRespDto;
import com.study.springboothyejin.web.exception.CustomTestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(CustomTestException.class)
    public ResponseEntity<?> testException(CustomTestException e){
        return ResponseEntity
                .badRequest()
                .body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }
}
