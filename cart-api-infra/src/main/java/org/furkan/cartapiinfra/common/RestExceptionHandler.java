package org.furkan.cartapiinfra.common;

import org.furkan.cartapiapplication.cart.common.exception.GeneralException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public ProblemDetail handleGeneralException(GeneralException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(e.getStatus()), e.getMessage());
    }
}
