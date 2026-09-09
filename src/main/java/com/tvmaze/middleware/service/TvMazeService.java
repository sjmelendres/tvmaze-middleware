package com.tvmaze.middleware.service;

import com.tvmaze.middleware.client.TvMazeClient;
import com.tvmaze.middleware.document.TvMazeShowDocument;
import com.tvmaze.middleware.dto.SearchShowResponse;
import com.tvmaze.middleware.dto.tvmaze.TvMazeShow;
import com.tvmaze.middleware.dto.tvmaze.TvMazeShowDetail;
import com.tvmaze.middleware.repository.TvMazeShowRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvMazeService {

    private final TvMazeClient tvMazeClient;
    private final TvMazeShowRepository tvMazeShowRepository;

    public TvMazeService(TvMazeClient tvMazeClient, TvMazeShowRepository tvMazeShowRepository
    ) {
        this.tvMazeClient = tvMazeClient;
        this.tvMazeShowRepository = tvMazeShowRepository;
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
        return tvMazeShowRepository.findById(showId)
            .map(this::toShowDetail)
            .orElseGet(() -> {
                TvMazeShowDetail show = tvMazeClient.getShow(showId);
                tvMazeShowRepository.save(toDocument(show));
                return show;
            });
    }

    private TvMazeShowDetail toShowDetail(TvMazeShowDocument document) {
        return new TvMazeShowDetail(
            document.getId(),
            document.getUrl(),
            document.getName(),
            document.getType(),
            document.getLanguage(),
            document.getGenres(),
            document.getStatus(),
            document.getRuntime(),
            document.getAverageRuntime(),
            document.getPremiered(),
            document.getEnded(),
            document.getOfficialSite(),
            document.getSchedule(),
            document.getRating(),
            document.getWeight(),
            document.getNetwork(),
            document.getWebChannel(),
            document.getDvdCountry(),
            document.getExternals(),
            document.getImage(),
            document.getSummary(),
            document.getUpdated(),
            document.getLinks()
        );
    }

    private TvMazeShowDocument toDocument(TvMazeShowDetail show) {
        TvMazeShowDocument document = new TvMazeShowDocument();

        document.setId(show.id());
        document.setUrl(show.url());
        document.setName(show.name());
        document.setType(show.type());
        document.setLanguage(show.language());
        document.setGenres(show.genres());
        document.setStatus(show.status());
        document.setRuntime(show.runtime());
        document.setAverageRuntime(show.averageRuntime());
        document.setPremiered(show.premiered());
        document.setEnded(show.ended());
        document.setOfficialSite(show.officialSite());
        document.setSchedule(show.schedule());
        document.setRating(show.rating());
        document.setWeight(show.weight());
        document.setNetwork(show.network());
        document.setWebChannel(show.webChannel());
        document.setDvdCountry(show.dvdCountry());
        document.setExternals(show.externals());
        document.setImage(show.image());
        document.setSummary(show.summary());
        document.setUpdated(show.updated());
        document.setLinks(show.links());

        return document;
    }
}