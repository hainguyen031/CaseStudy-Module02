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
        carList.add(new Car(1, "Toyota", "Fortuner", 7, 1000000));
        carList.add(new Car(2, "Toyota", "Vios", 4, 700000));
        carList.add(new Car(3, "Mitsubishi", "Xpander", 7, 900000));
        carList.add(new Car(4, "MG", "MG5", 4, 600000));
        carList.add(new Car(5, "Huyndai", "Accent", 4, 650000));
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
            System.out.println(ele.toString());
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
                        System.out.println(element + ". " +car.getBrand() + " " + car.getRentPrice());
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
                        System.out.println(element + ". " +car.getBrand() +" " + car.getModel());
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
                        System.out.println(element + ". " +car.getBrand() +" " + car.getSeats());
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
}
