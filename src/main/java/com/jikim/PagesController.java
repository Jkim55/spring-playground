package com.jikim;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PagesController {

    @GetMapping ("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @PatchMapping ("/hello")
    public String sayHelloPatch() { return "Hello World with patch!"; }

    @DeleteMapping ("/hello")
    public String sayHelloDelete() { return "Hello World with delete!"; }
}
