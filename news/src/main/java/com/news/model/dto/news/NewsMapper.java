package com.news.model.dto.news;

import com.news.model.comparison.Comparison;
import com.news.model.dto.comparison.ComparisonMapper;
import com.news.model.dto.comparison.ComparisonResponseDto;
import com.news.model.news.News;

import java.util.ArrayList;
import java.util.List;

public class NewsMapper {

    public static News neswDtoToNews(NewsDto newsDto){
        Comparison comparison = ComparisonMapper.ComparisonDtoToComparison(newsDto.getComparisonDto());
        return new News(
                newsDto.getTitle(),
                newsDto.getContent(),
                newsDto.getCover_image(),
                newsDto.getLink_news(),
                newsDto.getIdeologyNews(),
                comparison
        );
    }

    public static List<NewsResponseDto> newsToNewsResponseDto (List<News> news){
        List<NewsResponseDto> newsResponseDtos = new ArrayList<>();
        for(News n : news){
            NewsResponseDto nueva = new NewsResponseDto();
            nueva.setTitle(n.getTitle());
            nueva.setContent(n.getContent());
            nueva.setCover_image(n.getCover_image());
            nueva.setLink_news(n.getLink_news());
            nueva.setIdeologyNews(n.getIdeologyNews());
            newsResponseDtos.add(nueva);
        }
        return newsResponseDtos;
    }

    public static NewsResponseDto newToNewsResponseDto(News news){
        return new NewsResponseDto(
                news.getTitle(),
                news.getContent(),
                news.getCover_image(),
                news.getLink_news(),
                news.getIdeologyNews()
        );
    }

}
