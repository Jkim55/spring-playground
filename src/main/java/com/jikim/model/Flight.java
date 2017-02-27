package com.jikim.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {

    @JsonIgnore
    private int id;
    private String destination;

    @JsonProperty("departs")
    private Date departsAt;
    private Person pilot;
    private List<Person> passengers;

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartsAt() {
        return departsAt;
    }

    public Person getPilot() {
        return pilot;
    }

    public String getPassengers() {
        ArrayList<String> passengerList = new ArrayList();

        for (Person passenger : passengers){
            passengerList.add(passenger.name);
        }

        return String.join(", ", passengerList);
    }
}