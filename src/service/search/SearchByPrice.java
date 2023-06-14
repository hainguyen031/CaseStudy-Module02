package service.search;

import entity.Car;
import service.CarService;
import service.InputService;

import java.util.ArrayList;
import java.util.List;

public class SearchByPrice implements Search {
    private static final SearchByPrice searchByPrice = new SearchByPrice();

    private SearchByPrice() {
    }

    public static SearchByPrice getInstance() {
        return searchByPrice;
    }

    @Override
    public List<Integer> searchByCondition() {
        return searchByPrice();
    }

    private List<Integer> searchByPrice() {
        List<Integer> carID = new ArrayList<>();
        int[] priceRange = InputService.getInstance().inputPriceRange();
        for (Car car : CarService.getInstance().getCarList()) {
            if (checkCarInPriceRange(priceRange, car) && (car.isAvailable())) {
                carID.add(car.getId());
            }
        }
        return carID;
    }

    private boolean checkCarInPriceRange(int[] priceRange, Car car) {
        int lower = priceRange[0];
        int upper = priceRange[1];
        if ((car.getRentPrice() <= upper) && (car.getRentPrice() >= lower)) {
            return true;
        } else {
            return false;
        }
    }
}
