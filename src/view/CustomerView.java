package view;

import service.*;
import service.File.BookingFileService;
import service.File.CarFileService;
import service.File.PaymentFileService;
import service.File.UserFileService;


public class CustomerView {
    private static final CustomerView customerView = new CustomerView();

    private CustomerView() {
    }

    private final int SHOWLIST_CAR = 1;
    private final int SEARCH_CAR = 2;
    private final int SORT_CAR = 3;
    private final int DETAIL_CAR = 4;
    private final int BOOK_CAR = 5;
    private final int VIEW_HISTORY_BOOKING = 6;
    private final int BILL = 7;
    private final int LOGOUT = 8;

    public static CustomerView getInstance() {
        return customerView;
    }

    public void displayCustomerView() {
        System.out.println("-----CAR RENTAL APP-----");
        System.out.println("1. Show list car");
        System.out.println("2. Search car");
        System.out.println("3. Sort car");
        System.out.println("4. View car detail");
        System.out.println("5. Book car");
        System.out.println("6. View history booking");
        System.out.println("7. Receipt");
        System.out.println("8. Logout");
    }

    public void runCustomerView() {
        int choice = 0;
        while (choice != LOGOUT) {
            displayCustomerView();
            choice = InputService.getInstance().inputChoice();
            switch (choice) {
                case SHOWLIST_CAR:
                    CarService.getInstance().showList();
                    break;
                case SEARCH_CAR:
                    SearchCarView.getInstance().runSearchView();
                    break;
                case SORT_CAR:
                    SortCarView.getInstance().runSortView();
                case DETAIL_CAR:
                    CarService.getInstance().showDetailCar();
                    break;
                case BOOK_CAR:
                    BookingService.getInstance().bookCar();
                    break;
                case VIEW_HISTORY_BOOKING:
                    BookingService.getInstance().showHistoryBooking();
                    break;
                case BILL:
                    PaymentService.getInstance().showPayment();
                    break;
                case LOGOUT:
                    System.out.println("Logout successfully !");
                    UserFileService.getInstance().writeUserList();
                    BookingFileService.getInstance().writeBookingList();
//                    PaymentFileService.getInstance().writePaymentFile();
//                    CarFileService.getInstance().writeCarList();
                    BeginView.getInstance().runBeginMenu();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
