package Dao;

import entity.Playlist;

import Connection.Connector;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistDao {

    static Connection con;

    static {
        try {
            con = Connector.establishConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public static List<Playlist> getAllPlaylist(int userId) throws SQLException
    {
        String query = "select *from playlist where userID=?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        List<Playlist> play = new ArrayList();

        while (rs.next()) {
            Playlist playlist = new Playlist(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getInt(4));
            play.add(playlist);
        }
        return play;
    }

    public int addsong(String audioId,String playlistName,String playId) throws SQLException
    {
        String query
                = "insert into playlistrecords(audioId,audiotype,playlistId ) VALUES (?,?,?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, audioId);
        ps.setString(2,playlistName );
        ps.setString(3,playId );
        int n = ps.executeUpdate();
        return n;
    }
    public static void playPlayList(int userId,int playlistID) throws SQLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        String query="select songid,songtitle,url from song where songid in" +
                "(select songsid from audio where audioid in" +
                "(select audioid from playlistrecords where playlistId=?))";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, playlistID);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String url = rs.getString(3);
            Scanner scanner = new Scanner(System.in);
            File file = null;
            file = new File(url);

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

            System.out.println("Now playing\n" + rs.getString(2));
            System.out.println();
            int response=0;
            clip.start();
            while (!(response ==6)) {
                System.out.println("1 = play, 2 = Stop, 3 = Reset, 4 = close, 5=Loop, 6=nextsong/quit");
                System.out.print("Enter your choice: ");
                response = scanner.nextInt();
                int i = 5;
                switch (response) {
                    case 1:
                        clip.start();

                        break;
                    case 2:
                        clip.stop();
                        break;
                    case 3:
                        clip.setMicrosecondPosition(0);
                        break;
                    case 4:
                        clip.close();
                        break;

                    case 5:
                        clip.loop(5);
                        break;
                }
            }
        }
    }
    

    public List<Playlist>  readPlayList() throws SQLException, ClassNotFoundException {
        List<Playlist> list2=new ArrayList<>();
        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select *from playlist;");
        ResultSet res=ps.executeQuery();
        while(res.next()){
            list2.add(new Playlist(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4)));
        }
        return list2;
    }


}
