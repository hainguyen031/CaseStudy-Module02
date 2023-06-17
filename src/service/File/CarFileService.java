package service.File;

import builder.CarBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import entity.Car;
import service.CarService;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CarFileService {
    private static final CarFileService carFileService = new CarFileService();
    private final String CAR_FILEPATH = "E:\\CODEGYM\\CaseStudy-Module02\\src\\data\\car.csv";

    public CarFileService() {
    }

    public static CarFileService getInstance() {
        return carFileService;
    }

    public boolean isCarExist() {
        try {
            FileReader fileReader = new FileReader(new File(CAR_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] dataList;
            while ((dataList = csvReader.readNext()) != null) {
                if (dataList.length >= 2) {
                    String brand = dataList[0];
                    String model = dataList[1];
                    String seat = dataList[2];
                    String rentPrice = dataList[3];
                    if (brand.equals(CarBuilder.getInstance().build().getBrand())
                            && model.equals(CarBuilder.getInstance().build().getModel())) {
                        return true; // Booking already exists
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
        return false; // Booking does not exist
    }

    public void writeCarList() {
        if (isCarExist()) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(CAR_FILEPATH));
            CSVWriter csvWriter = new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            for (Car car : CarService.getInstance().getCarList()) {
                String[] carStringArray = car.toArray();
                csvWriter.writeNext(carStringArray);
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

    public void readCarList() {
        try {
            FileReader fileReader = new FileReader(new File(CAR_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] dataList;
            List<Car> carList = CarService.getInstance().getCarList();
            while ((dataList = csvReader.readNext()) != null) {
                if (dataList.length >= 2) {
                    Car newCar = CarBuilder.getInstance()
                            .id(Integer.parseInt(dataList[0]))
                            .brand(dataList[1])
                            .model(dataList[2])
                            .seats(Integer.parseInt(dataList[3]))
                            .rentPrice(Integer.parseInt(dataList[4]))
                            .available(Boolean.parseBoolean(dataList[5]))
                            .describe(dataList[6])
                            .build();
                    CarService.getInstance().getCarList().add(newCar);
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

    public int readCurentIdFromFile() {
        try {
            FileReader fileReader = new FileReader(new File(CAR_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String idString = "0";
            String[] dataList;
            while ((dataList = csvReader.readNext()) != null) {
                if (dataList.length >= 2) {
                    idString = dataList[0];
                }
            }
            return Integer.parseInt(idString);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
