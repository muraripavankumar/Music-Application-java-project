package operation;

import entity.Song;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SongOperation {
    List<Song> list=new ArrayList<>();
    public boolean addSongList(Song song) {
        list.add(song);
        return true;
    }


    public List<Song> searchbyartistid(List<Song> allsonglist, String artistName) {

            List<Song> sa = new ArrayList<>();

            Optional filter = allsonglist.stream().filter(p -> p.getArtistName().equalsIgnoreCase(artistName)).findAny();

            if (filter.isPresent()) {

                sa = allsonglist.stream().filter(p -> p.getArtistName().equalsIgnoreCase(artistName)).collect(Collectors.toList());
            }
            else
            {
                System.out.println("no such artistname exist");
            }
            return sa;
        }
    public List<Song> searchbygenre(List<Song> allsonglist, String genre) {

        List<Song> sa = new ArrayList<>();

        Optional filter = allsonglist.stream().filter(p -> p.getGenre().equalsIgnoreCase(genre)).findAny();

        if (filter.isPresent()) {

            sa = allsonglist.stream().filter(p -> p.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("no such genre exist");
        }
        return sa;
    }

        public List<Song> searchbyalbum(List<Song> allsonglist, String album_name) {
            List<Song> sa = new ArrayList<>();
            Optional filter = allsonglist.stream().filter(p -> p.getAlbum().equalsIgnoreCase(album_name)).findAny();
            if (filter.isPresent()) {
                sa = allsonglist.stream().filter(p -> p.getAlbum().equalsIgnoreCase(album_name)).collect(Collectors.toList());
            }
            else
            {
                System.out.println("no such album name exist");
            }
            return sa;
        }


        public List<Song> searchbysong(List<Song> allsonglist, String song_name) {
            List<Song> sa = new ArrayList<>();
            Optional filter = allsonglist.stream().filter(p -> p.getSongTitle().equalsIgnoreCase(song_name)).findAny();
            if (filter.isPresent()) {
                sa = allsonglist.stream().filter(p -> p.getSongTitle().equalsIgnoreCase(song_name)).collect(Collectors.toList());
            }
            else
            {
                System.out.println("no such song name exist");
            }
            return sa;
        }

        public void display(List<Song> allsongsList) {

            Consumer<Song> dis=d->System.out.println(d);

            allsongsList.stream().forEach(dis);
        }
    }
