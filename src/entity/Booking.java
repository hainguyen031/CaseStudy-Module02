package entity;

import service.CustomerService;

public class Booking {
    private Customer customer;
    private Car car;
    private String startDate;
    private String endDate;

    public Booking(Customer customer, Car car, String startDate, String endDate) {
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void showBookingInfo() {
        System.out.println("Name customer: " + customer.getName());
        System.out.println("Phone number: " + customer.getPhone());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("CCCD: " + customer.getCccd());
        System.out.println("GPLX: " + customer.getGplx());
        System.out.println("Brand car:" + car.getBrand());
        System.out.println("Model car: " + car.getModel());
        System.out.println("Seats car:" + car.getSeats());
        System.out.println("Rental price: " + car.getRentPrice());
        System.out.println("StartDate: " + startDate);
        System.out.println("EndDate: " +endDate);


    }

    public String[] toArray() {
        return new String[] {customer.getName(),
                customer.getCccd(),
                customer.getGplx(),
                car.getBrand(),
                car.getModel(),
                String.valueOf(car.getSeats()),
                startDate,
                endDate};
    }
}
