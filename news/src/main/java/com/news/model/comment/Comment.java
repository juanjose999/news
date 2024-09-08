package com.news.model.comment;

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
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String title;
    private String content;
    @DBRef
    @JsonBackReference
    private Comparison comparison;

    public Comment(String title, String content, Comparison comparison) {
        this.title = title;
        this.content = content;
        this.comparison = comparison;
    }

    public Comment(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
