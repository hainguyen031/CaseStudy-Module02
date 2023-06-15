package service;

import entity.Booking;
import entity.Car;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private static List<Booking> bookingList;
    private static final BookingService bookingService = new BookingService();
    private BookingService() {}
    static {
        bookingList = new ArrayList<>();
    }
    public static BookingService getInstance() {
        return bookingService;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public static void setBookingList(List<Booking> bookingList) {
        BookingService.bookingList = bookingList;
    }
//    public void show() {
//        for (Customer customer : )
//    }
public void bookCar(Customer customer, Car car, String startDate, String endDate) {
    Booking booking = new Booking(customer, car, startDate, endDate);
    if (!car.isAvailable()) {
        bookingList.add(booking);
        car.setAvailable(false);
        System.out.println("Successful car booking !");
        System.out.println("Booking information");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Model car: " + car.getModel());
        System.out.println("Brand car: " + car.getBrand());
        System.out.println("Start day: " + startDate);
        System.out.println("End day: " + endDate);
    } else {
        System.out.println("Car is not available for reservation !");
    }
}
}
