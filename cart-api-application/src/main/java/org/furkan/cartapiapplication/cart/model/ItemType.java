package org.furkan.cartapiapplication.cart.model;

import lombok.Getter;

@Getter
public enum ItemType {
    DEFAULT_ITEM,
    DIGITAL_ITEM(7889),
    VAS_ITEM(3242);

    private final int categoryId;

    ItemType(int categoryId) {
        this.categoryId = categoryId;
    }

    ItemType() {
        this.categoryId = 0;
    }

}
