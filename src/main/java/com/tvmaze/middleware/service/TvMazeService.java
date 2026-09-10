package com.tvmaze.middleware.service;

import com.tvmaze.middleware.client.TvMazeClient;
import com.tvmaze.middleware.dto.CommentResponse;
import com.tvmaze.middleware.dto.SearchShowResponse;
import com.tvmaze.middleware.dto.tvmaze.TvMazeShow;
import com.tvmaze.middleware.dto.tvmaze.TvMazeShowDetail;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvMazeService {

    private final TvMazeClient tvMazeClient;
    private final CommentService commentService;
    private final ShowService showService;

    public TvMazeService(TvMazeClient tvMazeClient, CommentService commentService, ShowService showService) {
        this.tvMazeClient = tvMazeClient;
        this.commentService = commentService;
        this.showService = showService;
    }

    public List<SearchShowResponse> search(String query) {
        return tvMazeClient.search(query)
            .stream()
            .map(item -> new SearchShowResponse(
            item.show().id(),
            item.show().name(),
            getChannel(item.show()),
            item.show().summary(),
            item.show().genres(),
            commentService.getSearchCommentsByShowId(item.show().id())
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
        TvMazeShowDetail show = showService.getShow(showId);

        List<CommentResponse> comments = commentService.getCommentsByShowId(showId);

        return new TvMazeShowDetail(
            show.id(),
            show.url(),
            show.name(),
            show.type(),
            show.language(),
            show.genres(),
            show.status(),
            show.runtime(),
            show.averageRuntime(),
            show.premiered(),
            show.ended(),
            show.officialSite(),
            show.schedule(),
            show.rating(),
            show.weight(),
            show.network(),
            show.webChannel(),
            show.dvdCountry(),
            show.externals(),
            show.image(),
            show.summary(),
            show.updated(),
            show.links(),
            comments
        );
    }
}