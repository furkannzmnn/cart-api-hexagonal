package org.furkan.cartapiapplication.cart.model;

import lombok.Getter;

@Getter
public enum PromotionType {
    SAME_SELLER_PROMOTION(9909L),
    CATEGORY_PROMOTION(5676L),
    TOTAL_PRICE_PROMOTION(1232L);

    private final Long id;

    PromotionType(Long id) {
        this.id = id;
    }

}
