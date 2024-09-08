package com.news.model.dto.comment;

import com.news.model.comment.Comment;
import com.news.model.comparison.Comparison;
import com.news.model.dto.comparison.ComparisonMapper;
import com.news.model.dto.comparison.ComparisonResponseDto;

public class CommentMapper {

    public static CommentResponseDto commentToCommentResponseDto (Comment comment){
        return new CommentResponseDto(
                comment.getTitle(),
                comment.getContent()
        );
    }

    public static Comment CommentDtoToComment (CommentDto commentDto){
        System.out.println(commentDto.getTitle());
        System.out.println(commentDto.getContent());
        return new Comment(
                commentDto.getTitle(),
                commentDto.getContent()
        );
    }

}
