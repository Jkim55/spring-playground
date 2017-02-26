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

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartsAt() {
        return departsAt;
    }
    public void setDepartsAt(Date departsAt) {
        this.departsAt = departsAt;
    }

    public Person getPilot() {
        return pilot;
    }

    public void setPilot(Person pilot) {
        this.pilot = pilot;
    }

    public String getPassengers() {
        ArrayList<String> passengerList = new ArrayList<String>();

        for (Person passenger : passengers){
            passengerList.add(passenger.name);
        }
        return String.join(", ", passengerList);
    }

    public void setPassengers(List<Person> passengers) {
        this.passengers = passengers;
    }

//    static class Person {
//        private final String name;
//
//        @JsonCreator
//        public Person(@JsonProperty("name") String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }

}