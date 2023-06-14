package service.sort;
import service.CarService;

public class SortCarFactory {
    public static void sortCar(String typeSearch) {
        if (typeSearch.equals("rentPrice")) {
            CarService.getInstance().SortCarByPrice();
            CarService.getInstance().showList();
        } else if (typeSearch.equals("seat")) {
            CarService.getInstance().SortCarBySeat();
            CarService.getInstance().showList();
        } else if (typeSearch.equals("model")) {
            CarService.getInstance().SortCarByModel();
            CarService.getInstance().showList();
        }

    }
}
