package com.jikim;

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
    public void TestCreateComment() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request = post("/comments/string")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("Whooty Whoot", content)
                .param("author", "Jiggibot");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Whooty+Whoot=%s&author=Jiggibot", content)));
    }
}
