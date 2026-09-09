package com.tvmaze.middleware.mapper;

import com.tvmaze.middleware.document.TvMazeShowDocument;
import com.tvmaze.middleware.dto.tvmaze.TvMazeShowDetail;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TvMazeShowMapper {

    public TvMazeShowDetail toShowDetail(TvMazeShowDocument document) {
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
            document.getLinks(),
            List.of()
        );
    }

    public TvMazeShowDocument toDocument(TvMazeShowDetail show) {
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