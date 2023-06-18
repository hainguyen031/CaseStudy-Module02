package view;

import service.InputService;
import service.sort.SortCarFactory;

import java.util.List;

public class SortCarView {
    private static final SortCarView sortCarView = new SortCarView();
    private SortCarView() {}
    public static SortCarView getInstance() {
        return sortCarView;
    }
    public void displaySortView() {
        System.out.println("-----SORT VIEW-----");
        System.out.println("1. Sort by price");
        System.out.println("2. Sort by model");
        System.out.println("3. Sort by seat");
        System.out.println("4. Back");
    }
    public void runSortView() {
        int choice = 0;
        while (choice != 4) {
            displaySortView();
            choice = InputService.getInstance().inputChoice();
            switch (choice) {
                case 1:
                    SortCarFactory.getInstance().sortCar("rentPrice");
                    CustomerView.getInstance().runCustomerView();
                    break;
                case 2:
                    SortCarFactory.getInstance().sortCar("model");
                    CustomerView.getInstance().runCustomerView();
                    break;
                case 3:
                    SortCarFactory.getInstance().sortCar("seat");
                    CustomerView.getInstance().runCustomerView();
                    break;
                case 4:
                    CustomerView.getInstance().runCustomerView();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
