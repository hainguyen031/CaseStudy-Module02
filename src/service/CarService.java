package service;

import entity.Car;
import service.sort.SortCarByModel;
import service.sort.SortCarByPrice;
import service.sort.SortCarBySeat;
import view.CustomerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarService {
    private static List<Car> carList;
    private static final CarService carService = new CarService();

    public CarService() {
    }

    public static CarService getInstance() {
        return carService;
    }

    static {
        carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public static void setCarList(List<Car> carList) {
        CarService.carList = carList;
    }

    public void addCarToList(Car car) {
        carList.add(car);
    }

    public void showList() {
        for (Car ele : carList) {
            if (ele.isAvailable()) {
                System.out.println(ele.toString());
            }
        }
    }


    public void SortCarByPrice() {
        Collections.sort(carList, new SortCarByPrice());
    }

    public void SortCarByModel() {
        Collections.sort(carList, new SortCarByModel());
    }

    public void SortCarBySeat() {
        Collections.sort(carList, new SortCarBySeat());
    }

    public void displayCarListByIdWithPrice(List<Integer> carID) {
        if (carID.isEmpty()) {
            System.out.println("No such car");
        } else {
            for (Car car : carList) {
                for (Integer element : carID) {
                    if (car.getId() == element) {
                        System.out.println("ID:" + element + ". "
                                + car.getBrand() + " "
                                + car.getModel() + " "
                                + car.getSeats() + " "
                                + car.getRentPrice());
                        break;
                    }
                }
            }
        }
    }

    public void displayCarListByIdWithModel(List<Integer> carId) {
        if (carId.isEmpty()) {
            System.out.println("No such car");
        } else {
            for (Car car : carList) {
                for (Integer element : carId) {
                    if (car.getId() == element) {
                        System.out.println("ID:" + element + ". "
                                + car.getBrand() + " "
                                + car.getModel() + " "
                                + car.getSeats() + " "
                                + car.getRentPrice());
                        break;
                    }
                }
            }
        }
    }

    public void displayCarListByIdWithSeat(List<Integer> cariD) {
        if (cariD.isEmpty()) {
            System.out.println("No such car");
        } else {
            for (Car car : carList) {
                for (Integer element : cariD) {
                    if (car.getId() == element) {
                        System.out.println("ID:" + element + ". "
                                + car.getBrand() + " "
                                + car.getModel() + " "
                                + car.getSeats() + " "
                                + car.getRentPrice());
                        break;
                    }
                }
            }
        }
    }

    public void showDetailCar() {
        int id = InputService.getInstance().inputCarID();
        for (Car car : carList) {
            if (car.getId() == id) {
                System.out.println("-----Detail car-----");
                System.out.println("ID: " + car.getId());
                System.out.println("Brand: " + car.getBrand());
                System.out.println("Model: " + car.getModel());
                System.out.println("Seat: " + car.getSeats());
                System.out.println("Rental price: " + car.getRentPrice());
                System.out.println("Available: " + car.isAvailable());
                CustomerView.getInstance().runCustomerView();
                break;
            }
        }
        System.out.println("Cannot find the car !");
        CustomerView.getInstance().runCustomerView();
    }

    public Car getCarById(int newCarIDBook) {
        for (Car car : CarService.getInstance().getCarList()) {
            if (car.getId() == newCarIDBook) {
                return car;
            }
        }
        return null;
    }

    public Car getCarByModel(String carModel) {
        for (Car car : carList) {
            if (car.getModel().equals(carModel)) {
                return car;
            }
        }
        return null;
    }
}
