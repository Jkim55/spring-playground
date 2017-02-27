package com.jikim.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Girl {
    private String fname;
    private String lname;

    @JsonCreator
    public Girl(@JsonProperty("fname") String fname,@JsonProperty("lname") String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

}
