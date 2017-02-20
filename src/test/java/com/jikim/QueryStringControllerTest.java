package com.jikim;

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
@WebMvcTest(QueryStringController.class)

public class QueryStringControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void TestIndividual() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hbo/individual/girls?fname=Hannah&lname=Horvath");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Girl name is Hannah Horvath"));
    }

    @Test
    public void TestHashMap() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hbo/hashMap/girls?fname=Hannah&lname=Horvath");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{fname=Hannah, lname=Horvath}"));
    }

    @Test
    public void TestCustomObject () throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hbo/customObject/girls?fname=Hannah&lname=Horvath");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Girl name is Hannah Horvath"));
    }
}
