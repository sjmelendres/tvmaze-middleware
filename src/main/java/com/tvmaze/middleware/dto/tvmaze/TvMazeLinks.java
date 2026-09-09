package com.tvmaze.middleware.dto.tvmaze;

public record TvMazeLinks(
        TvMazeLink self,
        TvMazeLink previousepisode
) {
}