package com.news.model.comparison;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.news.model.comment.Comment;
import com.news.model.dto.comment.CommentDto;
import com.news.model.dto.news.NewsDto;
import com.news.model.news.News;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "comparison_comment")
public class Comparison {
    @Id
    private String id_comparison;
    @DBRef
    @JsonManagedReference
    private List<News> news = new ArrayList<>();
    @DBRef
    @JsonManagedReference
    private Comment comment;

    public Comparison(List<News> news,Comment comment) {
        this.news = news;
        this.comment = comment;
    }

    public Comparison() {
    }
}
