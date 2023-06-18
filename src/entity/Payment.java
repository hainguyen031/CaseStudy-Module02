package entity;

import java.time.LocalDate;

public class Payment {
    private String username;
    private String phone;
    private String email;
    private int carId;
    private String brand;
    private String model;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfDays;
    private int rentPrice;
    private int surcharge;
    private int total;
    private int bookingId;

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

    public Payment(String username, String phone, String email, int carId, String brand, String model, LocalDate startDate, LocalDate endDate, int numberOfDays, int rentPrice, int surcharge, int total, int bookingId) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfDays = numberOfDays;
        this.rentPrice = rentPrice;
        this.surcharge = surcharge;
        this.total = total;
        this.bookingId = bookingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
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

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String[] toArray() {
        return new String[] {username,
                phone,
                email,
                String.valueOf(carId), brand, model,
                String.valueOf(startDate),
                String.valueOf(endDate),
                String.valueOf(numberOfDays),
                String.valueOf(rentPrice),
                String.valueOf(surcharge),
                String.valueOf(total),
                String.valueOf(bookingId)
        };
    }
}
