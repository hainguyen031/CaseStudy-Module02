package view;

import service.File.UserFileService;
import service.InputService;
import service.CarService;


public class CustomerView {
    private static final CustomerView customerView = new CustomerView();

    private CustomerView() {
    }
    private final int SEARCH_CAR = 3;
    private final int DETAIL_CAR = 4;
    public static CustomerView getInstance() {
        return customerView;
    }

    public void displayCustomerView() {
        System.out.println("-----CAR RENTAL APP-----");
        //System.out.println("1. Add car");
        System.out.println("2. Show list car");
        System.out.println("3. Search car");
        System.out.println("4. View car detail");
        System.out.println("5. Book car");
        System.out.println("6. Down payment");
        System.out.println("7. History");
        System.out.println("8. Invoice");
        System.out.println("9. Logout");
    }

    public void runCustomerView() {
        int choice = 0;
        while (choice != 9) {
            displayCustomerView();
            choice = InputService.getInstance().inputChoice();

            switch (choice) {
//                case 1:
//
//                    break;
                case 2:
                    CarService.getInstance().showList();
                    break;
                case SEARCH_CAR:
                    SearchCarView.getInstance().runSearchView();
                    break;
                case DETAIL_CAR:
                    CarService.getInstance().showDetailCar();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Logout successfully !");
                    UserFileService.getInstance().writeUserList();
//                    exit = true;
                    break;
            }
        }
    }
}
