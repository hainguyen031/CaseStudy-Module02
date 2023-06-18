package builder;

import entity.Payment;

import java.time.LocalDate;

public interface InterfacePaymentBuilder {
    InterfacePaymentBuilder username(String username);
    InterfacePaymentBuilder phone(String phone);
    InterfacePaymentBuilder email(String email);
    InterfacePaymentBuilder carId(int carId);
    InterfacePaymentBuilder brand(String brand);
    InterfacePaymentBuilder model(String model);
    InterfacePaymentBuilder startDate(LocalDate startDate);
    InterfacePaymentBuilder endDate(LocalDate endDate);
    InterfacePaymentBuilder numberOfDays(int numberOfDays);
    InterfacePaymentBuilder rentalPrice(int rentalPrice);
    InterfacePaymentBuilder surcharge(int surcharge);
    InterfacePaymentBuilder total(int total);
    InterfacePaymentBuilder bookingId(int bookingId);
    Payment build();
}
