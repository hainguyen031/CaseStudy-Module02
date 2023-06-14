package service;

import entity.Booking;
import entity.Car;
import entity.Customer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookCarService {
    private static List<Booking> bookings = new ArrayList<>();
    public void bookCar(Customer customer, Car car, Date startDate, Date endDate) {
        Booking booking = new Booking(customer, car, startDate, endDate);
        if (!car.isAvailable()) {
            bookings.add(booking);
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
