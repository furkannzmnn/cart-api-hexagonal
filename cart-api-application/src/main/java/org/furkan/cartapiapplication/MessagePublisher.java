package org.furkan.cartapiapplication;

import lombok.RequiredArgsConstructor;
import org.furkan.cartapiapplication.cart.DomainEvent;
import org.furkan.cartapiapplication.cart.MessageDriven;
import org.springframework.context.ApplicationContext;

@UseCase
public class MessagePublisher {

    private final ApplicationContext applicationContext;

    public MessagePublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        MessagePublisher.MessageContext.instance = this;
    }

    public void publish(DomainEvent event) {
        /*
        @Configuration
@ComponentScan(
        basePackages = "org.furkan.cartapiapplication",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = UseCase.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MessageDriven.class)
        }

)
public class DomainConfig {}
         */
        applicationContext.getBeansWithAnnotation(MessageDriven.class)
                .values()
                .forEach(messageDriven -> {
                    try {
                        messageDriven.getClass().getMethod("handle", event.getClass()).invoke(messageDriven, event);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });


    }

    public static void publishMessage(DomainEvent event) {
        MessageContext.instance.publish(event);
    }


    static class MessageContext {
        private static MessagePublisher instance;

        private MessageContext() {
        }

        public static void setInstance(MessagePublisher instance) {
            MessageContext.instance = instance;
        }
    }
}
