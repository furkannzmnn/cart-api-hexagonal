package org.furkan.cartapiapplication.cart.common.model;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface MessageDriven {
    Class<?> value();
    String method() default "handle";
}
