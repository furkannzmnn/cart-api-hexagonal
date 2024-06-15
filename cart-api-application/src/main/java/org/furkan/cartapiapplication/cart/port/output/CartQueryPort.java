package org.furkan.cartapiapplication.cart.port.output;

import org.furkan.cartapiapplication.cart.model.Cart;

public interface CartQueryPort {
    Cart getCartById(Long id);
}
