package service.File;

import builder.CustomerBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import entity.Customer;
import entity.User;
import service.UserService;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class UserFileService {
    private static final UserFileService userFileService = new UserFileService();
    private final String USER_FILEPATH = "E:\\CODEGYM\\CaseStudy-Module02\\src\\data\\user.csv";

    public UserFileService() {
    }

    public static UserFileService getInstance() {
        return userFileService;
    }

    public boolean isUserExist() {
        try {
            FileReader fileReader = new FileReader(new File(USER_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] dataList;
            while ((dataList = csvReader.readNext()) != null) {
                if (dataList.length >= 2) {
                    String username = dataList[0];
                    if (username.equals(CustomerBuilder.getInstance().build().getUsername())) {
                        return true;
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

    public void writeUserList() {
        if (isUserExist()) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(USER_FILEPATH));
            CSVWriter csvWriter = new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<User> userList = UserService.getInstance().getUserList();
            for (User user : UserService.getInstance().getUserList()) {
                if (user.getUsername().equals("staff")) {
                    continue;
                }
                String[] customerStringArray = ((Customer) user).toArray();
                csvWriter.writeNext(customerStringArray);
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

    public void readUserList() {
        try {
            FileReader fileReader = new FileReader(new File(USER_FILEPATH));
            CSVReader csvReader = new CSVReader(fileReader);
            String[] dataList;
            List<User> userList = UserService.getInstance().getUserList();
            while ((dataList = csvReader.readNext()) != null) {
                if (dataList.length >= 2) {
                    User newUser = CustomerBuilder.getInstance()
                            .username(dataList[0])
                            .password(dataList[1])
                            .email(dataList[2])
                            .phone(dataList[3])
                            .name(dataList[4])
                            .cccd(dataList[5])
                            .gplx(dataList[6])
                            .build();
                    UserService.getInstance().getUserList().add(newUser);
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
