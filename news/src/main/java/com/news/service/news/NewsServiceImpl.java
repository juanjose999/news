package com.news.service.news;

import com.news.model.dto.news.NewsDto;
import com.news.model.dto.news.NewsMapper;
import com.news.model.dto.news.NewsResponseDto;
import com.news.model.news.News;
import com.news.repository.news.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    public final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public Optional<List<NewsResponseDto>> allNotice() {
        Optional<List<News>> newsList = newsRepository.allNotice();
        return newsList.map(news -> news.stream()
                .map(NewsMapper::newToNewsResponseDto)
                .toList());
    }

    @Override
    public NewsResponseDto findNoticeById(String idNotice) {
        News news = newsRepository.findNoticeById(idNotice).orElseThrow(()->new NoSuchElementException("news not found"));
        return NewsMapper.newToNewsResponseDto(news);

    }

    @Override
    public NewsResponseDto addNotice(NewsDto newsDto) {
        return NewsMapper.newToNewsResponseDto(newsRepository.addNotice(NewsMapper.neswDtoToNews(newsDto)));
    }

    @Override
    public Boolean deleteNoticeById(String idNotice) {
        return newsRepository.deleteNoticeById(idNotice);
    }
}
