package br.com.next.templates.templateproject.endpoints;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class PropertiesData {
    private final Map<String, Boolean> features;
}