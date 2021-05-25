package br.com.next.templates.templateproject.external.message;

import br.com.next.templates.templateproject.external.message.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueueReceiver {

    private static final String QUEUE_NAME = "template-trial-queue";

    @JmsListener(destination = QUEUE_NAME, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(ProductDto productDto) {
        log.info("Message Queue says: " + productDto.getName());
        log.info("Message Queue says: " + productDto.getQuantity());
    }

}
