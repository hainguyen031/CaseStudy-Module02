package builder;

import entity.Booking;
import entity.Car;
import entity.Customer;

public class BookingBuilder implements InterfaceBookingBuilder {
    protected String name;
    protected String cccd;
    protected String gplx;
    protected String brand;
    protected String model;
    protected String seat;
    protected String rentalPrice;
    protected String startDate;
    protected String endDate;
    protected Customer customer;
    protected Car car;
    private static final BookingBuilder bookingBuilder = new BookingBuilder();

    private BookingBuilder() {
    }

    public static BookingBuilder getInstance() {
        return bookingBuilder;
    }

    @Override
    public InterfaceBookingBuilder name(String name) {
        this.name = name;
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
    public InterfaceBookingBuilder seat(String seat) {
        this.seat = seat;
        return this;
    }

    @Override
    public InterfaceBookingBuilder rentalPrice(String rentalPrice) {
        this.rentalPrice = rentalPrice;
        return this;
    }

    @Override
    public InterfaceBookingBuilder startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public InterfaceBookingBuilder endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public Booking build() {
        return new Booking(customer, car, startDate, endDate);
    }

    @Override
    public InterfaceBookingBuilder customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public InterfaceBookingBuilder car(Car car) {
        this.car = car;
        return this;
    }
}
