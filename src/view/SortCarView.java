package view;

import service.InputService;
import service.sort.SortCarFactory;


public class SortCarView {
    private static final SortCarView sortCarView = new SortCarView();
    private SortCarView() {}
    public static SortCarView getInstance() {
        return sortCarView;
    }
    private final int SORT_PRICE = 1;
    private final int SORT_MODEL = 2;
    private final int SORT_SEAT = 3;
    private final int BACK = 4;
    public void displaySortView() {
        System.out.println("-----SORT VIEW-----");
        System.out.println("1. Sort by price");
        System.out.println("2. Sort by model");
        System.out.println("3. Sort by seat");
        System.out.println("4. Back");
    }
    public void runSortView() {
        int choice = 0;
        while (choice != BACK) {
            displaySortView();
            choice = InputService.getInstance().inputChoice();
            switch (choice) {
                case SORT_PRICE:
                    SortCarFactory.getInstance().sortCar("rentPrice");
                    CustomerView.getInstance().runCustomerView();
                    break;
                case SORT_MODEL:
                    SortCarFactory.getInstance().sortCar("model");
                    CustomerView.getInstance().runCustomerView();
                    break;
                case SORT_SEAT:
                    SortCarFactory.getInstance().sortCar("seat");
                    CustomerView.getInstance().runCustomerView();
                    break;
                case BACK:
                    CustomerView.getInstance().runCustomerView();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
