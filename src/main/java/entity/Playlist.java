package entity;

public class Playlist {
    int playListid;
    String playListName;
    int userid;
    int audioID;

    public Playlist(){}

    public Playlist(int playListid, String playListName, int userid, int audioID) {
        this.playListid = playListid;
        this.playListName = playListName;
        this.userid = userid;
        this.audioID = audioID;
    }

    public int getPlayListid() {
        return playListid;
    }

    public void setPlayListid(int playListid) {
        this.playListid = playListid;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getAudioID() {
        return audioID;
    }

    public void setAudioID(int audioID) {
        this.audioID = audioID;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playListid=" + playListid +
                ", playListName='" + playListName + '\'' +
                ", userid=" + userid +
                ", audioID=" + audioID +
                '}';
    }
}
