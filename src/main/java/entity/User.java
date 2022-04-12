package entity;

public class User {
    int userID;
    private String password;
    String name;
    String phoneNO;
    String emailID;
    int age;

    public User(){

    }

    public User(int userID, String password, String name, String phoneNO, String emailID, int age) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.phoneNO = phoneNO;
        this.emailID = emailID;
        this.age = age;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNO='" + phoneNO + '\'' +
                ", emailID='" + emailID + '\'' +
                ", age=" + age +
                '}';
    }
}
