package entity;

import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date startDate;
    private Date endDate;

    public Booking(Customer customer, Car car, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "BookCar{" +
                "customer=" + customer +
                ", car=" + car +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
