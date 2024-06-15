package org.furkan.cartapiinfra.cart.jpa.repository;

import org.furkan.cartapiinfra.cart.jpa.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CartEntity, Long> {
}
