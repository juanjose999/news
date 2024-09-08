package com.news.service.comment;

import com.news.model.comment.Comment;
import com.news.model.dto.comment.CommentDto;
import com.news.model.dto.comment.CommentMapper;
import com.news.model.dto.comment.CommentResponseDto;
import com.news.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    public CommentRepository commentRepository;

    public CommentServiceImpl (CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    @Override
    public Optional<List<CommentResponseDto>> allComment() {
        Optional<List<Comment>> commentList = commentRepository.allComment();
        return commentList.map(comments ->
                comments.stream()
                        .map(CommentMapper::commentToCommentResponseDto)
                        .collect(Collectors.toList())
        );
    }


    @Override
    public CommentResponseDto addComment(CommentDto commentDto) {
        return CommentMapper.commentToCommentResponseDto((commentRepository.addComment(CommentMapper.CommentDtoToComment(commentDto))));
    }

    @Override
    public Boolean deleteCommentById(String idComment) {
        return commentRepository.deleteCommentById(idComment);
    }
}
