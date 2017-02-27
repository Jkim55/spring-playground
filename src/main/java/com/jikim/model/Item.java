package com.jikim.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private String drink;
    private String size;
    private String price;

    @JsonCreator
    public Item (@JsonProperty("drink") String drink, @JsonProperty("size") String size, @JsonProperty("price") String price){
        this.drink = drink;
        this.size = size;
        this.price = price;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
