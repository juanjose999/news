package com.news.service.comment;

import com.news.model.dto.comment.CommentDto;
import com.news.model.dto.comment.CommentResponseDto;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Optional<List<CommentResponseDto>> allComment();
    CommentResponseDto addComment(CommentDto comment);
    Boolean deleteCommentById(String idComment);
}
