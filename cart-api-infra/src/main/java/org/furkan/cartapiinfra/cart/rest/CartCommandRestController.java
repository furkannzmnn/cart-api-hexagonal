package org.furkan.cartapiinfra.cart.rest;

import jakarta.validation.Valid;
import org.furkan.cartapiapplication.cart.message.CartCreateCommand;
import org.furkan.cartapiapplication.cart.port.input.CartCreateUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartCommandRestController {

    private final CartCreateUseCase cartCreateUseCase;

    public CartCommandRestController(CartCreateUseCase cartCreateUseCase) {
        this.cartCreateUseCase = cartCreateUseCase;
    }

    @PostMapping
    public void createCart(@RequestBody @Valid CartCreateRequest request) {
        cartCreateUseCase.addItemToCart(request.toCommand());
    }
}
