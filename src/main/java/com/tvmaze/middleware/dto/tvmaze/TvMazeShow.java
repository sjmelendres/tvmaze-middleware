package com.tvmaze.middleware.dto.tvmaze;

import java.util.List;

public record TvMazeShow(
        Long id,
        String name,
        List<String> genres,
        TvMazeNetwork network,
        TvMazeWebChannel webChannel,
        String summary
) {
}