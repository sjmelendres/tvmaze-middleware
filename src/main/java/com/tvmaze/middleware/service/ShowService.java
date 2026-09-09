package com.tvmaze.middleware.service;

import com.tvmaze.middleware.client.TvMazeClient;
import com.tvmaze.middleware.dto.tvmaze.TvMazeShowDetail;
import com.tvmaze.middleware.mapper.TvMazeShowMapper;
import com.tvmaze.middleware.repository.TvMazeShowRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    private final TvMazeClient tvMazeClient;
    private final TvMazeShowRepository tvMazeShowRepository;
    private final TvMazeShowMapper tvMazeShowMapper;

    public ShowService(
            TvMazeClient tvMazeClient,
            TvMazeShowRepository tvMazeShowRepository,
            TvMazeShowMapper tvMazeShowMapper
    ) {
        this.tvMazeClient = tvMazeClient;
        this.tvMazeShowRepository = tvMazeShowRepository;
        this.tvMazeShowMapper = tvMazeShowMapper;
    }

    public TvMazeShowDetail getShow(Long showId) {
        return tvMazeShowRepository.findById(showId)
                .map(tvMazeShowMapper::toShowDetail)
                .orElseGet(() -> {
                    TvMazeShowDetail show = tvMazeClient.getShow(showId);
                    tvMazeShowRepository.save(tvMazeShowMapper.toDocument(show));
                    return show;
                });
    }
}