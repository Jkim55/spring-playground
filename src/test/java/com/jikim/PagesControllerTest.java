package com.jikim;

import com.jikim.controller.PagesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
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
    public void testHomePageGet() throws Exception {
        RequestBuilder getRequest = MockMvcRequestBuilders.get("/hello");  // building the request

        this.mvc.perform(getRequest)  // mvc.perform() mocks a request (arg request) to application
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

    @Test
    public void testHomePagePatch() throws Exception {
        RequestBuilder patchRequest = MockMvcRequestBuilders.patch("/hello");

        this.mvc.perform(patchRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World with patch!"));
    }

    @Test
    public void testHomePageDelete() throws Exception{
        RequestBuilder deleteRequest = MockMvcRequestBuilders.delete("/hello");

        this.mvc.perform(deleteRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World with delete!"));
    }
}
