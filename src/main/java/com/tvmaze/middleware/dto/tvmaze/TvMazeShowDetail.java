package com.tvmaze.middleware.dto.tvmaze;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tvmaze.middleware.dto.CommentResponse;

public record TvMazeShowDetail(
        Long id,
        String url,
        String name,
        String type,
        String language,
        List<String> genres,
        String status,
        Integer runtime,
        Integer averageRuntime,
        String premiered,
        String ended,
        String officialSite,
        TvMazeSchedule schedule,
        TvMazeRating rating,
        Integer weight,
        TvMazeNetworkDetail network,
        TvMazeWebChannelDetail webChannel,
        TvMazeCountry dvdCountry,
        TvMazeExternals externals,
        TvMazeImage image,
        String summary,
        Long updated,
        @JsonProperty("_links")
        TvMazeLinks links,
        List<CommentResponse> comments
) {
}