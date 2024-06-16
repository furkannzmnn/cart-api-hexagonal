package org.furkan.cartapiapplication.cart.port.output;

import org.furkan.cartapiapplication.cart.model.Cart;

import java.util.Optional;

public interface CartQueryPort {
    Optional<Cart> getCartById(Long id);
}
