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

import javax.servlet.http.Cookie;


@RunWith(SpringRunner.class)
@WebMvcTest(CookiesAndHeadersController.class)
public class CookiesAndHeadersControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void AccessCookieDataTest() throws Exception{
        this.mvc.perform(get("/CookieMonsterJar").cookie(new Cookie("cookieID", "Birthday Cake Cookie")))
                .andExpect(status().isOk())
                .andExpect(content().string("Birthday Cake Cookie"));
    }

    @Test
    public void AccessHeaderDataTest() throws Exception {
        this.mvc.perform(get("/header").header("Host", "jikim.me"))
                .andExpect(status().isOk())
                .andExpect(content().string("jikim.me"));
    }

}
