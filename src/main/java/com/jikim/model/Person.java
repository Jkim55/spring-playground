package com.jikim.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    public final String name;

    @JsonCreator
    public Person(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//returns the stringified version of the object Person
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                '}';
//    }