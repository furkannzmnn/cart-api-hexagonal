package org.furkan.cartapiapplication.cart.port.input;

public interface MessageUseCase<T> {
    void publish(T event);
}
