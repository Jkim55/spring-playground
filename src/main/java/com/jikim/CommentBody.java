package com.jikim;

import org.springframework.web.bind.annotation.RequestBody;

public class CommentBody {
    private String comment;
    private String author;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
