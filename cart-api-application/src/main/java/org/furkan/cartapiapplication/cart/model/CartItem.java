package org.furkan.cartapiapplication.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    private Long id;
    private Cart cart;
    private Item item;
    private Long quantity;

    public CartItem(Cart cart, Item item, Long quantity) {
        this.cart = cart;
        this.item = item;
        this.quantity = quantity;
    }

}
