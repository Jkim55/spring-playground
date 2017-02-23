package com.jikim;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FluidCoffeeBar")
public class JsonRequestController {

    @PostMapping("/SingleItem")
    public String getDataAsStringLiteral(@RequestBody Item item) {
        return String.format("Item is a %s %s at %s", item.getSize(), item.getDrink(), item.getPrice());
    }




//    class Article {
//        private String title;
//        private String createdBy;
//
//        public String getTitle() { return title; }
//
//        public void setTitle(String title) { this.title = title; }
//
//        @JsonProperty("created_by")
//        public String getCreatedBy() { return createdBy; }
//
//        public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
//    }
//
//    class Blog {
//        private String title;
//        private Article[] articles;
//
//        public String getTitle() { return title; }
//
//        public void setTitle(String title) { this.title = title; }
//
//        public Article[] getArticles() { return articles; }
//
//        public void setArticles(Article[] articles) { this.articles = articles; }
//    }
//
//    @PostMapping("/nested-example")
//    public String getNested(@RequestBody Blog blog) {
//        return blog.articles[0].getTitle();
//    }
}