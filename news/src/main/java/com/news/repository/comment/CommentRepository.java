package com.news.repository.comment;

import com.news.model.comment.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Optional<List<Comment>> allComment();
    Optional<Comment> findCommentById(String idComment);
    Comment addComment(Comment comment);
    Boolean deleteCommentById(String idComment);
}
