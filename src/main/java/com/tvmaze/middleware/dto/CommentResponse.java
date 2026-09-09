package com.tvmaze.middleware.dto;

public record CommentResponse(
    String id,
    Long showId,
    String comment,
    Integer rating
) {
}