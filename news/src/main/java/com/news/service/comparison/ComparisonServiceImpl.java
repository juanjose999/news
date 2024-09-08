package com.news.service.comparison;

import com.news.model.comment.Comment;
import com.news.model.comparison.Comparison;
import com.news.model.dto.comment.CommentDto;
import com.news.model.dto.comment.CommentMapper;
import com.news.model.dto.comment.CommentResponseDto;
import com.news.model.dto.comparison.ComparisonDto;
import com.news.model.dto.comparison.ComparisonMapper;
import com.news.model.dto.comparison.ComparisonResponseDto;
import com.news.model.dto.news.NewsDto;
import com.news.model.dto.news.NewsMapper;
import com.news.model.dto.news.NewsResponseDto;
import com.news.model.news.News;
import com.news.repository.comment.CommentRepository;
import com.news.repository.comparison.ComparisonRepository;
import com.news.repository.news.NewsRepository;
import com.news.service.comment.CommentService;
import com.news.service.news.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ComparisonServiceImpl implements ComparisonService {

    public final ComparisonRepository comparisonRepository;
    public final NewsRepository newsRepository;
    public final CommentRepository commentRepository;
    @Override
    public Optional<List<ComparisonResponseDto>> allComparison() {
        return comparisonRepository.allComparison()
                .map(comparisonList -> comparisonList.stream()
                        .map(ComparisonMapper::comparisonToComparisonResponseDto)
                        .toList());
    }

    @Override
    public ComparisonResponseDto findComparisonById(String idComparison) {
        Comparison comparison = comparisonRepository.findComparisonById(idComparison).orElseThrow(()->new NoSuchElementException("comparison not found."));
        return ComparisonMapper.comparisonToComparisonResponseDto(comparison);
    }

    @Override
    public ComparisonResponseDto addComparison(ComparisonDto comparison) {
        Comparison comparisonTest =new Comparison();
        comparisonRepository.addComparison(comparisonTest);


        List<NewsDto> newsNotAdd = comparison.getNewsDto();
        List<News> newsSaved = new ArrayList<>();
        for (NewsDto n : newsNotAdd) {
            News newsToAdd = new News();
            newsToAdd.setTitle(n.getTitle());
            newsToAdd.setContent(n.getContent());
            newsToAdd.setCover_image(n.getCover_image());
            newsToAdd.setLink_news(n.getLink_news());
            newsToAdd.setIdeologyNews(n.getIdeologyNews());
            newsToAdd.setComparison(comparisonTest);
            News savedNews = newsRepository.addNotice(newsToAdd);
            newsSaved.add(savedNews);
        }

        CommentDto commentNew = comparison.getCommentDto();
        Comment comment = new Comment();
        if(commentNew!=null){
            comment = CommentMapper.CommentDtoToComment(commentNew);
            comment.setComparison(comparisonTest);
        }
        commentRepository.addComment(comment);
        comparisonTest.setComment(comment);
        comparisonTest.setNews(newsSaved);
        comparisonRepository.addComparison(comparisonTest);

        ComparisonResponseDto comparisonResponseDto = new ComparisonResponseDto();

        CommentResponseDto commentDto2 = new CommentResponseDto();
        commentDto2.setTitle(comparisonTest.getComment().getTitle());
        commentDto2.setContent(comparisonTest.getComment().getContent());

        comparisonResponseDto.setComment(commentDto2);
        comparisonResponseDto.setNews(NewsMapper.newsToNewsResponseDto(comparisonTest.getNews()));
        return comparisonResponseDto;
    }

    @Override
    public Boolean deleteComparisonById(String idComparison) {
        return comparisonRepository.deleteComparisonById(idComparison);
    }

    @Override
    public Boolean deleteAllComparison() {
        comparisonRepository.deleteAllComparison();
        return true;
    }
}
