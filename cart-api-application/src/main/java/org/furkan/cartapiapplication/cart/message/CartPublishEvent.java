package org.furkan.cartapiapplication.cart.message;

import org.furkan.cartapiapplication.DomainEvent;
import org.furkan.cartapiapplication.cart.model.Cart;

import lombok.Getter;

@Getter
public class CartPublishEvent extends DomainEvent {
    
    private final String cartId;
    private final String eventType;

    public CartPublishEvent(String cartId, String eventType) {
        this.cartId = cartId;
        this.eventType = eventType;
    }

    public static CartPublishEvent of(Cart cart) {
        return new CartPublishEvent(cart.getUserId().toString(), "CartPublishEvent");
    }

}
