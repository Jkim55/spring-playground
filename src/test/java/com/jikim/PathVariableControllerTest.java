package com.jikim;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PathVariableController.class)

public class PathVariableControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void TestIndividual() throws Exception {
        int designerId = 23;
        int typeId = 4;

        this.mvc.perform(get("/dwr/chairs/{designerId}/material/{typeId}", designerId, typeId))
                .andExpect(status().isOk())
                .andExpect(content().string("Design Within Reach Chairs by 23 of type 4"));
    }

    @Test
    public void TestHashMap() throws Exception {
        int designerId = 13;
        int typeId = 44;

        this.mvc.perform(get("/dwr/tables/{designerId}/material/{typeId}", designerId, typeId))
                .andExpect(status().isOk())
                .andExpect(content().string("{designerId=13, typeId=44}"));
    }

    @Test
    public void TestCustomObject() throws Exception {
        int designerId = 59;
        int typeId = 01;

        this.mvc.perform(get("/dwr/lighting/{designerId}/material/{typeId}", designerId, typeId))
                .andExpect(status().isOk())
                .andExpect(content().string("Design Within Reach Lighting Fixtures by 59 of type 1"));
    }
}
