package com.jikim;

import org.springframework.web.bind.annotation.RequestBody;

public class CommentBody {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
