package com.jikim;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")

public class FormDataController {

    @PostMapping("/string")
    public String formDataAsString (@RequestBody String rawBody) {
        return rawBody;
    }

}
