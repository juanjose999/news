package com.news.repository.comment;

import com.news.model.comment.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepositoryMongo extends MongoRepository<Comment, String> {
}
