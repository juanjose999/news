package com.news.model.dto.comment;

import com.news.model.comparison.Comparison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentResponseDto {
    private String title;
    private String content;

    public CommentResponseDto(String title, String content) {
    }
}
