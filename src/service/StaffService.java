package service;

import builder.CarBuilder;
import entity.Booking;
import entity.Car;
import entity.Payment;
import service.File.BookingFileService;
import service.File.CarFileService;
import service.File.PaymentFileService;
import view.StaffView;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class StaffService {
    private static final StaffService staffService = new StaffService();

    private StaffService() {
    }

    public static StaffService getInstance() {
        return staffService;
    }

    public void addCar() {
        System.out.println("-----Input car information-----");
        Car newCar = InputService.getInstance().inputCarInfo();
        newCar.setId(CarFileService.getInstance().readCurentIdFromFile() + 1);
        CarService.getInstance().getCarList().add(newCar);
    }

    public void deletaCar() {
        System.out.println("-----Delete car-----");
        boolean checkDelete = false;
        int carid = InputService.getInstance().inputCarID();
        for (Car car : CarService.getInstance().getCarList()) { // chua xong
            if (car.getId() == carid) {
                CarService.getInstance().getCarList().remove(car);
                checkDelete = true;
                break;
            }
        }
        if (checkDelete) {
            System.out.println("Delete success");
        } else {
            System.out.println("Car do not exist");
        }
    }

    public void processPayment() {
        Booking bookingCar = PaymentService.getInstance().getBookingCarPay();
        if (bookingCar != null) {
            Car car = bookingCar.getCar();
            LocalDate startDate = bookingCar.getStartDate();
            LocalDate endDate = bookingCar.getEndDate();
            int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
            int total = car.getRentPrice() * numberOfDays;

            int surcharge = confirmRentalReturn();

            System.out.println("ID car: " + car.getId());
            System.out.println("Brand car: " + car.getBrand());
            System.out.println("Model car: " + car.getModel());
            System.out.println("Start date rental: " + startDate);
            System.out.println("End date rental: " + endDate);
            System.out.println("Total date rental: " + numberOfDays);
            System.out.println("Rental price: " + car.getRentPrice());
            System.out.println("Surcharge (if any): " + surcharge );
            System.out.println("Total pay:" + total + surcharge);
            car.setAvailable(true);
            Payment payment = new Payment(car.getId(), car.getBrand(), car.getModel(), car.getRentPrice(), startDate, endDate, numberOfDays, total);
            payment.setSurcharge(surcharge);
            PaymentService.getInstance().getPaymentList().add(payment);
            BookingService.getInstance().getBookingList().remove(bookingCar);
            BookingFileService.getInstance().writeBookingList();
            PaymentFileService.getInstance().writePaymentFile();
            CarFileService.getInstance().writeCarList();
        } else {
            System.out.println("Invalid car ID payment");
        }

    }

    public int confirmRentalReturn() {
        int surcharge = 0;
        System.out.println("-----Input car condition after rental-----");
        System.out.println("1. Normal");
        System.out.println("2. Scratched");
        System.out.println("3. Collide");
        int choice = InputService.getInstance().inputChoice();
        switch (choice) {
            case 1:
                surcharge = 0;
                break;
            case 2:
                surcharge = 1000000;
                break;
            case 3:
                surcharge = 5000000;
                break;
            default:
                System.out.println("Invalid input");
        }
        return surcharge;
    }

    public void orderRentalLocation() {
        System.out.println("-----Information on delivery of the car to the rental point-----");
        System.out.println("Customer: ");
        System.out.println("Order rental location: ");
        System.out.println("Car information: ");
        System.out.println("Delivery time: ");
    }
}
