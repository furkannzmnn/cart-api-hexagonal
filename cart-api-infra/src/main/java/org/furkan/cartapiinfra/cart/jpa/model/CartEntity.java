package org.furkan.cartapiinfra.cart.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import org.furkan.cartapiapplication.cart.model.CartItem;
import org.furkan.cartapiapplication.cart.model.Promotion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class CartEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal totalPrice;
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItemEntity> cartItems = new ArrayList<>();
    @OneToOne
    private PromotionEntity promotion;
}
