package br.com.next.templates.templateproject.endpoints;

import br.com.next.templates.templateproject.external.data.ListAllProperties;
import br.com.next.templates.templateproject.external.data.entity.MessageProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertiesController {

    private final ListAllProperties listAllProperties;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public MessageProperties allProperties() {
        return listAllProperties.execute();
    }
}