package com.jikim;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookiesAndHeadersController {

    @GetMapping("/CookieMonsterJar")
    public String getCookie(@CookieValue(name = "cookieID") String cookie) {
        return cookie;
    }

    @GetMapping("/header")
    public String getHeader(@RequestHeader String host) {
        return host;
    }
}
