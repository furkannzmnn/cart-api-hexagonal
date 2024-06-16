package org.furkan.cartapiapplication.cart.usecase;

import lombok.RequiredArgsConstructor;
import org.furkan.cartapiapplication.UseCase;
import org.furkan.cartapiapplication.cart.MessageDriven;
import org.furkan.cartapiapplication.cart.message.CartPublishEvent;
import org.furkan.cartapiapplication.cart.port.input.MessageUseCase;
import org.furkan.cartapiapplication.cart.port.output.EventPublisherPort;

@MessageDriven(CartPublishEvent.class)
@RequiredArgsConstructor
public class CartEventPublisherUseCase implements MessageUseCase<CartPublishEvent> {

    private final EventPublisherPort eventPublisherPort;

    @Override
    public void handle(CartPublishEvent event) {
        eventPublisherPort.publish("CART_ITEM_ADDED", event);
    }
}
