package view;

import service.CustomerService;
import service.File.BookingFileService;
import service.File.UserFileService;
import service.InputService;
import service.CarService;


public class CustomerView {
    private static final CustomerView customerView = new CustomerView();

    private CustomerView() {
    }
    private final int SHOWLISIST_CAR = 1;
    private final int SEARCH_CAR = 2;
    private final int DETAIL_CAR = 3;
    private final int BOOK_CAR = 4;
    public static CustomerView getInstance() {
        return customerView;
    }

    public void displayCustomerView() {
        System.out.println("-----CAR RENTAL APP-----");
        System.out.println("1. Show list car");
        System.out.println("2. Search car");
        System.out.println("3. View car detail");
        System.out.println("4. Book car");
        System.out.println("5. Down payment");
        System.out.println("6. History");
        System.out.println("7. Invoice");
        System.out.println("9. Logout");
    }

    public void runCustomerView() {
        int choice = 0;
        while (choice != 9) {
            displayCustomerView();
            choice = InputService.getInstance().inputChoice();
            switch (choice) {
                case SHOWLISIST_CAR:
                    CarService.getInstance().showList();
                    break;
                case SEARCH_CAR:
                    SearchCarView.getInstance().runSearchView();
                    break;
                case DETAIL_CAR:
                    CarService.getInstance().showDetailCar();
                    break;
                case BOOK_CAR:
                    CustomerService.getInstance().bookCar();
                    BookingFileService.getInstance().writeBookingList();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 9:
                    System.out.println("Logout successfully !");
                    UserFileService.getInstance().writeUserList();
                    BookingFileService.getInstance().writeBookingList();
                    BeginView.getInstance().runBeginMenu();
//                    exit = true;
                    break;
            }
        }
    }
}
