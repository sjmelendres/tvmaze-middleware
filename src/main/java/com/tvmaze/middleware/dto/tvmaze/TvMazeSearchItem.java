package com.tvmaze.middleware.dto.tvmaze;

public record TvMazeSearchItem(
        Double score,
        TvMazeShow show
) {
}