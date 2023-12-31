package view;

import builder.CustomerBuilder;
import entity.User;
import service.File.UserFileService;
import service.InputService;
import service.UserService;

import java.time.format.DateTimeFormatter;

public class RegisterView {
    private static final RegisterView registerView = new RegisterView();


    private RegisterView() {
    }

    public static RegisterView getInstance() {
        return registerView;
    }

    public void displayRegisterMenu() {
        boolean isExistUser = true;
        System.out.println("-----REGISTER-----");
        String username = "";
        while (isExistUser) {
            isExistUser = false;
            username = InputService.getInstance().inputInfo("username");
            for (User user : UserService.getInstance().getUserList()) {
                if (username.equals(user.getUsername())) {
                    System.out.println("Username has been used. Try with another one");
                    isExistUser = true;
                }
            }
        }
        String password = InputService.getInstance().inputInfo("password");
        String name = InputService.getInstance().inputInfo("name");
        String email = "";
        boolean isExist = true;
        while (isExist) {
            isExist = false;
            email = InputService.getInstance().inputInfo("email");
            for (User user : UserService.getInstance().getUserList()) {
                if (email.equals(user.getEmail())) {
                    System.out.println("Email has been used. Try with another one");
                    isExist = true;
                }
            }
        }
        String phone = InputService.getInstance().inputInfo("phone");
        String cccd = InputService.getInstance().inputInfo("cccd");
        String gplx = InputService.getInstance().inputInfo("gplx");
        User newUser = CustomerBuilder.getInstance()
                .username(username)
                .password(password)
                .email(email)
                .phone(phone)
                .name(name)
                .cccd(cccd)
                .gplx(gplx)
                .build();

//        User newUser = new User(username, password, email, phone);
        UserService.getInstance().addNewUser(newUser);
        UserService.getInstance().setCurrentUser(newUser);
        UserFileService.getInstance().writeUserList();

    }
}
