package builder;

import entity.Payment;

import java.time.LocalDate;

public class PaymentBuilder implements InterfacePaymentBuilder{
    protected String username;
    protected String phone;
    protected String email;
    protected int carId;
    protected String brand;
    protected String model;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected int numberOfDays;
    protected int rentPrice;
    protected int surcharge;
    protected int total;
    protected int bookingId;
    private static final PaymentBuilder paymentBuilder = new PaymentBuilder();
    private PaymentBuilder() {}
    public static PaymentBuilder getInstance() {
        return paymentBuilder;
    }
    @Override
    public InterfacePaymentBuilder username(String username) {
        this.username = username;
        return this;
    }

    @Override
    public InterfacePaymentBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public InterfacePaymentBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public InterfacePaymentBuilder carId(int carId) {
        this.carId = carId;
        return this;
    }

    @Override
    public InterfacePaymentBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public InterfacePaymentBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public InterfacePaymentBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public InterfacePaymentBuilder endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public InterfacePaymentBuilder numberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
        return this;
    }

    @Override
    public InterfacePaymentBuilder rentalPrice(int rentalPrice) {
        this.rentPrice = rentalPrice;
        return this;
    }

    @Override
    public InterfacePaymentBuilder surcharge(int surcharge) {
        this.surcharge = surcharge;
        return this;
    }

    @Override
    public InterfacePaymentBuilder total(int total) {
        this.total = total;
        return this;
    }

    @Override
    public InterfacePaymentBuilder bookingId(int bookingId) {
        this.bookingId = bookingId;
        return this;
    }

    @Override
    public Payment build() {
        return new Payment(username, phone, email, carId, brand, model, startDate, endDate, numberOfDays, rentPrice, surcharge, total, bookingId);
    }
}
