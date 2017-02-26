package com.jikim.controller;

import com.jikim.model.Flight;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class NestedJsonRequestController {

    @PostMapping("/string")
    public String getDataAsStringLiteral(@RequestBody Flight flight){
        return String.format(
                "Flight Details: Destination: %s | Departs: %s | Pilot: %s | Passengers: %s",
                flight.getDestination(),
                flight.getDepartsAt(),
                flight.getPilot().getName(),
                flight.getPassengers()
        );
    }

}
