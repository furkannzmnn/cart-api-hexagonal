package org.furkan.cartapiapplication.cart.common.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GeneralException extends RuntimeException {
    private final String message;
    private final String code;
    private final int status;
}
