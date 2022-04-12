package Dao;

import entity.*;
import operation.PlayListOperation;
import operation.PodCastOperation;
import operation.SongOperation;
import operation.UserOperations;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Connection.Connector;
public class MainClass {

    public static void main(String[] args) throws ParseException, IOException, SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException {
        Connection con;
            try {
                con = Connector.establishConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        int y;
        do {
            UserDao user1 = new UserDao();
            System.out.println(" //------------------WELCOME TO MUSIC WINK-----------------------");
            System.out.println("press 1 NEW USER \nPress 2 EXISTING USER ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    user1.insertUser();
                    break;
                case 2:
                    System.out.println("Enter your userid");
                    int userid=sc.nextInt();
                    System.out.println("Enter your password");
                    String password=sc.next();
                    UserOperations uo=new UserOperations();
                    List<User> allUsersList=user1.userRead();
                    if(uo.validateUser(allUsersList,userid,password)==true)
                    {
                        int z;
                        do {
                            System.out.println("Please select the Task number \n1:Songs \n2:Podcast \n3:Audio \n4:Playlist");
                            int choice5 = sc.nextInt();
                            switch (choice5) {
                                case 1:
                                    SongDao sd = new SongDao();
                                    SongOperation so = new SongOperation();
                                    List<Song> allsongsList = sd.songRead();
                                    so.display(allsongsList);
                                    System.out.print("1.to view all songs  \n2.Search songs by artistname " +
                                            "\n3.Search songs by album name" +
                                            "\n4.Search songs by song name");
                                    int choice1 = sc.nextInt();
                                    switch (choice1) {
                                        case 1:
                                            so.display(allsongsList);
                                            break;
                                        case 2:
                                            System.out.println(" Enter Artist Name");
                                            String artistName = sc.next();
                                            List<Song> searchartistName = so.searchbyartistid(allsongsList,artistName);
                                            so.display(searchartistName);
                                            break;
                                        case 3:
                                            System.out.println(" Enter Album Name");
                                            String album_name = sc.next();
                                            List<Song> searchbyalbum = so.searchbyalbum(allsongsList, album_name);
                                            so.display(searchbyalbum);
                                            break;
                                        case 4:
                                            System.out.println(" Enter Song Name");
                                            String song_name = sc.next();
                                            List<Song> searchandsortbysong = so.searchbysong(allsongsList, song_name);
                                            so.display(searchandsortbysong);
                                            break;
                                        default:
                                            System.out.println("Match not found");
                                    }
                                    break;

                                case 2:
                                    PodCastDao pd = new PodCastDao();
                                    PodCastOperation po = new PodCastOperation();
                                    List<PodCast> allPodCastList = pd.podCastRead();
                                    po.display(allPodCastList);
                                    System.out.print("1.to view all Podcasts  \n2.Search podcast by creation Date \n3.Search podcast by genre");
                                    int choice2 = sc.nextInt();
                                    switch (choice2) {
                                        case 1:
                                            po.display(allPodCastList);
                                            break;
                                        case 2:
                                            System.out.println(" Enter the creation date");
                                            String createDate = sc.next();
                                            List<PodCast> searchByCreatdate = po.searchbyCreatDate(allPodCastList, createDate);
                                            po.display(searchByCreatdate);
                                            break;
                                        case 3:
                                            System.out.println(" Enter the genre");
                                            String genre = sc.next();
                                            List<PodCast> searchBygenre = po.searchbyCreatDate(allPodCastList,genre);
                                            po.display(searchBygenre);
                                            break;
                                        default:
                                            System.out.println("Match not found");
                                    }
                                    break;
                                case 3:
                                    List<Audio> audio=AudioDao.getAllAudio();
                                    PlayListOperation plo=new PlayListOperation();
                                    plo.display(audio);
                                    break;
                                case 4:
                                    System.out.println("enter userId");
                                    int userId=sc.nextInt();
                                    List<Playlist> play=PlaylistDao.getAllPlaylist(userId);
                                    PlayListOperation plo1=new PlayListOperation();
                                    plo1.display1(play);
                                    System.out.println("Enter PlayListId That you want to see");
                                    int playid=sc.nextInt();
                                    PlaylistDao.playPlayList(userId,playid);
                                    // PlaylistOperation.display(playRecords);
                                    break;
                                    default:
                                        System.out.println("enter correct choice");
                                    }
                            System.out.println("Do you want to continue\tyes press 1|\tNo press 2");
                            Scanner scan = new Scanner(System.in);
                            z = scan.nextInt();
                            }while (z == 1);
                        }
                        break;
                    }
            System.out.println("Do you want to continue\tyes press 1|\tNo press 2");
            Scanner scan = new Scanner(System.in);
            y = scan.nextInt();
            } while (y == 1);
    }
}
