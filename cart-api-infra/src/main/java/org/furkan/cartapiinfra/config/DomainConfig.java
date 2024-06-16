package org.furkan.cartapiinfra.config;

import org.furkan.cartapiapplication.cart.common.model.UseCase;
import org.furkan.cartapiapplication.cart.common.model.MessageDriven;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "org.furkan.cartapiapplication",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = UseCase.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MessageDriven.class)
        }

)
public class DomainConfig {}
