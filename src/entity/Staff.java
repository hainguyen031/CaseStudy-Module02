package entity;

import service.CarService;

import java.util.Scanner;

public class Staff extends User {
    private static final Staff staff = new Staff(
            "staff",
            "staff123",
            "0984872656",
            "rentalcar@gmail.com"
    );

    private Staff(String username, String password, String phone, String email) {
        super(username, password, phone, email);
        super.setId(0);
    }
    public static Staff getInstance() {
        return staff;
    }
}
