package service;

import entity.Booking;
import entity.Car;
import entity.Customer;
import service.File.BookingFileService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private static List<Booking> bookingList;
    private static final BookingService bookingService = new BookingService();

    private BookingService() {
    }

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

//    public void bookCar(Customer customer, Car car, String startDate, String endDate) {
//        Booking booking = new Booking(customer, car, startDate, endDate);
//        if (!car.isAvailable()) {
//            bookingList.add(booking);
//            car.setAvailable(false);
//            System.out.println("Successful car booking !");
//            System.out.println("Booking information");
//            System.out.println("Customer: " + customer.getName());
//            System.out.println("Model car: " + car.getModel());
//            System.out.println("Brand car: " + car.getBrand());
//            System.out.println("Start day: " + startDate);
//            System.out.println("End day: " + endDate);
//        } else {
//            System.out.println("Car is not available for reservation !");
//        }
//    }

    public void bookCar() {
        System.out.println("Input the ID of the car you want to book: ");
        int newCarIDBook = InputService.getInstance().inputCarID();
        Car newCar = CarService.getInstance().getCarById(newCarIDBook);
        if (newCar == null || !newCar.isAvailable()) {
            System.out.println("Invalid vehicle ID or the car is not available for booking.");
            return;
        }
        System.out.println("Start date");
        LocalDate startDate = InputService.getInstance().inputDate();
        System.out.println("End date");
        LocalDate endDate = InputService.getInstance().inputDate();
        String pickupLocation = InputService.getInstance().inputInfo("pickupLocation");
        newCar.setAvailable(false);
        int deposit = 5000000;
        Booking booking = new Booking((Customer) UserService.getInstance().getCurrentUser(), newCar, startDate, endDate, pickupLocation, deposit);
        booking.setId(newCarIDBook);

        booking.setPickupLocation(pickupLocation);
        BookingService.getInstance().getBookingList().add(booking);
        BookingFileService.getInstance().writeBookingList();
        System.out.println("-----Booking successful. Your booking details-----");
        booking.showBookingInfo();
    }

    public void showHistoryBooking() {
        System.out.println("nothing");
    }
}
