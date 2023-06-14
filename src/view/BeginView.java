package view;

import service.File.UserFileService;
import service.InputService;
import service.UserService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.PropertyResourceBundle;

public class BeginView {
    private static final BeginView beginView = new BeginView();

    private BeginView() {
        UserFileService.getInstance().readUserList();
    }

    public static BeginView getInstance() {
        return beginView;
    }
    private final int LOGIN = 1;
    private final int REGISTER = 2;
    private final int EXIT = 3;
    public void displayBeginMenu() {
        System.out.println("----- WELCOME TO RENTAL CAR SERVICE -----");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    public void runBeginMenu() {
        int choice = 0;

        while (choice != EXIT) {
            displayBeginMenu();
            choice = InputService.getInstance().inputChoice();
            switch (choice) {
                case LOGIN:
                    if (LoginView.getInstance().displayLoginMenu()) {
                        if (UserService.getInstance().getCurrentUser().getId() == 0) {
                            StaffView.getInstance().displayStaffView(); // chua lam staff
                        } else {
                            CustomerView.getInstance().runCustomerView();
                        }
                    } else {
                        System.out.println("Login unsuccessfully");
                    }
                    break;
                case REGISTER:
                    RegisterView.getInstance().displayRegisterMenu();
                    CustomerView.getInstance().runCustomerView();
                    break;
                case EXIT:
                    UserFileService.getInstance().writeUserList();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
