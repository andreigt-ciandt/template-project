package br.com.next.templates.templateproject.config;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
@Getter
public class ApplicationClients {
    private final List<ApplicationClient> clients = new ArrayList<>();
}