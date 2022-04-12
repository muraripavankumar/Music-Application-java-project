package entity;

import java.sql.Time;

public class Song {
    int songID;
    String songTitle;
    String artistName;
    String album;
    String genre;
    String duration;
    String url;

    public Song(){}

    public Song(int songID, String songTitle, String artistName, String album, String genre, String duration, String url) {
        this.songID = songID;
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
        this.url = url;
    }

    public int getSongID() {
        return songID;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getUrl() {
        return url;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songID=" + songID +
                ", songTitle='" + songTitle + '\'' +
                ", artistName='" + artistName + '\'' +
                ", album='" + album + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
