package com.jikim;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonResponseController.class)
public class JsonResponseControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void JsonResponseAsObjectTest() throws Exception{
        MockHttpServletRequestBuilder response = get("/json/simple-object")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        this.mvc.perform(response)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fname", is("Shoshanna")))
                .andExpect(jsonPath("$.lname", is("Shapiro")));
    }

    @Test
    public void JsonResponseAsArrayTest() throws Exception {
        MockHttpServletRequestBuilder response = get("/json/simple-array")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        this.mvc.perform(response)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2].fname", is("Shoshanna")))
                .andExpect(jsonPath("$[2].lname", is("Shapiro")));
    }
}
