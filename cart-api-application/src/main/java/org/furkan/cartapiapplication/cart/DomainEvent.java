package org.furkan.cartapiapplication.cart;

public abstract class DomainEvent {
    private final long timestamp;

    public DomainEvent() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
