package operation;

import entity.Audio;
import entity.Playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PlayListOperation {

    public void display1(List<Playlist> displayby ){

        Consumer<Playlist> dis= d->System.out.println(d);

        displayby.stream().forEach(dis);
    }


    public void display(List<Audio> displayby ){

        Consumer<Audio> dis= d->System.out.println(d);

        displayby.stream().forEach(dis);
    }
}
