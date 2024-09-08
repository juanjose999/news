package com.news.model.dto.comparison;

import com.news.model.comment.Comment;
import com.news.model.comparison.Comparison;
import com.news.model.dto.comment.CommentMapper;
import com.news.model.dto.comment.CommentResponseDto;
import com.news.model.dto.news.NewsMapper;
import com.news.model.dto.news.NewsResponseDto;
import com.news.model.news.News;

import java.util.List;
import java.util.stream.Collectors;

public class ComparisonMapper {

    public static Comparison ComparisonDtoToComparison(ComparisonDto comparisonDto){
        Comment comment = CommentMapper.CommentDtoToComment(comparisonDto.getCommentDto());
        List<News> newsList = comparisonDto.getNewsDto().stream()
                .map(NewsMapper::neswDtoToNews)
                .toList();
        System.out.println(comment);
        System.out.println(newsList);
        return new Comparison(newsList,comment);
    }

    public static ComparisonResponseDto comparisonToComparisonResponseDto(Comparison comparison){
        List<News> newsList = comparison.getNews();
        Comment comment = comparison.getComment();
        CommentResponseDto commentResponseDto = null;
        if(comment!=null){
            commentResponseDto = new CommentResponseDto();
            commentResponseDto.setTitle(comment.getTitle());
            commentResponseDto.setContent(comment.getContent());
        }else{
            commentResponseDto = new CommentResponseDto();
            commentResponseDto.setTitle("No Title Available");
            commentResponseDto.setContent("No Content Available");
        }
        List<NewsResponseDto> dtoNews = newsList.stream()
                .map(NewsMapper::newToNewsResponseDto)
                .toList();

        return new ComparisonResponseDto(dtoNews,commentResponseDto);
    }
}
