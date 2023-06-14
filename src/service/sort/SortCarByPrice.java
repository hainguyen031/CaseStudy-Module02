package service.sort;

import entity.Car;

import java.util.Comparator;

public class SortCarByPrice implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getRentPrice() > car2.getRentPrice()) {
            return 1;
        }
        return -1;
    }
}
