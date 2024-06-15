package org.furkan.cartapiapplication.cart.message;

import lombok.Getter;
import org.furkan.cartapiapplication.cart.DomainEvent;
import org.furkan.cartapiapplication.cart.model.Cart;

@Getter
public class CartPublishEvent extends DomainEvent {
    private final String cartId;
    private final String eventType;

    public CartPublishEvent(String cartId, String eventType) {
        this.cartId = cartId;
        this.eventType = eventType;
    }

    public static CartPublishEvent of(Cart cart) {
        return new CartPublishEvent(cart.getId().toString(), "CartPublishEvent");
    }

}
