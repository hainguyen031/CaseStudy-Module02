package service.File;

import builder.BookingBuilder;
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
import java.util.ArrayList;
import java.util.List;

public class BookingFileService {
    private static final BookingFileService bookingFileService = new BookingFileService();
    private final String BOOKING_FILEPATH = "E:\\CODEGYM\\CaseStudy-Module02\\src\\data\\booking.csv";

    public BookingFileService() {
    }

    List<Booking> bookingList = BookingService.getInstance().getBookingList();

    public static BookingFileService getInstance() {
        return bookingFileService;
    }

    public void writeBookingList() {
        try {
            FileWriter fileWriter = new FileWriter(new File(BOOKING_FILEPATH));
            CSVWriter csvWriter = new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            for (Booking booking : bookingList) {
                String[] bookingData = {
                        booking.getCustomer().getUsername(),
                        booking.getCustomer().getPhone(),
                        booking.getCustomer().getEmail(),
                        booking.getCar().getModel(),
                        booking.getStartDate().toString(),
                        booking.getEndDate().toString()
                };
                csvWriter.writeNext(bookingData);
            }
            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Write file error");
            e.printStackTrace();
        }
    }

    public void readBookingList() {
        List<Booking> bookings = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(new File(BOOKING_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
//            String[] dataList;
//            List<Booking> bookingList = BookingService.getInstance().getBookingList();
//            while ((dataList = csvReader.readNext()) != null) {
//                if (dataList.length >= 2) {
//                    Customer customer = new Customer();
//                    customer.setName(dataList[0]);
//                    Booking newBooking = BookingBuilder.getInstance()
//                            .customer(customer)
//                            .car(dataList[1])
//                            .startDate(dataList[2])
//                            .endDate(dataList[3])
//                            .build();
//                    BookingService.getInstance().getBookingList().add(newBooking);
//                }
//            }
            String[] bookingData;
            while ((bookingData = csvReader.readNext()) != null) {
                if (bookingData.length >= 4) {
                    String username = bookingData[0];
                    String phone = bookingData[1];
                    String email = bookingData[2];
                    String carModel = bookingData[3];
                    String startDate = bookingData[4];
                    String endDate = bookingData[5];

                    // Tạo đối tượng Booking từ thông tin đọc được
                    Customer customer = UserService.getInstance().getCustomerByUsername(username);
                    Car car = CarService.getInstance().getCarByModel(carModel);
                    Booking booking = new Booking(customer, car, startDate, endDate);

                    bookings.add(booking);
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
