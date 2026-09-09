package com.tvmaze.middleware.mapper;

import com.tvmaze.middleware.document.CommentDocument;
import com.tvmaze.middleware.dto.CreateCommentRequest;
import org.springframework.stereotype.Component;
import com.tvmaze.middleware.dto.CommentResponse;

@Component
public class CommentMapper {

    public CommentResponse toResponse(CommentDocument document) {
        return new CommentResponse(
            document.getId(),
            document.getShowId(),
            document.getComment(),
            document.getRating()
        );
    }

    public CommentDocument toDocument(CreateCommentRequest request) {
        CommentDocument document = new CommentDocument();

        document.setShowId(request.showId());
        document.setComment(request.comment());
        document.setRating(request.rating());

        return document;
    }
}