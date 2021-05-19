package br.com.next.templates.templateproject.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
@Builder
public class Product {
    @Getter
    private final Long id;
    @Getter
    private final String name;
    @Getter
    private final int quantity;
}
