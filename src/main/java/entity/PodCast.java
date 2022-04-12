package entity;

import java.sql.Time;

public class PodCast {
    int podCastID;
    String podcastName;
    String artistNamepod;
    String duration1;
    String createDate;
    String genre1;
    String url1;

    public PodCast(){}

    public PodCast(int podCastID, String podcastName, String artistNamepod, String duration1, String createDate, String genre1, String url1) {
        this.podCastID = podCastID;
        this.podcastName = podcastName;
        this.artistNamepod = artistNamepod;
        this.duration1 = duration1;
        this.createDate = createDate;
        this.genre1 = genre1;
        this.url1 = url1;
    }

    public int getPodCastID() {
        return podCastID;
    }

    public void setPodCastID(int podCastID) {
        this.podCastID = podCastID;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getArtistNamepod() {
        return artistNamepod;
    }

    public void setArtistNamepod(String artistNamepod) {
        this.artistNamepod = artistNamepod;
    }

    public String getDuration1() {
        return duration1;
    }

    public void setDuration1(String duration1) {
        this.duration1 = duration1;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    @Override
    public String toString() {
        return "PodCast{" +
                "podCastID=" + podCastID +
                ", podcastName='" + podcastName + '\'' +
                ", artistNamepod='" + artistNamepod + '\'' +
                ", duration1='" + duration1 + '\'' +
                ", createDate='" + createDate + '\'' +
                ", genre1='" + genre1 + '\'' +
                ", url1='" + url1 + '\'' +
                '}';
    }
}
