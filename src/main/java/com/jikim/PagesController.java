package com.jikim;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    @GetMapping
    public String hello() {
        return "Hello World!";
    }
}
