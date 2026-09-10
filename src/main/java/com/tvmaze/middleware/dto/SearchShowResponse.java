package com.tvmaze.middleware.dto;

import java.util.List;

public record SearchShowResponse(
        Long id,
        String name,
        String channel,
        String summary,
        List<String> genres,
        List<SearchCommentResponse> comments
) {
}