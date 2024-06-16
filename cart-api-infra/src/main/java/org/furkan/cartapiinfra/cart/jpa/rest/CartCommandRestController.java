package org.furkan.cartapiinfra.cart.jpa.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.furkan.cartapiapplication.cart.port.input.CartCreateUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartCommandRestController {

    private final CartCreateUseCase cartCreateUseCase;

    @PostMapping
    public void createCart(@RequestBody @Valid CartCreateRequest request) {
        cartCreateUseCase.addItemToCart(request.toCommand());
    }
}
