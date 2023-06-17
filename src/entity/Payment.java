package entity;

import java.time.LocalDate;

public class Payment {
    private int carId;
    private String brand;
    private String model;
    private int rentPrice;
    private int surcharge;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfDays;
    private int total;

    public Payment(int carId, String brand, String model, int rentPrice, LocalDate startDate, LocalDate endDate, int numberOfDays, int total) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.rentPrice = rentPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfDays = numberOfDays;
        this.total = total;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        carId = carId;
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

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }
}
