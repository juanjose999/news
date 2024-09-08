package com.news.repository.comparison;

import com.news.model.comparison.Comparison;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComparisonRepositoryMongo extends MongoRepository<Comparison,String> {
    
}
