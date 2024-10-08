package org.furkan.cartapiapplication;

import java.util.Queue;

public abstract class AggregateRoot {

    private final Queue<DomainEvent> eventQueue;
    private final Queue<DomainEvent> consumedEventQueue;

    public AggregateRoot() {
        this.eventQueue = new java.util.LinkedList<>();
        this.consumedEventQueue = new java.util.LinkedList<>();
    }

    protected void registerMessage(DomainEvent domainEvent) {
        eventQueue.add(domainEvent);
    }

    protected void publish() {
        while (!eventQueue.isEmpty()) {
            DomainEvent domainEvent = eventQueue.poll();
            MessagePublisher.publishMessage(domainEvent);
            consumedEventQueue.add(domainEvent);
        }
    }


    protected void unregisterMessage(DomainEvent of) {
        consumedEventQueue.remove(of);
    }
}
