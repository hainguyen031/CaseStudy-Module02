package builder;

import entity.Booking;
import entity.Car;
import entity.Customer;
import service.CarService;
import service.UserService;

import java.time.LocalDate;

public class BookingBuilder implements InterfaceBookingBuilder {
    protected String username;
    protected String phone;
    protected String email;
    protected String cccd;
    protected String gplx;
    protected int carId;
    protected String brand;
    protected String model;
    protected int seat;
    protected int rentalPrice;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected String pickupLocation;
    protected int deposit;
    private static final BookingBuilder bookingBuilder = new BookingBuilder();
    private BookingBuilder() {}
    public static BookingBuilder getInstance() {
        return bookingBuilder;
    }
    @Override
    public InterfaceBookingBuilder username(String username) {
        this.username = username;
        return this;
    }

    @Override
    public InterfaceBookingBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public InterfaceBookingBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public InterfaceBookingBuilder cccd(String cccd) {
        this.cccd = cccd;
        return this;
    }

    @Override
    public InterfaceBookingBuilder gplx(String gplx) {
        this.gplx = gplx;
        return this;
    }

    @Override
    public InterfaceBookingBuilder carId(int carId) {
        this.carId = carId;
        return this;
    }

    @Override
    public InterfaceBookingBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public InterfaceBookingBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public InterfaceBookingBuilder seat(int seat) {
        this.seat = seat;
        return this;
    }

    @Override
    public InterfaceBookingBuilder rentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
        return this;
    }

    @Override
    public InterfaceBookingBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public InterfaceBookingBuilder endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public InterfaceBookingBuilder pickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
        return this;
    }

    @Override
    public InterfaceBookingBuilder deposit(int deposit) {
        this.deposit = deposit;
        return this;
    }

    @Override
    public Booking build() {
        return new Booking(
                new Customer(username, phone, email, cccd, gplx),
                new Car(carId, brand, model, seat, rentalPrice),
                startDate,
                endDate,
                pickupLocation,
                deposit);
    }
}