package com.news.model.news;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.news.model.comparison.Comparison;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "news")
public class News {
    @Id
    private String id;
    private String title;
    private String content;
    private String cover_image;
    private String link_news;
    private IdeologyNews ideologyNews;
    @DBRef
    @JsonBackReference
    private Comparison comparison;

    public News(String title, String content, String cover_image, String link_news, IdeologyNews ideologyNews, Comparison comparison) {
        this.title = title;
        this.content = content;
        this.cover_image = cover_image;
        this.link_news = link_news;
        this.ideologyNews = ideologyNews;
        this.comparison = comparison;
    }
}
