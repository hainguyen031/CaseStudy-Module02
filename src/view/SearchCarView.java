package view;

import service.CarService;
import service.InputService;
import service.search.SearchFactory;

import java.util.List;

public class SearchCarView {
    private static final SearchCarView searchCarView = new SearchCarView();

    private SearchCarView() {
    }

    private final int BY_PRICE = 1;
    private final int BY_MODEL = 2;
    private final int BY_SEAT = 3;
    private final int GO_BACK = 4;

    public static SearchCarView getInstance() {
        return searchCarView;
    }

    public void displaySearchView() {
        System.out.println("-----SEARCH CAR-----");
        System.out.println("1. Search by price");
        System.out.println("2. Search by model");
        System.out.println("3. Search by seat");
        System.out.println("4. Back");
    }

    public void runSearchView() {
        int choice = 0;
        while (choice != GO_BACK) {
            displaySearchView();
            choice = InputService.getInstance().inputChoice();
            switch (choice) {
                case BY_PRICE:
                    List<Integer> carID = SearchFactory.getInstance().getSearch("price").searchByCondition();
                    CarService.getInstance().displayCarListByIdWithPrice(carID);
                    System.out.println();
                    CustomerView.getInstance().runCustomerView();
//                    break;
                case BY_MODEL:
                    List<Integer> carId = SearchFactory.getInstance().getSearch("model").searchByCondition();
                    CarService.getInstance().displayCarListByIdWithModel(carId);
                    System.out.println();
                    CustomerView.getInstance().runCustomerView();
//                    break;
                case BY_SEAT:
                    List<Integer> cariD = SearchFactory.getInstance().getSearch("seat").searchByCondition();
                    CarService.getInstance().displayCarListByIdWithSeat(cariD);
                    System.out.println();
                    CustomerView.getInstance().runCustomerView();
//                    break;
                case GO_BACK:
                    //ghi file
                    CustomerView.getInstance().runCustomerView();
//                    break;
            }
        }
    }
}
