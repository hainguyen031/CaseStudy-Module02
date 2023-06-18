package service;

import entity.Booking;
import entity.Car;
import entity.Payment;
import service.File.BookingFileService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private static List<Payment> paymentList;
    private final static PaymentService paymentService = new PaymentService();

    private PaymentService() {
    }

    public static PaymentService getInstance() {
        return paymentService;
    }
    static {
        paymentList = new ArrayList<>();
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        PaymentService.paymentList = paymentList;
    }

    public Booking getBookingCarPay() {
        int carID = InputService.getInstance().inputCarID();
        for (Booking bk : BookingService.getInstance().getBookingList()) {
            if (bk.getCar().getId() == carID) {
                return bk;
            }
        }
        return null;
    }

    public void showPayment() {
        int bookingId = InputService.getInstance().inputBookingId();
        Payment payment = PaymentService.getInstance().getPaymentById(bookingId);
        if (payment == null) {
            System.out.println("Cannot find the booking with ID: " + bookingId);
            return;
        }
        System.out.println("-----BILL-----");
        System.out.println("Booking ID: " + payment.getBookingId());
        System.out.println("Rental start date: " + payment.getStartDate());
        System.out.println("Rental end date: " + payment.getEndDate());
        System.out.println("Total rental days: " + payment.getNumberOfDays());
        System.out.println("Customer information:");
        System.out.println("  - Name: " + payment.getUsername());
        System.out.println("  - Phone: " + payment.getPhone());
        System.out.println("  - Email: " + payment.getEmail());
        System.out.println("Rental car information:");
        System.out.println("  - Car ID: " + payment.getCarId());
        System.out.println("  - Car brand: " + payment.getBrand());
        System.out.println("  - Car model: "+ payment.getModel());
        System.out.println("  - Rental price: " + payment.getRentPrice());
        System.out.println("Surcharge(if any): " + payment.getSurcharge());
        System.out.println("Total rent: " + payment.getTotal());
    }

    private Payment getPaymentById(int bookingId) {
        for (Payment payment : paymentList) {
            if (payment.getBookingId() == bookingId) {
                return payment;
            }
        }
        return null;
    }
}
