package com.tvmaze.middleware.document;

import com.tvmaze.middleware.dto.tvmaze.TvMazeCountry;
import com.tvmaze.middleware.dto.tvmaze.TvMazeExternals;
import com.tvmaze.middleware.dto.tvmaze.TvMazeImage;
import com.tvmaze.middleware.dto.tvmaze.TvMazeLinks;
import com.tvmaze.middleware.dto.tvmaze.TvMazeNetworkDetail;
import com.tvmaze.middleware.dto.tvmaze.TvMazeRating;
import com.tvmaze.middleware.dto.tvmaze.TvMazeSchedule;
import com.tvmaze.middleware.dto.tvmaze.TvMazeWebChannelDetail;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "shows")
public class TvMazeShowDocument {

    @Id
    private Long id;

    private String url;
    private String name;
    private String type;
    private String language;
    private List<String> genres;
    private String status;
    private Integer runtime;
    private Integer averageRuntime;
    private String premiered;
    private String ended;
    private String officialSite;
    private TvMazeSchedule schedule;
    private TvMazeRating rating;
    private Integer weight;
    private TvMazeNetworkDetail network;
    private TvMazeWebChannelDetail webChannel;
    private TvMazeCountry dvdCountry;
    private TvMazeExternals externals;
    private TvMazeImage image;
    private String summary;
    private Long updated;
    private TvMazeLinks links;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public Integer getAverageRuntime() {
        return averageRuntime;
    }

    public void setAverageRuntime(Integer averageRuntime) {
        this.averageRuntime = averageRuntime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public TvMazeSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(TvMazeSchedule schedule) {
        this.schedule = schedule;
    }

    public TvMazeRating getRating() {
        return rating;
    }

    public void setRating(TvMazeRating rating) {
        this.rating = rating;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public TvMazeNetworkDetail getNetwork() {
        return network;
    }

    public void setNetwork(TvMazeNetworkDetail network) {
        this.network = network;
    }

    public TvMazeWebChannelDetail getWebChannel() {
        return webChannel;
    }

    public void setWebChannel(TvMazeWebChannelDetail webChannel) {
        this.webChannel = webChannel;
    }

    public TvMazeCountry getDvdCountry() {
        return dvdCountry;
    }

    public void setDvdCountry(TvMazeCountry dvdCountry) {
        this.dvdCountry = dvdCountry;
    }

    public TvMazeExternals getExternals() {
        return externals;
    }

    public void setExternals(TvMazeExternals externals) {
        this.externals = externals;
    }

    public TvMazeImage getImage() {
        return image;
    }

    public void setImage(TvMazeImage image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public TvMazeLinks getLinks() {
        return links;
    }

    public void setLinks(TvMazeLinks links) {
        this.links = links;
    }
}