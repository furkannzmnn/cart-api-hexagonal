package org.furkan.cartapiinfra.cart.event;

import lombok.RequiredArgsConstructor;
import org.furkan.cartapiapplication.cart.port.output.EventPublisherPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaEventPublisher implements EventPublisherPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publish(String topic, Object event) {
        kafkaTemplate.send(topic, event.toString());
    }
}
