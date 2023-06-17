package builder;

import entity.Booking;
import entity.Car;
import entity.Customer;

import java.time.LocalDate;

public interface InterfaceBookingBuilder {
    InterfaceBookingBuilder name(String name);
    InterfaceBookingBuilder cccd(String cccd);
    InterfaceBookingBuilder gplx(String gplx);
    InterfaceBookingBuilder brand(String brand);
    InterfaceBookingBuilder model(String model);
    InterfaceBookingBuilder seat(String seat);
    InterfaceBookingBuilder rentalPrice(String rentalPrice);
    InterfaceBookingBuilder startDate(LocalDate startDate);
    InterfaceBookingBuilder endDate(LocalDate endDate);
    Booking build();
    InterfaceBookingBuilder customer(Customer customer);
    InterfaceBookingBuilder car(Car car);

}
