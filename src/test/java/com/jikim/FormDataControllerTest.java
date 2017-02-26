package com.jikim;

import com.jikim.controller.FormDataController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void TestFetchAsString() throws Exception {
        String comment = "blo bla";
        String author = "Jiggibot";

        MockHttpServletRequestBuilder request = post("/comments/string")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", comment)
                .param("author", author);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("%s written by %s", comment, author)));
    }

    @Test
    public void TestFetchAsRawString() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request = post("/comments/rawString")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", content)
                .param("author", "Jiggibot");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("comment=%s&author=Jiggibot", content)));
    }

    @Test
    public void TestFetchAsHashMap() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request = post("/comments/hashMap")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", content)
                .param("author", "Jiggibot");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("{comment=%s, author=Jiggibot}", content)));
    }

    @Test
    public void TestFetchAsCustomObject() throws Exception {
        String content = "Not a rando";

        MockHttpServletRequestBuilder request = post("/comments/customObject")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", content)
                .param("author", "Jiggibot");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Not a rando written by Jiggibot", content)));
    }

}