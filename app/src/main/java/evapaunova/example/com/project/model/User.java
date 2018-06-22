package evapaunova.example.com.project.model;

import java.io.Serializable;

public class User implements Serializable{

    private String username;
    private String password;
    private int age;
    private boolean isFemale;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int age, boolean isFemale) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.isFemale = isFemale;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public boolean isFemale() {
        return isFemale;
    }
}
