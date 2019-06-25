package com.talkao.lopezcorominas.data.net.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Jesús López Corominas
 */
public class SongDto {

    private String artistName;
    private String collectionName;
    private String trackName;

    @SerializedName("previewUrl")
    private String url;

    @SerializedName("artworkUrl100")
    private String thumbnail;


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
