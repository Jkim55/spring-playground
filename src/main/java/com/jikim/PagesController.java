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
    public String sayHelloToSomeone() { return "Hello there, someone!"; }

    @DeleteMapping ("/hello")
    public String sayNothing() { return "Gooooooodbye, World!"; }
}
