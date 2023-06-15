package view;

import service.CarService;
import service.CustomerService;
import service.File.CarFileService;
import service.InputService;
import service.StaffService;

public class StaffView {
    private static final StaffView staffView = new StaffView();
    private final int ADD_CAR = 1;
    private final int DELETE_CAR = 2;
    private final int SHOW_LIST_CAR = 3;
    private StaffView() {}
    public static StaffView getInstance() {
        return staffView;
    }
    public void displayStaffView() {
        System.out.println("-----RENTAL CAR MANAGEMENT-----");
        System.out.println("1. Add car");
        System.out.println("2. Delete car");
        System.out.println("3. Show list car");
        System.out.println("4. tình trạng xe");
        System.out.println("5. tạo đơn giao xe tới điểm thuê");
        System.out.println("6. Xác nhận tình trạng xe khi cho thuê");
        System.out.println("7. Thanh toán");
        System.out.println("8. Exit");
    }
    public void runStaffView() {
        int choice = 0;
        while (choice != 8) {
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
                    CarService.getInstance().showList();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 8:
                    CarFileService.getInstance().writeCarList();
                    break;
            }
        }
    }
}
