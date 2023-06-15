package service;

import entity.Booking;
import entity.Car;
import entity.Customer;
import view.CustomerView;

import java.util.Date;
import java.util.List;

public class CustomerService extends Customer {
    private static CustomerService customerService = new CustomerService();
    static List<Customer> customerList;
    private CustomerService() {
    }

    public static CustomerService getInstance() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(List<Customer> customerList) {
        CustomerService.customerList = customerList;
    }

    public void bookCar() {
        System.out.println("Input the ID of the car you want to book: ");
        int newCarIDBook = InputService.getInstance().inputCarID();
        Car newCar = CarService.getInstance().getCarById(newCarIDBook);
        if (newCar == null || !newCar.isAvailable()) {
            System.out.println("Invalid vehicle ID or the vehicle is not available for booking.");
            return;
        }
        String startDate = InputService.getInstance().inputInfo("startdate");
        String endDate = InputService.getInstance().inputInfo("enddate");
        Booking booking = new Booking((Customer) UserService.getInstance().getCurrentUser(), newCar, startDate, endDate);
        BookingService.getInstance().getBookingList().add(booking);
        newCar.setAvailable(false);
        System.out.println("Booking successful. Your booking details:");
        booking.showBookingInfo();
    }
}
