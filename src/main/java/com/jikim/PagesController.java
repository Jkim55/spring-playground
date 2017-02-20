package com.jikim;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    @GetMapping ("/hello")
    public String sayhello() {
        return "Hello World!";
    }
}
