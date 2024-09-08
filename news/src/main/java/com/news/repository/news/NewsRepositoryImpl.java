package com.news.repository.news;

import com.news.model.news.News;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class NewsRepositoryImpl implements NewsRepository{
    @Autowired
    public final NewsRepositoryMongo newsRepositoryMongo;

    public NewsRepositoryImpl(NewsRepositoryMongo newsRepositoryMongo) {
        this.newsRepositoryMongo = newsRepositoryMongo;
    }

    @Override
    public Optional<List<News>> allNotice() {
        return Optional.of(newsRepositoryMongo.findAll());
    }

    @Override
    public Optional<News> findNoticeById(String idNotice) {
        return newsRepositoryMongo.findById(idNotice);
    }

    @Override
    public News addNotice(News news) {
        return newsRepositoryMongo.save(news);
    }

    @Override
    public Boolean deleteNoticeById(String idNotice) {
        Optional<News> findNews = findNoticeById(idNotice);
        if(findNews.isPresent()){
            newsRepositoryMongo.deleteById(idNotice);
            return true;
        }
        return false;
    }
}
