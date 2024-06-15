package org.furkan.cartapiinfra.cart.jpa;

import org.furkan.cartapiapplication.cart.model.Cart;
import org.furkan.cartapiapplication.cart.port.output.CartCommandPort;

import java.util.HashMap;
import java.util.Map;

public class CardCommandInMemoryAdapter implements CartCommandPort {

    private final Map<Long, Cart> carts = new HashMap<>();

    @Override
    public Cart createCart(Cart cart) {
        carts.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public void deleteCart(Long cartId) {
        carts.remove(cartId);
    }

}
