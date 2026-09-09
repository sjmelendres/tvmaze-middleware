package com.tvmaze.middleware.controller;

import com.tvmaze.middleware.dto.tvmaze.TvMazeShowDetail;
import com.tvmaze.middleware.service.TvMazeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    private final TvMazeService tvMazeService;

    public ShowController(TvMazeService tvMazeService) {
        this.tvMazeService = tvMazeService;
    }

    @GetMapping("/show/{showId}")
    public TvMazeShowDetail getShow(@PathVariable Long showId) {
        return tvMazeService.getShow(showId);
    }
}