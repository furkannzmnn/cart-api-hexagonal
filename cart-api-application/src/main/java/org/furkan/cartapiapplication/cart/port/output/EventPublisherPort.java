package org.furkan.cartapiapplication.cart.port.output;

public interface EventPublisherPort {
   <T> void publish(String topic, T event);
}
