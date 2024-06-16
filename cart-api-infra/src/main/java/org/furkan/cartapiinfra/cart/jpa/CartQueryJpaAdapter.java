package org.furkan.cartapiinfra.cart.jpa;

import org.furkan.cartapiapplication.cart.model.Cart;
import org.furkan.cartapiapplication.cart.port.output.CartQueryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CartQueryJpaAdapter implements CartQueryPort {

    @Override
    public Optional<Cart> getCartById(Long id) {
        return Optional.empty();
    }
}
