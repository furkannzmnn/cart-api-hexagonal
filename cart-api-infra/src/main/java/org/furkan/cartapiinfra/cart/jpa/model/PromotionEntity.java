package org.furkan.cartapiinfra.cart.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class PromotionEntity {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
