package org.furkan.cartapiinfra.config;

import org.furkan.cartapiapplication.UseCase;
import org.furkan.cartapiapplication.MessageDriven;
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
