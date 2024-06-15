package org.furkan.cartapiapplication.cart.message;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCreateCommand {
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
}
