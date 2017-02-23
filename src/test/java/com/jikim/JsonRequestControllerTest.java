package com.jikim;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonRequestController.class)

public class JsonRequestControllerTest {
    @Autowired
    private MockMvc mvc;

//    Ensure that the JSON you are sending has multiple levels, and a mix of JSON arrays and objects such as

    @Test
    public void fetchAsStringLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/fluidCoffeeBar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"drink\": \"mule latte\", \"size\": \"medium\", \"price\": \"5.99\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Item is a medium mule latte at 5.99"));
    }
}
