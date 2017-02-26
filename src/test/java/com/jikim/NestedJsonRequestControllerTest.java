package com.jikim;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonRequestController.class)

public class NestedJsonRequestControllerTest{

    @Autowired
    private MockMvc mvc;

    @Test
    public void fetchAsStringLiteral() throws Exception {

    }

    @Test
    public void fetchWithGSONBuilder() throws Exception {

    }

    @Test
    public void fetchWithGSONSerializedObject() throws Exception {

    }

    @Test
    public void fetchAsRawBodyFromFileFixturePull() throws Exception {

    }
}
