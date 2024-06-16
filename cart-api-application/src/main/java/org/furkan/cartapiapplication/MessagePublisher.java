package org.furkan.cartapiapplication;

import org.springframework.context.ApplicationContext;

@UseCase
public class MessagePublisher {

    private final ApplicationContext applicationContext;

    public MessagePublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        MessagePublisher.MessageContext.instance = this;
    }

    public void publish(DomainEvent event) {
        applicationContext.getBeansWithAnnotation(MessageDriven.class)
                .values()
                .forEach(messageDriven -> {
                    try {
                        MessageDriven annotation = messageDriven.getClass().getAnnotation(MessageDriven.class);
                        String methodName = annotation.method();
                        messageDriven.getClass().getMethod(methodName, event.getClass()).invoke(messageDriven, event);
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
