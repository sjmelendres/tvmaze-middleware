package com.tvmaze.middleware.dto;

public record SearchCommentResponse(
        String comment,
        Integer rating
) {
}