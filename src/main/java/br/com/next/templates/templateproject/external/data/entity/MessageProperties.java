package br.com.next.templates.templateproject.external.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "config")
public class MessageProperties {
    private String message;
    private String outra;
    private String outra2;


}