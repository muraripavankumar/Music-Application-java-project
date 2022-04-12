package Dao;

import entity.PodCast;
import entity.User;
import Connection.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao {
    Scanner scan=new Scanner(System.in);
    List<User> list1=new ArrayList<>();
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

    public void insertUser() throws SQLException {
        System.out.println("Enter Your Name");
        String name = scan.next();

        System.out.println("Enter Your password");
        String password = scan.next();

        System.out.println("Enter Your MobileNo");
        String mobile = scan.next();

        System.out.println("Enter Your EmailId");
        String email = scan.next();

        System.out.println(" Enter Your age");
        int age = scan.nextInt();

        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?);");
        ps.setInt(1,UserDao.generateUserid());
        ps.setString(2,password);
        ps.setString(3,name);
        ps.setString(4,mobile);
        ps.setString(5,email);
        ps.setInt(6,age);
        int rowsaffected = ps.executeUpdate();
        if (rowsaffected != 0) {
            System.out.println("Your Account created sucussfully");
        }
    }
    public static int generateUserid()
    {
        int min = 0;
        int max = 999999999;
        int accountNumberGenrate = (int) (Math.random()*(max-min)+min);
        return accountNumberGenrate;
    }

    public List<User>  userRead() throws SQLException, ClassNotFoundException {

        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select * from user");
        ResultSet res=ps.executeQuery();
        while(res.next()){
            list1.add(new User(res.getInt(1),res.getString(2),
                    res.getString(3),res.getString(4),res.getString(5),
                    res.getInt(6)));
        }
        return list1;
    }
}
