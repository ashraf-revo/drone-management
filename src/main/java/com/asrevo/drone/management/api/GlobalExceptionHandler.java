package com.asrevo.drone.management.api;

import com.asrevo.drone.management.api.exception.ApiException;
import com.asrevo.drone.management.api.exception.DroneNotLoadedException;
import com.asrevo.drone.management.api.exception.ValidationException;
import com.asrevo.drone.management.domain.DroneStateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ProblemDetail handleApiException(ApiException e) {
        ProblemDetail problemDetail
                = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setDetail(e.getMessage());
        problemDetail.setProperties(Map.of("code", e.getErrorCode().code()));
        return problemDetail;
    }

    @ExceptionHandler(ValidationException.class)
    public ProblemDetail handleValidationException(ValidationException e) {
        ProblemDetail problemDetail
                = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setDetail(e.getMessage());
        problemDetail.setProperties(Map.of("code", e.getErrorCode().code()));
        return problemDetail;
    }

    @ExceptionHandler(DroneStateException.class)
    public ProblemDetail handleDroneStateException(DroneStateException e) {
        ProblemDetail problemDetail
                = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setDetail(e.getMessage());
        problemDetail.setProperties(Map.of("code", e.getErrorCode().code()));
        return problemDetail;
    }

    @ExceptionHandler(DroneNotLoadedException.class)
    public ProblemDetail handleDroneNotLoadedException(DroneNotLoadedException e) {
        ProblemDetail problemDetail
                = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setDetail(e.getMessage());
        problemDetail.setProperties(Map.of("code", e.getErrorCode().code()));
        return problemDetail;
    }
}