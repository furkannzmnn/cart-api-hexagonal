package org.furkan.cartapiapplication.cart.port.output;

import org.furkan.cartapiapplication.cart.message.CartCreateCommand;
import org.furkan.cartapiapplication.cart.model.Cart;

public interface CartCommandPort {
    Cart createCart(Cart cart);

    void deleteCart(Long cartId);
}
