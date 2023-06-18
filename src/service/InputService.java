package service;

import builder.CarBuilder;
import entity.Car;
import entity.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputService {
    private static final InputService inputService = new InputService();
    private static Scanner scanner = new Scanner(System.in);
    private final String USERNAME_REGEX = "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
    private final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private final String NAME_REGEX = "^[a-zA-Z\\s]+";
    private final String EMAIL_REGEX = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    private final String MODEL_REGEX = "^[a-zA-Z0-9,]+";
    private final String SEAT_REGEX = "^[0-9]+";
    private final String PHONE_REGEX = "^\\d{10}$";
    private final String CCCD_REGEX = "^\\d{12}$";
    private final String GPLX_REGEX = "^\\d{12}$";
    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
    private final String LOCATION_REGEX = "^[a-zA-Z0-9,\\s]+$";

    public static InputService getInstance() {
        return inputService;
    }

    public int[] inputPriceRange() {
        int[] result = new int[2];
        while (true) {
            try {
                System.out.println("Input upper price range: ");
                int upper = Integer.parseInt(scanner.nextLine());
                System.out.println("Input lower price range: ");
                int lower = Integer.parseInt(scanner.nextLine());
                if (upper > lower) {
                    result[0] = lower;
                    result[1] = upper;
                    break;
                } else {
                    System.out.println("Invalid input !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter again.");
            }
        }
        return result;
    }

    public String inputInfo(String typeInfo) {
        String regex = "";
        switch (typeInfo) {
            case "username":
                regex = USERNAME_REGEX;
                break;
            case "password":
                regex = PASSWORD_REGEX;
                break;
            case "model":
                regex = MODEL_REGEX;
                break;
            case "seat":
                regex = SEAT_REGEX;
                break;
            case "name":
                regex = NAME_REGEX;
                break;
            case "email":
                regex = EMAIL_REGEX;
                break;
            case "phone":
                regex = PHONE_REGEX;
                break;
            case "cccd":
                regex = CCCD_REGEX;
                break;
            case "gplx":
                regex = GPLX_REGEX;
                break;
            case "startdate":
                regex = DATE_REGEX;
                break;
            case "enddate":
                regex = DATE_REGEX;
                break;
            case "pickupLocation":
                regex = LOCATION_REGEX;
                break;
        }
        Pattern pattern = Pattern.compile(regex);
        String text;
        Matcher matcher;
        while (true) {
            System.out.println("Input " + typeInfo + ": ");
            text = scanner.nextLine();
            matcher = pattern.matcher(text);
            if (matcher.matches()) {
                return text;
            } else {
                System.out.println("Invalid " + typeInfo);
            }
        }
    }

    public LocalDate inputDate() {
        Pattern pattern = Pattern.compile(DATE_REGEX);
        String text;
        while (true) {
            System.out.println("Input date (dd/mm/yyyy): ");
            text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()) {
                try {
                    return LocalDate.parse(text, DATE_FORMATTER);
                } catch (Exception e) {
                    System.out.println("Invalid date! Please enter a valid date");
                }
            } else {
                System.out.println("Invalid date! Please enter a valid date");
            }
        }
    }

    public int inputChoice() {
        System.out.print("Input your choice: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            return inputChoice();
        }
    }

    public int inputCarID() {
        System.out.println("Input the car ID:");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            return inputCarID();
        }
    }

    public Car inputCarInfo() {
        try {
            System.out.println("Input car brand: ");
            String brand = scanner.nextLine();
            System.out.println("Input car model: ");
            String model = scanner.nextLine();
            System.out.println("Input car seat: ");
            int seat = Integer.parseInt(scanner.nextLine());
            System.out.println("Input rental car: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Input describe car: ");
            String descri = scanner.nextLine();
            System.out.println("Add car successful !");
            return CarBuilder.getInstance()
                    .brand(brand)
                    .model(model)
                    .seats(seat)
                    .rentPrice(price)
                    .available(true)
                    .describe(descri)
                    .build();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.nextLine(); // Đọc và loại bỏ dòng chứa giá trị không hợp lệ
            return inputCarInfo(); // Gọi lại phương thức để yêu cầu nhập lại
        }

    }


    public int inputBookingId() {
        System.out.println("Input your booking ID:");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            return inputBookingId();
        }

    }
}
