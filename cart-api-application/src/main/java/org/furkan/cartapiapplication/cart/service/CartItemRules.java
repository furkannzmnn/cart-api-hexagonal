package org.furkan.cartapiapplication.cart.service;

import org.furkan.cartapiapplication.cart.message.CartCreateCommand;
import org.furkan.cartapiapplication.cart.model.Cart;
import org.furkan.cartapiapplication.cart.model.CartItem;

public final class CartItemRules {
    private static final int MAX_ITEM_COUNT = 30;
    private static final int MAX_UNIQUE_ITEM_COUNT = 10;
    private final CartCreateCommand createItemCommand;
    private final Cart cart;
    public CartItemRules(CartCreateCommand createItemCommand, Cart cart) {
        this.createItemCommand = createItemCommand;
        this.cart = cart;
    }

    public void applyRules() {
        checkItemQuantity(cart);
        checkTotalPriceExceedsLimit();
        checkUniqueItemQuantity();
    }

    private void checkTotalPriceExceedsLimit() {
        if (cart.isTotalPriceExceedsLimit(createItemCommand.getPrice())) {
            throw new RuntimeException("Total price exceeds the limit");
        }
    }

    private void checkUniqueItemQuantity() {
        long itemCount = cart.getCartItems().size();
        if (itemCount >= MAX_UNIQUE_ITEM_COUNT) {
            throw new RuntimeException("Unique item count must be less than 10, but it is " + itemCount);
        }
    }

    public static void checkItemQuantity(Cart cart) {
        long totalQuantity = cart.getCartItems().stream()
                .mapToLong(CartItem::getQuantity)
                .sum();

        if (totalQuantity >= MAX_ITEM_COUNT) {
            throw new RuntimeException("Total item count must be less than 30, but it is " + totalQuantity);
        }
    }
}
