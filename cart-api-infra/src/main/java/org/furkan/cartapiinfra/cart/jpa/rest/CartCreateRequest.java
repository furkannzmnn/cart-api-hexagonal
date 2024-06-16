package org.furkan.cartapiinfra.cart.jpa.rest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.furkan.cartapiapplication.cart.message.CartCreateCommand;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCreateRequest {
    @NotNull(message = "Item id is required")
    private Long itemId;
    @NotNull(message = "Category id is required")
    private Long categoryId;
    @NotNull(message = "Quantity is required")
    private Long quantity;
    @NotNull(message = "Seller id is required")
    private Long sellerId;
    @NotNull(message = "Price is required")
    private BigDecimal price;
    @NotNull(message = "Cart id is required")
    private Long cartId;
    @NotNull
    private Long userId;

    public CartCreateCommand toCommand() {
        return new CartCreateCommand(itemId, categoryId, quantity, sellerId, price, cartId, userId);
    }
}
