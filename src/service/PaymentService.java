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
        System.out.println("nothing");
    }
}
