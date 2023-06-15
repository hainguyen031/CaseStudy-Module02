package service;

import builder.CarBuilder;
import entity.Car;
import service.File.CarFileService;
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
        newCar.setId(CarFileService.getInstance().readCurentIdFromFile()+1);
        CarService.getInstance().getCarList().add(newCar);
    }

    public void deletaCar() {
        System.out.println("-----Delete car-----");
        boolean checkDelete = false;
        int carid = InputService.getInstance().inputCarID();
        for (Car car : CarService.getInstance().getCarList()) { // chua xong
            if (car.getId() == carid) {
                CarService.getInstance().getCarList().remove(car);
                checkDelete = true;
                break;
            }
        }
        if (checkDelete) {
            System.out.println("Delete success");
        } else {
            System.out.println("Car do not exist");
        }
    }
}
