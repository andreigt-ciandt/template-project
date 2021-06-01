package br.com.next.templates.templateproject.endpoints;

import lombok.RequiredArgsConstructor;
import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.property.Property;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertiesController {

    private final FF4j ff4j;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Property<?>> allProperties() {
        return ff4j.getProperties();
    }

    @GetMapping("/toggles")
    @ResponseStatus(HttpStatus.OK)
    public PropertiesData allFeatures() {
        return PropertiesData.builder().features(ff4j.getFeatures().entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().isEnable())))
                .build();
    }
}