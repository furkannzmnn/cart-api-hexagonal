package org.furkan.cartapiinfra.item.adapter;

import org.furkan.cartapiapplication.cart.model.Item;
import org.furkan.cartapiapplication.cart.port.output.ItemQueryPort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class ItemQueryJpaAdapter implements ItemQueryPort {

    @Override
    public Optional<Item> get(Long id) {
        Item item = new Item();
        item.setId(id);
        item.setName("Item Name");
        item.setPrice(BigDecimal.valueOf(100.0));
        return Optional.of(item);
    }
}
