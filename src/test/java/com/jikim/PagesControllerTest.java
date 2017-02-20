package com.jikim;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PagesController.class)

public class PagesControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testHomePage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");  // building the request
        this.mvc.perform(request)  // mvc.perform() mocks a request (arg request) to application
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

}
