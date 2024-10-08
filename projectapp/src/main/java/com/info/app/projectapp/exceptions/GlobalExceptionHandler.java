package com.info.app.projectapp.exceptions;

import com.info.app.projectapp.dto.errors.ErrorDtoNotFound;
import com.info.app.projectapp.dto.errors.ErroresDto;
import com.info.app.projectapp.dto.errors.GenericError;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        var errorList = ex.getFieldErrors().stream()
                .map( campoError -> {
                    Map<String, String> errorMap = new HashMap<>();
                    errorMap.put(campoError.getField(), campoError.getDefaultMessage());
                    return errorMap;
                        }
                ).toList();


        GenericError erroresDto = new GenericError(
                "Error en la creacion de la entidad",
                errorList);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erroresDto);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDtoNotFound> handleNoSuchElementException(NoSuchElementException ex, WebRequest webRequest) {

        ErrorDtoNotFound errorDto = new ErrorDtoNotFound(
                webRequest.getDescription(false),
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorDto);
    }

}
