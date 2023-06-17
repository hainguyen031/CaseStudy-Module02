package service.File;

import builder.BookingBuilder;
import builder.CarBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import entity.Booking;
import entity.Car;
import entity.Customer;
import service.BookingService;
import service.CarService;
import service.UserService;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingFileService {
    private static final BookingFileService bookingFileService = new BookingFileService();
    private final String BOOKING_FILEPATH = "E:\\CODEGYM\\CaseStudy-Module02\\src\\data\\booking.csv";

    public BookingFileService() {}

    public static BookingFileService getInstance() {
        return bookingFileService;
    }

    public boolean isBookingExist() {
        try {
            FileReader fileReader = new FileReader(new File(BOOKING_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] data;
            while ((data = csvReader.readNext()) != null) {
                if (data.length >= 2) {
                    String id = data[5];
                    LocalDate startDate = LocalDate.parse(data[10]);
                    for (Booking booking : BookingService.getInstance().getBookingList()) {
                        if (booking.getId() == Integer.parseInt(id) && startDate.equals(booking.getStartDate())) {
                            return true;
                        }
                    }

                }
            }
            csvReader.close();
            fileReader.close();
        }catch (IOException exception) {
            System.err.println("Read file Error");
            exception.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return false; // Booking does not exist
    }
    public void writeBookingList() {
        if (isBookingExist()) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(BOOKING_FILEPATH));
            CSVWriter csvWriter = new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            for (Booking booking : BookingService.getInstance().getBookingList()) {
//                String[] bookingData = {
//                        booking.getCustomer().getUsername(),
//                        booking.getCustomer().getPhone(),
//                        booking.getCustomer().getEmail(),
//                        String.valueOf(booking.getCar().getId()),
//                        booking.getCar().getModel(),
//                        String.valueOf(booking.getStartDate()),
//                        String.valueOf(booking.getEndDate()),
//                        booking.getPickupLocation(),
//                        String.valueOf(booking.getDeposit())
//                };
                String[] data = booking.toArray();
                csvWriter.writeNext(data);
            }
            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Write file error");
            e.printStackTrace();
        }
    }

    public void readBookingList() {
        try {
            FileReader fileReader = new FileReader(new File(BOOKING_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] bookingData;
            while ((bookingData = csvReader.readNext()) != null) {
                if (bookingData.length >= 2) {
//                    String username = bookingData[0];
//                    String phone = bookingData[1];
//                    String email = bookingData[2];
//                    String id = bookingData[3];
//                    String carModel = bookingData[4];
//                    LocalDate startDate = LocalDate.parse(bookingData[5]);
//                    LocalDate endDate = LocalDate.parse(bookingData[6]);
//                    String pickupLocation = bookingData[7];
//                    String deposit = bookingData[8];
//                    // Tạo đối tượng Booking từ thông tin đọc được
//                    Customer customer = UserService.getInstance().getCustomerByUsername(username);
//                    Car car = CarService.getInstance().getCarById(Integer.parseInt(id));
//                    Booking booking = new Booking(customer, car, startDate, endDate, pickupLocation);
//                    BookingService.getInstance().getBookingList().add(booking);
                    Booking newBooking = BookingBuilder.getInstance()
                            .username(bookingData[0])
                            .phone(bookingData[1])
                            .email(bookingData[2])
                            .cccd(bookingData[3])
                            .gplx(bookingData[4])
                            .carId(Integer.parseInt(bookingData[5]))
                            .brand(bookingData[6])
                            .model(bookingData[7])
                            .seat(Integer.parseInt(bookingData[8]))
                            .rentalPrice(Integer.parseInt(bookingData[9]))
                            .startDate(LocalDate.parse(bookingData[10]))
                            .endDate(LocalDate.parse(bookingData[11]))
                            .pickupLocation(bookingData[12])
                            .deposit(Integer.parseInt(bookingData[13]))
                            .build();
                    BookingService.getInstance().getBookingList().add(newBooking);
                }
            }
            csvReader.close();
            fileReader.close();
        } catch (IOException exception) {
            System.err.println("Read file Error");
            exception.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

}
