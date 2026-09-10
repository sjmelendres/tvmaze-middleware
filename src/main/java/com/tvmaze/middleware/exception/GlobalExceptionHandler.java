package com.tvmaze.middleware.exception;

import com.tvmaze.middleware.dto.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.http.converter.HttpMessageNotReadableException;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(ConstraintViolationException.class)
        public ApiErrorResponse handleConstraintViolationException(
                ConstraintViolationException exception,
                HttpServletRequest request
        ) {
                String message = exception.getConstraintViolations()
                        .stream()
                        .findFirst()
                        .map(violation -> violation.getMessage())
                        .orElse("La solicitud contiene parámetros inválidos");

                return new ApiErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        message,
                        request.getRequestURI()
                );
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ApiErrorResponse handleMethodArgumentNotValidException(
                MethodArgumentNotValidException exception,
                HttpServletRequest request
        ) {
                String message = exception.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .findFirst()
                        .map(error -> error.getDefaultMessage())
                        .orElse("La solicitud contiene datos inválidos");

                return new ApiErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        message,
                        request.getRequestURI()
                );
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(HttpClientErrorException.NotFound.class)
        public ApiErrorResponse handleNotFound(
                HttpClientErrorException.NotFound exception,
                HttpServletRequest request
        ) {
                return new ApiErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        "El recurso solicitado no fue encontrado",
                        request.getRequestURI()
                );
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MissingServletRequestParameterException.class)
        public ApiErrorResponse handleMissingServletRequestParameter(
                MissingServletRequestParameterException exception,
                HttpServletRequest request
        ) {
                return new ApiErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        "El parámetro '" + exception.getParameterName() + "' es obligatorio",
                        request.getRequestURI()
                );
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ApiErrorResponse handleHttpMessageNotReadable(
                HttpMessageNotReadableException exception,
                HttpServletRequest request
        ) {
                return new ApiErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        "El cuerpo de la solicitud contiene datos con formato inválido. Verifique los tipos de datos enviados",
                        request.getRequestURI()
                );
                }
}