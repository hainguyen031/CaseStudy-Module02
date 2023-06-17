package view;

import service.CarService;
import service.CustomerService;
import service.File.BookingFileService;
import service.File.CarFileService;
import service.File.PaymentFileService;
import service.InputService;
import service.StaffService;

public class StaffView {
    private static final StaffView staffView = new StaffView();
    private final int ADD_CAR = 1;
    private final int DELETE_CAR = 2;
    private final int SHOW_LIST_CAR = 3;
    private final int PAYMENT = 5;
    private final int ORDER_RENTAL_LOCATION = 4;
    private final int LOGOUT = 6;
    private StaffView() {}
    public static StaffView getInstance() {
        return staffView;
    }
    public void displayStaffView() {
        System.out.println("-----RENTAL CAR MANAGEMENT-----");
        System.out.println("1. Add car");
        System.out.println("2. Delete car");
        System.out.println("3. Show list car");
        System.out.println("4. Create an order to deliver the car to the rental point");
        System.out.println("5. Payment");
        System.out.println("6. Logout");
    }
    public void runStaffView() {
        int choice = 0;
        while (choice != LOGOUT) {
            displayStaffView();
            choice = InputService.getInstance().inputChoice();
            switch (choice) {
                case ADD_CAR:
                    StaffService.getInstance().addCar();
                    CarFileService.getInstance().writeCarList();
                    break;
                case DELETE_CAR:
                    StaffService.getInstance().deletaCar();
                    CarFileService.getInstance().writeCarList();
                    break;
                case SHOW_LIST_CAR:
                    CarService.getInstance().showListForStaff();
                    break;
                case ORDER_RENTAL_LOCATION:
                    StaffService.getInstance().orderRentalLocation(); //chua xong
                    break;
                case PAYMENT:
                    StaffService.getInstance().processPayment();
                    break;
                case LOGOUT:
                    System.out.println("Logout successfully !");
                    CarFileService.getInstance().writeCarList();
                    PaymentFileService.getInstance().writePaymentFile();
                    BookingFileService.getInstance().writeBookingList();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
