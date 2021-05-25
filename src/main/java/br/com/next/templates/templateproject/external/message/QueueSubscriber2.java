package br.com.next.templates.templateproject.external.message;

import br.com.next.templates.templateproject.external.message.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueueSubscriber2 {

    private static final String TOPIC_NAME = "template-trial-topic";

    private static final String SUBSCRIBER_NAME = "product-subscription-2";

    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
            subscription = SUBSCRIBER_NAME)
    public void receiveMessage(ProductDto productDto) {
        log.info("Subscription 2 says: " + productDto.getName());
        log.info("Subscription 2 says: " + productDto.getQuantity());
    }
}

