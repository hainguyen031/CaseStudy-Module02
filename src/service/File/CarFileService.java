package service.File;

//import com.opencsv.CSVWriter;
//
//import java.io.File;
//import java.io.FileWriter;

public class CarFileService {
    private static final CarFileService carFileService = new CarFileService();
    private final String CAR_FILEPATH = "E:\\CODEGYM\\Module 02\\Case Study\\APP THUE XE\\src\\Data\\car.csv";

    public CarFileService() {
    }

    public static CarFileService getInstance() {
        return carFileService;
    }
    public void writeCarList() {
//        try {
//            FileWriter fileWriter = new FileWriter(new File(CAR_FILEPATH));
//            CSVWriter csvWriter = new CSVWriter(fileWriter)
//        }
    }
}
