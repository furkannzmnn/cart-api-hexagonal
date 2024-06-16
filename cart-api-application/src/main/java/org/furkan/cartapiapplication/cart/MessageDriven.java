package org.furkan.cartapiapplication.cart;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface MessageDriven {
    Class<?> value();
}
