package org.furkan.cartapiapplication.cart.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.furkan.cartapiapplication.cart.common.model.MessageDriven;
import org.furkan.cartapiapplication.cart.message.CartPublishEvent;
import org.furkan.cartapiapplication.cart.port.input.MessageUseCase;
import org.furkan.cartapiapplication.cart.port.output.EventPublisherPort;

@MessageDriven(value = CartPublishEvent.class, method = "publish")
@RequiredArgsConstructor
@Slf4j
public class CartEventPublisherUseCase implements MessageUseCase<CartPublishEvent> {

    private final EventPublisherPort eventPublisherPort;

    @Override
    public void publish(CartPublishEvent event) {
        eventPublisherPort.publish("CART_ITEM_ADDED", event);
        log.info("Cart event published: {}", event);

    }
}
