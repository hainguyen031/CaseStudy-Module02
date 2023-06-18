package service.File;

import builder.PaymentBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import entity.Payment;
import service.PaymentService;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PaymentFileService {
    private final static PaymentFileService paymentFileService = new PaymentFileService();

    private PaymentFileService() {
    }

    public static PaymentFileService getInstance() {
        return paymentFileService;
    }

    private final String PAYMENT_FILEPATH = "E:\\CODEGYM\\CaseStudy-Module02\\src\\data\\payment.csv";

    public boolean isPaymentExist() {
        try {
            FileReader fileReader = new FileReader(new File(PAYMENT_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] data;
            while ((data = csvReader.readNext()) != null) {
                if (data.length >= 2) {
                    String carID = data[3];
                    LocalDate startDate = LocalDate.parse(data[6]);
                    for (Payment payment : PaymentService.getInstance().getPaymentList()) {
                        if ((payment.getCarId() == Integer.parseInt(carID)) && startDate.equals(payment.getStartDate())) {
                            return true;
                        }
                    }
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
        return false;
    }
    public void writePaymentFile() {
        if (isPaymentExist()) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(PAYMENT_FILEPATH));
            CSVWriter csvWriter = new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            for (Payment payment : PaymentService.getInstance().getPaymentList()) {
                String[] data = payment.toArray();
                csvWriter.writeNext(data);
            }
            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Write file error");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Null");
        }
    }

    public void readPaymentFile() {
        try {
            FileReader fileReader = new FileReader(new File(PAYMENT_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] data;
            while ((data = csvReader.readNext()) != null) {
                if (data.length >= 2) {
                    Payment newPayment = PaymentBuilder.getInstance()
                            .username(data[0])
                            .phone(data[1])
                            .email(data[2])
                            .carId(Integer.parseInt(data[3]))
                            .brand(data[4])
                            .model(data[5])
                            .startDate(LocalDate.parse(data[6]))
                            .endDate(LocalDate.parse(data[7]))
                            .numberOfDays(Integer.parseInt(data[8]))
                            .rentalPrice(Integer.parseInt(data[9]))
                            .surcharge(Integer.parseInt(data[10]))
                            .total(Integer.parseInt(data[11]))
                            .bookingId(Integer.parseInt(data[12]))
                            .build();
                    PaymentService.getInstance().getPaymentList().add(newPayment);
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
