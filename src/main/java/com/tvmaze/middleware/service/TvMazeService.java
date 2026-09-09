package com.tvmaze.middleware.service;

import com.tvmaze.middleware.client.TvMazeClient;
import com.tvmaze.middleware.dto.SearchShowResponse;
import com.tvmaze.middleware.dto.tvmaze.TvMazeShow;
import com.tvmaze.middleware.dto.tvmaze.TvMazeShowDetail;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvMazeService {

    private final TvMazeClient tvMazeClient;

    public TvMazeService(TvMazeClient tvMazeClient) {
        this.tvMazeClient = tvMazeClient;
    }

    public List<SearchShowResponse> search(String query) {
        return tvMazeClient.search(query)
            .stream()
            .map(item -> new SearchShowResponse(
                    item.show().id(),
                    item.show().name(),
                    getChannel(item.show()),
                    item.show().summary(),
                    item.show().genres()
            ))
            .toList();
    }

    private String getChannel(TvMazeShow show) {
        if (show.network() != null) {
            return show.network().name();
        }

        if (show.webChannel() != null) {
            return show.webChannel().name();
        }

        return null;
    }

    public TvMazeShowDetail getShow(Long showId) {
        return tvMazeClient.getShow(showId);
    }
}