package service;

import entity.Staff;
import entity.User;
import service.File.UserFileService;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static UserService userService = new UserService();
    static List<User> userList;
    private User currentUser;

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private UserService() {
        userList = new ArrayList<>();
        userList.add(Staff.getInstance());
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addNewUser(User newUser) {
        userList.add(newUser);
        UserFileService.getInstance().writeUserList();
    }

    public boolean checkUsername(String inputUsername) {  //null point
        for (User user : userList) {
            if(user.getUsername().equals(inputUsername)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String inputPassword) {  //null point
        for (User user : userList) {
            if (user.getPassword().equals(inputPassword)) {
                setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() { //null
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

//    public static boolean register(User user) {
//        for(User ele: userList) {
//            if (ele.getUsername().equals(user.getUsername())) {
//                System.out.println("Account already exists");
//                return false;
//            }
//        }
//        userList.add(user);
//        return true;
//    }
//
//    public static boolean login(String username, String password) {
//        for (User ele : userList) {
//            if (ele.getUsername().equals(username) && ele.getPassword().equals(password)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
