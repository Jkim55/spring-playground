package com.jikim;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/comments")

public class FormDataController {

    @PostMapping("/string")
    public String formDataAsString(
            @RequestParam String comment,
            @RequestParam String author) {
        return String.format("%s written by %s", comment, author);
    }

    @PostMapping("/rawString")
    public String formDataAsString(@RequestBody String rawBody) {
        return rawBody;
    }

    @PostMapping(value = "/hashMap", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String formDataAsHashMap(@RequestParam Map<String, String> commentBody){
        return commentBody.toString();
    }

    @PostMapping(value = "/customObject", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String formDataAsObject(CommentBody comment) {
        return String.format("%s written by %s", comment.getComment(), comment.getAuthor());
    }
}
