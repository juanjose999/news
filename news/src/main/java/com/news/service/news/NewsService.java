package com.news.service.news;

import com.news.model.dto.news.NewsDto;
import com.news.model.dto.news.NewsResponseDto;
import com.news.model.news.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    Optional<List<NewsResponseDto>> allNotice();
    NewsResponseDto findNoticeById(String idNotice);
    NewsResponseDto addNotice(NewsDto newsDto);
    Boolean deleteNoticeById(String idNotice);
}
