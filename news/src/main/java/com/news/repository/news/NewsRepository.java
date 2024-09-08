package com.news.repository.news;

import com.news.model.news.News;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {
    Optional<List<News>> allNotice();
    Optional<News> findNoticeById(String idNotice);
    News addNotice(News news);
    Boolean deleteNoticeById(String idNotice);
}
