package com.news.controller;

import com.news.model.dto.news.NewsDto;
import com.news.model.news.News;
import com.news.repository.comment.CommentsRepositoryMongo;
import com.news.repository.comparison.ComparisonRepositoryMongo;
import com.news.repository.news.NewsRepositoryMongo;
import com.news.service.news.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/news")
public class NewsController {

    public final NewsService newsRepositoryMongo;

    @GetMapping
    public ResponseEntity<?> allNews (){
        return new ResponseEntity(newsRepositoryMongo.allNotice(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findNewsById(@PathVariable String id){
        return new ResponseEntity<>(newsRepositoryMongo.findNoticeById(id),HttpStatusCode.valueOf(200));
    }
    @PostMapping()
    public ResponseEntity<?> saveNews (@RequestBody NewsDto newsDto){
        return new ResponseEntity<>(newsRepositoryMongo.addNotice(newsDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("{id}")
    public boolean deleteNews (@PathVariable String id){
        return newsRepositoryMongo.deleteNoticeById(id);
    }
}
