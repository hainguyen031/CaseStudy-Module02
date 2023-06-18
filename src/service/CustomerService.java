package service;

import entity.Booking;
import entity.Car;
import entity.Customer;
import service.File.BookingFileService;
import view.CustomerView;

import java.time.LocalDate;
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

//    public void bookCar() {
//        System.out.println("Input the ID of the car you want to book: ");
//        int newCarIDBook = InputService.getInstance().inputCarID();
//        Car newCar = CarService.getInstance().getCarById(newCarIDBook);
//        if (newCar == null || !newCar.isAvailable()) {
//            System.out.println("Invalid vehicle ID or the car is not available for booking.");
//            return;
//        }
//        System.out.println("Input startDate");
//        LocalDate startDate = InputService.getInstance().inputDate();
//        System.out.println("Input endDate");
//        LocalDate endDate = InputService.getInstance().inputDate();
//        String pickupLocation = InputService.getInstance().inputInfo("pickupLocation");
//        newCar.setAvailable(false);
//        int deposit = 5000000;
//        Booking booking = new Booking((Customer) UserService.getInstance().getCurrentUser(), newCar, startDate, endDate, pickupLocation, deposit);
//        booking.setBookingId(BookingFileService.getInstance().readCurrentBookingId() + 1);
//        //booking.setId(newCarIDBook);
//        booking.setPickupLocation(pickupLocation);
//        BookingService.getInstance().getBookingList().add(booking);
//
//        System.out.println("-----Booking successful. Your booking details-----");
//        booking.showBookingInfo();
//    }
}
