package by.korona.sub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
    @GetMapping
    public String index() {
        return "Hello World";
    }

    @PostMapping
    public String subscribe() {
        return "Hello World";
    }
}
