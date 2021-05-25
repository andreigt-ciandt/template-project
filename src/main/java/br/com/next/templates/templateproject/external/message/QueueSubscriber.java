package br.com.next.templates.templateproject.external.message;

import br.com.next.templates.templateproject.external.message.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueueSubscriber {
    private static final String TOPIC_NAME = "template-trial-topic";

    private static final String SUBSCRIPTION_NAME = "product-subscriber";

    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
            subscription = SUBSCRIPTION_NAME)
    public void listenSubscription(ProductDto productDto) {
        log.info("Subscription 1 says: " + productDto.getName());
        log.info("Subscription 1 says: " + productDto.getQuantity());
    }
}
