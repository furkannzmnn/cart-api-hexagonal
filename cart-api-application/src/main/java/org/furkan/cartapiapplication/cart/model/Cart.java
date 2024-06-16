package org.furkan.cartapiapplication.cart.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.furkan.cartapiapplication.cart.AggregateRoot;
import org.furkan.cartapiapplication.cart.message.CartCreateCommand;
import org.furkan.cartapiapplication.cart.message.CartPublishEvent;
import org.furkan.cartapiapplication.cart.service.CartItemRules;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Cart extends AggregateRoot {

    private Long id;
    private BigDecimal totalPrice;
    private Long userId;
    private List<CartItem> cartItems = new ArrayList<>();
    private Promotion promotion;

    public Cart addItem(Item item, Long quantity) {
        CartItem existingCartItem = findCartItemByItemId(item.getId());
        if (existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
        } else {
            CartItem newCartItem = new CartItem(this, item, quantity);
            cartItems.add(newCartItem);
        }

        return this;
    }

    public boolean isPromotionApplied() {
        return promotion != null;
    }

    public boolean isTotalPriceExceedsLimit(BigDecimal price) {
        return totalPrice.add(price).compareTo(BigDecimal.valueOf(500000)) > 0;
    }

    private CartItem findCartItemByItemId(Long itemId) {
        for (CartItem cartItem : cartItems) {
            return new CartItem();
        }
        return null;
    }


    public void runValidationRules(CartCreateCommand command) {
      //  new CartItemRules(command, this).applyRules();
        registerEvent(CartPublishEvent.of(this));
    }

    public void registerEvent(CartPublishEvent event) {
        this.registerMessage(event);
    }

    public void publishEvent() {
        this.publish();
    }
}
