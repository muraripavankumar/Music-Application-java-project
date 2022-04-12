package Dao;
import Connection.Connector;
import entity.Audio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AudioDao {
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
    public static List<Audio> getAllAudio() throws SQLException
    {
        String query = "select * from audio";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Audio> audioList = new ArrayList();

        while (rs.next()) {
            Audio audio = new Audio(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4));
            audioList.add(audio);
        }
        return audioList;
    }
}
