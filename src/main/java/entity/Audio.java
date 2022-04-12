package entity;

public class Audio {
    int audioid;
    String audioType;
    int songid;
    int podcastid;

    public Audio(int audioid, String audioType, int songid, int podcastid) {
        this.audioid = audioid;
        this.audioType = audioType;
        this.songid = songid;
        this.podcastid = podcastid;
    }

    public int getAudioid() {
        return audioid;
    }

    public void setAudioid(int audioid) {
        this.audioid = audioid;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public int getPodcastid() {
        return podcastid;
    }

    public void setPodcastid(int podcastid) {
        this.podcastid = podcastid;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "audioid=" + audioid +
                ", audioType='" + audioType + '\'' +
                ", songid=" + songid +
                ", podcastid=" + podcastid +
                '}';
    }
}
