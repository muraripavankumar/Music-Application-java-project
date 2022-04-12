package Dao;

import Connection.Connector;
import entity.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDao {
    List<Song> list=new ArrayList<>();
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

    //crud operations
    public List<Song>  songRead() throws SQLException, ClassNotFoundException {

        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select * from song");
        ResultSet res=ps.executeQuery();
        while(res.next()){
            list.add(new Song(res.getInt(1),res.getString(2),
                    res.getString(3),res.getString(4),res.getString(5),
                    res.getString(6),res.getString(7)));
        }
        return list;
    }
}
