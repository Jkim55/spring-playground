package com.jikim;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import com.jikim.controller.JsonRequestController;
import com.jikim.model.Item;
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

    @Test
    public void fetchAsStringLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/FluidCoffeeBar/SingleItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"drink\": \"mule latte\", \"size\": \"medium\", \"price\": \"5.99\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Item is a medium mule latte at $5.99"));
    }

    @Test
    public void fetchWithGSONwithBuilder() throws Exception {
        JsonObject order = new JsonObject();
        order.addProperty("Medium Mocha Latte", false);

        Gson builder = new GsonBuilder().create();                  // 3

        String jsonString = builder.toJson(order);                 // 4

        MockHttpServletRequestBuilder request = post("/FluidCoffeeBar/OrderProgress")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

    private Gson gson = new GsonBuilder().create();

    @Test
    public void fetchWithGSONSerializedObject() throws Exception {
        Item item = new Item("Italian soda", "large", "4.50");

        MockHttpServletRequestBuilder request = post("/FluidCoffeeBar/SingleItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(item));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Item is a large Italian soda at $4.50"));
    }

    @Test
    public void fetchAsRawBodyFromFileFixturePull() throws Exception {
        String receiptsJSON = getJSON("/orderdata.json");

        MockHttpServletRequestBuilder request = post("/FluidCoffeeBar/OrderDetail")
                .contentType(MediaType.APPLICATION_JSON)
                .content(receiptsJSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"drink\":\"Cortado\",\"size\":\"N/A\",\"price\":\"2.75\"},{\"drink\":\"Lemongrass Tea\",\"size\":\"large\",\"price\":\"3.85\"}]"));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.toURI())));
    }
}