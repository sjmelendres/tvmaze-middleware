package com.tvmaze.middleware.dto.tvmaze;

public record TvMazeWebChannelDetail(
        Long id,
        String name,
        TvMazeCountry country,
        String officialSite
) {
}