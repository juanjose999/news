package com.news.model.dto.comparison;

import com.news.model.comment.Comment;
import com.news.model.dto.comment.CommentResponseDto;
import com.news.model.dto.news.NewsResponseDto;
import com.news.model.news.News;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ComparisonResponseDto {
    private List<NewsResponseDto> news = new ArrayList<>();
    private CommentResponseDto comment;
}
