package view;

import entity.User;
import service.UserService;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    private static final LoginView loginView = new LoginView();
    private LoginView() {}
    public static LoginView getInstance() {
        return loginView;
    }
    public boolean displayLoginMenu() {
        boolean check = false;
        System.out.println("-----LOGIN-----");
        System.out.println("Input username: ");
        String inputUsername = scanner.nextLine();
        UserService userService = UserService.getInstance();
        if (userService.checkUsername(inputUsername)) {
            System.out.println("Input password:");
            String inputPassword = scanner.nextLine();
            if (userService.checkPassword(inputPassword)) {
                System.out.println("Login success");
                check = true;
            } else {
                System.out.println("Wrong password");
            }
        } else {
            System.out.println("Username not exist");
        }
        return check;
    }
}
