package org.furkan.cartapiapplication.cart;

import lombok.Getter;

@Getter
public abstract class DomainEvent {
    private final long timestamp;

    public DomainEvent() {
        this.timestamp = System.currentTimeMillis();
    }

}
