package entity;

import service.CustomerService;

import java.time.LocalDate;
import java.util.Arrays;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupLocation;
    private int deposit;

    public Booking(Customer customer, Car car, LocalDate startDate, LocalDate endDate, String pickupLocation, int deposit, int bookingId) {
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupLocation = pickupLocation;
        this.deposit = deposit;
        this.bookingId = bookingId;
    }
    public Booking(Customer customer, Car car, LocalDate startDate, LocalDate endDate, String pickupLocation, int deposit) {
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupLocation = pickupLocation;
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void showBookingInfo() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Name customer: " + customer.getName());
        System.out.println("Phone number: " + customer.getPhone());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("CCCD: " + customer.getCccd());
        System.out.println("GPLX: " + customer.getGplx());
        System.out.println("Car ID: " + car.getId());
        System.out.println("Brand car:" + car.getBrand());
        System.out.println("Model car: " + car.getModel());
        System.out.println("Number of seats:" + car.getSeats());
        System.out.println("Rental price: " + car.getRentPrice());
        System.out.println("StartDate: " + startDate);
        System.out.println("EndDate: " + endDate);
        System.out.println("Pickup location: " + pickupLocation);
        System.out.println("The deposit for car rental is: 5000000");


    }

    public String[] toArray() {
        return new String[]{customer.getUsername(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getCccd(),
                customer.getGplx(),
                String.valueOf(car.getId()),
                car.getBrand(),
                car.getModel(),
                String.valueOf(car.getSeats()),
                String.valueOf(car.getRentPrice()),
                String.valueOf(startDate),
                String.valueOf(endDate),
                pickupLocation,
                String.valueOf(deposit),
                String.valueOf(bookingId)
        };
    }
}
