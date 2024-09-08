package com.news.repository.comment;

import com.news.model.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    public final CommentsRepositoryMongo commentRepositoryMongo;

    public CommentRepositoryImpl(CommentsRepositoryMongo commentRepositoryMongo) {
        this.commentRepositoryMongo = commentRepositoryMongo;
    }

    @Override
    public Optional<List<Comment>> allComment() {
        return Optional.of(commentRepositoryMongo.findAll());
    }

    @Override
    public Optional<Comment> findCommentById(String idComment) {
        return commentRepositoryMongo.findById(idComment);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepositoryMongo.save(comment);
    }

    @Override
    public Boolean deleteCommentById(String idComment) {
        Optional<Optional<Comment>> findComment = Optional.ofNullable(findCommentById(idComment));
        if(findComment.isPresent()){
            commentRepositoryMongo.deleteById(idComment);
            return true;
        }
        return false;
    }
}
