package com.jikim.controller;

import com.jikim.model.Girl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hbo")
public class QueryStringController {

    @GetMapping("individual/girls")
    public String findByName(
            @RequestParam String fname,
            @RequestParam String lname) {
        return String.format("Girl name is %s %s", fname, lname);
    }

    @GetMapping("hashMap/girls")
    public String findAsHashMap(@RequestParam Map querystring){
        return querystring.toString();
    }

    @GetMapping("customObject/girls")
    public String findFromCustomObject(Girl girl){
        return String.format("Girl name is %s %s", girl.getFname(), girl.getLname());
    }
}
