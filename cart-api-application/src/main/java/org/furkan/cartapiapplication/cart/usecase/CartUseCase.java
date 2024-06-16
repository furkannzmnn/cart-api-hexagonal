package org.furkan.cartapiapplication.cart.usecase;

import org.furkan.cartapiapplication.UseCase;
import org.furkan.cartapiapplication.cart.message.CartCreateCommand;
import org.furkan.cartapiapplication.cart.model.Cart;
import org.furkan.cartapiapplication.cart.model.Item;
import org.furkan.cartapiapplication.cart.port.input.CartCreateUseCase;
import org.furkan.cartapiapplication.cart.port.output.CartCommandPort;
import org.furkan.cartapiapplication.cart.port.output.CartQueryPort;
import org.furkan.cartapiapplication.cart.port.output.ItemQueryPort;

import java.util.ArrayList;

@UseCase
public class CartUseCase implements CartCreateUseCase {

    private final CartCommandPort cartCommandPort;
    private final CartQueryPort cartQueryPort;
    private final ItemQueryPort itemQueryPort;

    public CartUseCase(CartCommandPort cartCommandPort, CartQueryPort cartQueryPort, ItemQueryPort itemQueryPort) {
        this.cartCommandPort = cartCommandPort;
        this.cartQueryPort = cartQueryPort;
        this.itemQueryPort = itemQueryPort;
    }

    @Override
    public void addItemToCart(CartCreateCommand command) {
        Cart cart = cartQueryPort.getCartById(command.getCartId()).orElse(new Cart());
        cart.setCartItems(new ArrayList<>());
        cart.setUserId(command.getUserId());
        cart.setTotalPrice(command.getPrice());

        Item item = itemQueryPort.get(command.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + command.getItemId()));

        cart.addItem(item, command.getQuantity()).runValidationRules(command);

        cart.setTotalPrice(cart.getTotalPrice().add(command.getPrice()));

        cartCommandPort.createCart(cart);

        cart.publishEvent();
    }

    @Override
    public void clearCart(Long cartId) {
        cartCommandPort.deleteCart(cartId);
    }

}
