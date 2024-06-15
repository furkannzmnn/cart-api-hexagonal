package org.furkan.cartapiinfra.cart.jpa;

import org.furkan.cartapiapplication.cart.model.Cart;
import org.furkan.cartapiinfra.cart.jpa.model.CartEntity;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CartEntity toEntity(Cart card) {
        CartEntity cardEntity = new CartEntity();
        cardEntity.setId(card.getId());

        return cardEntity;
    }

    public Cart toDomain(CartEntity cardEntity) {
        Cart card = new Cart();
        card.setId(cardEntity.getId());
        return card;
    }
}
