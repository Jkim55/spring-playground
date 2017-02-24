package com.jikim;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
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

    static class Item {
        private String drink;
        private String size;
        private String price;

        public Item() {
        }

        public String getDrink() {
            return this.drink;
        }

        public void setDrink(String drink) {
            this.drink = drink;
        }

        public String getSize() {
            return this.size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getPrice() {
            return this.price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    static class OrderDetail {
        private String name;
        private Item[] items;
        private Boolean fulfilled;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getFulfilled() {
            return fulfilled;
        }

        public void setFulfilled(Boolean fulfilled) {
            this.fulfilled = fulfilled;
        }

        public Item[] getItems() {
            return items;
        }

        public void setItems(Item[] items) {
            this.items = items;
        }

    }

    @PostMapping("/OrderDetail")
    public String getRawDataFromFileFixture(@RequestBody OrderDetail order) throws Exception {
        return order.items[0].getDrink();
    }
}