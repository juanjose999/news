package com.news.model.dto.comment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {
    private String title;
    private String content;

    public CommentDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
