package view;

import service.InputService;

public class StaffView {
    private static final StaffView staffView = new StaffView();
    private StaffView() {}
    public static StaffView getInstance() {
        return staffView;
    }
    public void displayStaffView() {
        System.out.println("-----RENTAL CAR MANAGEMENT-----");
        System.out.println("1. Add car");
        System.out.println("2. Delete car");
        System.out.println("3. tình trạng xe");
        System.out.println("4. tạo đơn giao xe tới điểm thuê");
        System.out.println("5. Xác nhận tình trạng xe khi cho thuê");
        System.out.println("6. Thanh toán");
        System.out.println("7. Exit");
    }
    public void runStaffView() {
        int choice = 0;
        while (choice != 7) {
            displayStaffView();
            choice = InputService.getInstance().inputChoice();
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
            }
        }
    }
}
