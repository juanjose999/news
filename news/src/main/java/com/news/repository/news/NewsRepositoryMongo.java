package com.news.repository.news;

import com.news.model.news.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepositoryMongo extends MongoRepository<News, String> {
}
