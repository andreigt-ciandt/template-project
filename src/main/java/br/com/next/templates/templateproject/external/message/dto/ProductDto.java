package br.com.next.templates.templateproject.external.message.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ProductDto implements Serializable {
    private Long id;
    private String name;
    private int quantity;
}
