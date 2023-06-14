package service;

import entity.Car;
import view.StaffView;

public class StaffService {
    private static final StaffService staffService = new StaffService();
    private StaffService() {}
    public static StaffService getInstance() {
        return staffService;
    }

    public void addCar() {
        System.out.println("-----Input car information-----");
        Car newCar = InputService.getInstance().inputCarInfo();
        CarService.getInstance().getCarList().add(newCar);
    }
}
