package org.furkan.cartapiapplication;

import org.furkan.cartapiapplication.cart.DomainEvent;

@UseCase
public class MessagePublisher {

    public void publish(DomainEvent event) {
        // bu eventi inherit eden tüm sınıflara eventi gönder



    }

    public static void publishMessage(DomainEvent event) {
        MessageContext.instance.publish(event);
    }


    static class MessageContext {
        private static MessagePublisher instance;

        private MessageContext() {
        }
    }
}
