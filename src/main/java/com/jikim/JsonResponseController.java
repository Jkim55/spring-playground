package com.jikim;

import com.jikim.model.Girl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonResponseController {

    @GetMapping("/simple-object")
    public Girl renderGirlObjectAsObject() {
        return new Girl("Shoshanna", "Shapiro");
    }

    @GetMapping("/simple-array")
    public Girl[] renderGirlObjectAsArray() {
        Girl[] girls = new Girl[]{
                new Girl("Hannah", "Horvath"),
                new Girl("Marie", "Williams"),
                new Girl("Shoshanna", "Shapiro"),
                new Girl("Jessa", "Johansson"),
        };
        return girls;
    }

}
