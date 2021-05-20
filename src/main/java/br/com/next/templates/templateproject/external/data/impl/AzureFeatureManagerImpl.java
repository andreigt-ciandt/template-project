package br.com.next.templates.templateproject.external.data.impl;

import br.com.next.templates.templateproject.external.data.ListAllProperties;
import br.com.next.templates.templateproject.external.data.entity.MessageProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AzureFeatureManagerImpl implements ListAllProperties {

    private final MessageProperties messageProperties;

    @Override
    public MessageProperties execute() {
        return messageProperties;
    }
}