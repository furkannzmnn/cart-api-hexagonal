package org.furkan.cartapiapplication.cart.port.input;

import org.furkan.cartapiapplication.cart.model.Cart;

public interface CartQueryUseCase {

    Cart get(Long id);

}
