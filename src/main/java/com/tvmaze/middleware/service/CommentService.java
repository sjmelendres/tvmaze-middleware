package com.tvmaze.middleware.service;

import com.tvmaze.middleware.dto.CreateCommentRequest;
import com.tvmaze.middleware.repository.CommentRepository;
import com.tvmaze.middleware.mapper.CommentMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public void createComment(CreateCommentRequest request) {
        commentRepository.save(commentMapper.toDocument(request));
    }
}