package operation;

import entity.Song;
import entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserOperations {
    List<User> list=new ArrayList<>();
    public boolean validateUser(List<User> allUsersList,int userId,String password) {
            List<User> sa = new ArrayList<>();

            Optional filter = allUsersList.stream().filter(p -> p.getUserID() == userId).findAny();
            if (filter.isPresent()) {
                Optional filter1 = allUsersList.stream().filter(p -> p.getPassword().equals(password)).findAny();
                if (filter1.isPresent()) {
                    System.out.println("Go ahead");
                    return true;
                } else {
                    System.out.println("Password you have entered is invalid");
                }
            } else {
                System.out.println("Your userid is invalid,please try again");
            }
            return false;
    }
}
