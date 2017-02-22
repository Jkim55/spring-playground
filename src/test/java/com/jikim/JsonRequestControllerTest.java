package com.jikim;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonRequestController.class)

public class JsonRequestControllerTest {
    @Autowired
    private MockMvc mvc;

//    Ensure that the JSON you are sending has multiple levels, and a mix of JSON arrays and objects such as
    @Test
    public void fetchAsStringLiteral() throws Exception {

    }

    @Test
    public void fetchAsGSON() throws Exception {

    }

    @Test
    public void fetchAsJackson() throws Exception {

    }

    @Test
    public void fetchAsFileFixturePull() throws Exception {

    }
}
