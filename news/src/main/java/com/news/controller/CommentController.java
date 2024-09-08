package com.news.controller;

import com.news.model.comment.Comment;
import com.news.model.dto.comment.CommentDto;
import com.news.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    public CommentController (CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping()
    public ResponseEntity<?> allComments(){
        return new ResponseEntity<>(commentService.allComment(),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> save (@RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.addComment(commentDto), HttpStatus.OK);
    }
}
