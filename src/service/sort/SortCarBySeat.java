package service.sort;

import entity.Car;

import java.util.Comparator;

public class SortCarBySeat implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getSeats()>car2.getSeats()) {
            return 1;
        }
        return -1;
    }
}
