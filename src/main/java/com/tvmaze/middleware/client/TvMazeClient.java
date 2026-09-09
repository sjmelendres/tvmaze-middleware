package com.tvmaze.middleware.client;

import com.tvmaze.middleware.dto.tvmaze.TvMazeSearchItem;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Component
public class TvMazeClient {

    private final RestClient restClient;

    public TvMazeClient(RestClient.Builder restClientBuilder, @Value("${tvmaze.baseUrl}") String baseUrl) {
        this.restClient = restClientBuilder
                .baseUrl(baseUrl)
                .build();
    }

    public List<TvMazeSearchItem> search(String query) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/shows")
                        .queryParam("q", query)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}