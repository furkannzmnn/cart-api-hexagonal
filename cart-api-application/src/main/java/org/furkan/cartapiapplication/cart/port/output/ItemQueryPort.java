package org.furkan.cartapiapplication.cart.port.output;

import org.furkan.cartapiapplication.cart.model.Item;

import java.util.Optional;

public interface ItemQueryPort {
    Optional<Item> get(Long id);
}
