package service.File;

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

    List<Payment> paymentList = PaymentService.getInstance().getPaymentList();
    private final String PAYMENT_FILEPATH = "E:\\CODEGYM\\CaseStudy-Module02\\src\\data\\payment.csv";

    public boolean isPaymentExist() {
        try {
            FileReader fileReader = new FileReader(new File(PAYMENT_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] data;
            while ((data = csvReader.readNext()) != null) {
                if (data.length >= 2) {
                    String carID = data[0];
                    LocalDate startDate = LocalDate.parse(data[4]);
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

            for (Payment payment : paymentList) {
                String[] data = {
                        String.valueOf(payment.getCarId()),
                        payment.getBrand(),
                        payment.getModel(),
                        String.valueOf(payment.getRentPrice()),
                        String.valueOf(payment.getStartDate()),
                        String.valueOf(payment.getEndDate()),
                        String.valueOf(payment.getNumberOfDays()),
                        String.valueOf(payment.getTotal())
                };
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
                    int carId = Integer.parseInt(data[0]);
                    String brand = data[1];
                    String model = data[2];
                    int rentPrice = Integer.parseInt(data[3]);
                    LocalDate startDate = LocalDate.parse(data[4]);
                    LocalDate endDate = LocalDate.parse(data[5]);
                    int numberOfDays = Integer.parseInt(data[6]);
                    int total = Integer.parseInt(data[7]);
                    Payment newPayment = new Payment(carId, brand, model, rentPrice, startDate, endDate, numberOfDays, total);
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
