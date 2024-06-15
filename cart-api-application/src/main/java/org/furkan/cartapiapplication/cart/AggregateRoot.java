package org.furkan.cartapiapplication.cart;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public abstract class AggregateRoot {

    private Queue<DomainEvent> eventQueue;
    private Queue<DomainEvent> consumedEventQueue;

    protected void registerMessage(DomainEvent domainEvent) {
        eventQueue.add(domainEvent);
    }

    protected void publish() {
        while (!eventQueue.isEmpty()) {
            DomainEvent domainEvent = eventQueue.poll();

        }
    }


}
