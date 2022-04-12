package Dao;

import entity.PodCast;
import entity.Song;
import Connection.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodCastDao {
    List<PodCast> list1=new ArrayList<>();
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

    public List<PodCast>  podCastRead() throws SQLException, ClassNotFoundException {

        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select * from podcast");
        ResultSet res=ps.executeQuery();
        while(res.next()){
            list1.add(new PodCast(res.getInt(1),res.getString(2),
                    res.getString(3),res.getString(4),res.getString(5),
                   res.getString(6), res.getString(7)));
        }
        return list1;
    }

}
