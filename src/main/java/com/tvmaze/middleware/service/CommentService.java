package com.tvmaze.middleware.service;

import com.tvmaze.middleware.dto.CommentResponse;
import com.tvmaze.middleware.dto.CreateCommentRequest;
import com.tvmaze.middleware.mapper.CommentMapper;
import com.tvmaze.middleware.repository.CommentRepository;
import org.springframework.stereotype.Service;
import com.tvmaze.middleware.dto.SearchCommentResponse;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final ShowService showService;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, ShowService showService
    ) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.showService = showService;
    }

    public void createComment(CreateCommentRequest request) {
        showService.getShow(request.showId());

        commentRepository.save(commentMapper.toDocument(request));
    }

    public List<CommentResponse> getCommentsByShowId(Long showId) {
        return commentRepository.findByShowId(showId)
            .stream()
            .map(commentMapper::toResponse)
            .toList();
    }

    public List<SearchCommentResponse> getSearchCommentsByShowId(Long showId) {
        return commentRepository.findByShowId(showId)
            .stream()
            .map(comment -> new SearchCommentResponse(
                    comment.getComment(),
                    comment.getRating()
            ))
            .toList();
    }
}