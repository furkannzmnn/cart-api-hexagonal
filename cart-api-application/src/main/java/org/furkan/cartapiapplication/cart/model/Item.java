package org.furkan.cartapiapplication.cart.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Item {
    private Long id;
    private ItemType itemType;
    private String name;
    private BigDecimal price;
    private Long sellerId;
    private Long categoryId;
    private List<CartItem> cartItems = new ArrayList<>();
    private List<VasItem> vasItems = new ArrayList<>();
}
