package com.jikim;

import com.jikim.controller.NestedJsonRequestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NestedJsonRequestController.class)
public class NestedJsonRequestControllerTest{

    @Autowired
    private MockMvc mvc;

    @Test
    public void fetchAsStringLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/flight/string")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 10,\"destination\": \"London\",\"departsOn\": \"2017-04-06\",\"passengers\": [{\"name\": \"Eliza\"}, {\"name\": \"Samuel\"}],\"pilot\": {\"name\": \"Angelica\"}}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Flight Details: Destination: London | Departs: null | Pilot: Angelica | Passengers: Eliza, Samuel"));
    }

//    @Test
//    public void fetchWithGSONSerializedObject() throws Exception {
//
//    }

//    @Test
//    public void fetchAsRawBodyFromFileFixturePull() throws Exception {
//
//    }

}
