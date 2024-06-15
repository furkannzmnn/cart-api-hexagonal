package org.furkan.cartapiapplication.cart.port.input;

import org.furkan.cartapiapplication.cart.message.CartCreateCommand;

public interface CartCreateUseCase {
    void addItemToCart(CartCreateCommand command);

    void clearCart(Long cartId);
}
