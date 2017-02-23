package com.jikim;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonRequestController {

    @PostMapping("/fluidCoffeeBar")
    public String getDataAsStringLiteral(@RequestBody Item item) {
        return String.format("Item is a %s %s at %s", item.getSize(), item.getDrink(), item.getPrice());
    }
}