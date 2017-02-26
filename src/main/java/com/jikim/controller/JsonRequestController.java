package com.jikim.controller;

import com.jikim.model.Item;
import com.jikim.model.OrderDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FluidCoffeeBar")
public class JsonRequestController {

    @PostMapping("/SingleItem")
    public String getDataAsStringLiteral(@RequestBody Item item) {
        return String.format("Item is a %s %s at $%s", item.getSize(), item.getDrink(), item.getPrice());
    }

    @PostMapping("/OrderProgress")
    public String getDataAsGsonBuilderObj(@RequestBody Item item) {
        return item.getDrink();
    }

    @PostMapping("/OrderDetail")
    public Item[] getRawDataFromFileFixture(@RequestBody OrderDetail order) throws Exception {
        return order.getItems();
    }

}