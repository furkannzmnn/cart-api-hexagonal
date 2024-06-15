package org.furkan.cartapiapplication.cart.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VasItem {
    private Long id;
    private BigDecimal vasPrice;
    private Long categoryId;
    private Long sellerId;
}
