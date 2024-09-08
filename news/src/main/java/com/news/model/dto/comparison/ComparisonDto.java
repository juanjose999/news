package com.news.model.dto.comparison;


import com.news.model.dto.comment.CommentDto;
import com.news.model.dto.news.NewsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class ComparisonDto {
    private List<NewsDto> newsDto;
    private CommentDto commentDto;
    public ComparisonDto( List<NewsDto> newsDto,CommentDto commentDto) {
        this.newsDto = newsDto;
        this.commentDto = commentDto;
    }
}
