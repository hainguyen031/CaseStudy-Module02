package builder;

import entity.Booking;
import entity.Car;
import entity.Customer;

import java.time.LocalDate;

public interface InterfaceBookingBuilder {
    InterfaceBookingBuilder username(String username);
    InterfaceBookingBuilder phone(String phone);
    InterfaceBookingBuilder email(String email);
    InterfaceBookingBuilder cccd(String cccd);
    InterfaceBookingBuilder gplx(String gplx);
    InterfaceBookingBuilder carId(int carId);
    InterfaceBookingBuilder brand(String brand);
    InterfaceBookingBuilder model(String model);
    InterfaceBookingBuilder seat(int seat);
    InterfaceBookingBuilder rentalPrice(int rentalPrice);
    InterfaceBookingBuilder startDate(LocalDate startDate);
    InterfaceBookingBuilder endDate(LocalDate endDate);
    InterfaceBookingBuilder pickupLocation(String pickupLocation);
    InterfaceBookingBuilder deposit(int deposit);

    Booking build();


}
