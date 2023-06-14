package entity;

import service.UserService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class User {
    static Scanner scanner = new Scanner(System.in);
    private static int idCount = 0;
    private int id;
    protected String username;
    protected String password;
    protected String phone;
    protected String email;
    public User() {
    }
    public User(String username, String password, String phone, String email) {
        this.id = idCount++;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
