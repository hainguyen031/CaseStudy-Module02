package entity;

import builder.CarBuilder;
import service.CarService;
import service.File.CarFileService;

import java.util.Arrays;
import java.util.Locale;

public class Car {
    private int id;
    private static int countId = 0;
    private String brand;
    private String model;
    private int seats;
    private int rentPrice;
    private boolean available = true;
    private String describe;

    private int nextCarId() {
        return CarFileService.getInstance().readCurentIdFromFile();
    }

    public Car() {
    }

    public Car(String brand, String model, int seats, int rentPrice, boolean available) {
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.rentPrice = rentPrice;
        this.available = available;
    }

    public Car(int id, String brand, String model, int seats, int rentPrice, boolean available, String describe) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.rentPrice = rentPrice;
        this.available = available;
        this.describe = describe;
    }
    public Car(int id, String brand, String model, int seats, int rentPrice) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.rentPrice = rentPrice;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", seats=" + seats +
                ", rentalPrice=" + rentPrice +
                '}';
    }

    public String toStringForStaff() {
        return "Car{" +
                "ID='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", seats=" + seats +
                ", rentalPrice=" + rentPrice +
                ", available=" + available +
                '}';
    }

    public String[] toArray() {
        return new String[]{String.valueOf(id), brand, model, String.valueOf(seats), String.valueOf(rentPrice), String.valueOf(available), describe};
    }
}
