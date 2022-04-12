package operation;

import entity.PodCast;
import entity.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PodCastOperation {
    public List<PodCast> searchbyCreatDate(List<PodCast> allPodCastlist, String date) {

        List<PodCast> sa = new ArrayList<>();

        Optional filter = allPodCastlist.stream().filter(p -> p.getCreateDate().equalsIgnoreCase(date)).findAny();

        if (filter.isPresent()) {

            sa = allPodCastlist.stream().filter(p -> p.getCreateDate().equalsIgnoreCase(date)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("No such podCast is present");
        }
        return sa;
    }
    public List<PodCast> searchbygenre(List<PodCast> allPodCastlist, String genre) {

        List<PodCast> sa = new ArrayList<>();

        Optional filter = allPodCastlist.stream().filter(p -> p.getGenre1().equalsIgnoreCase(genre)).findAny();

        if (filter.isPresent()) {

            sa = allPodCastlist.stream().filter(p -> p.getGenre1().equalsIgnoreCase(genre)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("No such genre is present");
        }
        return sa;
    }

    public void display(List<PodCast> allPodCastList) {

        Consumer<PodCast> dis= d->System.out.println(d);

        allPodCastList.stream().forEach(dis);
    }
}
