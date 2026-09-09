package com.tvmaze.middleware.dto.tvmaze;

public record TvMazeNetworkDetail(
        Long id,
        String name,
        TvMazeCountry country,
        String officialSite
) {
}