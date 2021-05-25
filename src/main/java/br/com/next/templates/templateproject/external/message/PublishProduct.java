package br.com.next.templates.templateproject.external.message;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.external.message.dto.ProductDto;
import br.com.next.templates.templateproject.external.message.dto.ProductDtoAdapter;
import br.com.next.templates.templateproject.usecase.ExposeProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublishProduct implements ExposeProduct {

    private final JmsTemplate jmsTemplate;

    public void publish(Product product) {
        final ProductDto productDto = ProductDtoAdapter.fromEntity(product);
        jmsTemplate.convertAndSend("template-trial-queue",
                productDto);
        jmsTemplate.convertAndSend("template-trial-topic",
                productDto);
    }
}
