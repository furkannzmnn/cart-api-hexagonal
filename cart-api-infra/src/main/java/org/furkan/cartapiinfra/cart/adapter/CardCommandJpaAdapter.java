package org.furkan.cartapiinfra.cart.adapter;

import org.furkan.cartapiapplication.cart.model.Cart;
import org.furkan.cartapiapplication.cart.port.output.CartCommandPort;
import org.furkan.cartapiinfra.cart.jpa.CardMapper;
import org.furkan.cartapiinfra.cart.jpa.model.CartEntity;
import org.furkan.cartapiinfra.cart.jpa.repository.CardRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class CardCommandJpaAdapter implements CartCommandPort {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardCommandJpaAdapter(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public Cart createCart(Cart cart) {
        CartEntity cartEntity = cardMapper.toEntity(cart);
        TransactionSynchronizationManager.bindResource(cardRepository, cartEntity);

       // cardRepository.save(cartEntity);
        return cardMapper.toDomain(cartEntity);
    }

    @Override
    public void deleteCart(Long cartId) {
        cardRepository.deleteById(cartId);
    }
}
