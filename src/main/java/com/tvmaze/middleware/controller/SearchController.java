package com.tvmaze.middleware.controller;

import com.tvmaze.middleware.dto.SearchShowResponse;
import com.tvmaze.middleware.service.TvMazeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@RestController
public class SearchController {

    private final TvMazeService tvMazeService;

    public SearchController(TvMazeService tvMazeService) {
        this.tvMazeService = tvMazeService;
    }

    @GetMapping("/search")
    public List<SearchShowResponse> search(
        @RequestParam("search_query")
        @NotBlank
        String query
    ) {
        return tvMazeService.search(query);
    }
}