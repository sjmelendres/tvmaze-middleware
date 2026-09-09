package com.tvmaze.middleware.dto.tvmaze;

import java.util.List;

public record TvMazeSchedule(
        String time,
        List<String> days
) {
}