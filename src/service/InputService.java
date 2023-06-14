package service;

import builder.CarBuilder;
import entity.Car;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputService {
    private static final InputService inputService = new InputService();
    private static Scanner scanner = new Scanner(System.in);
    private final String USERNAME_REGEX = "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
    private final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private final String NAME_REGEX = "^[a-zA-Z\\s]+";
    private final String EMAIL_REGEX = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    private final String MODEL_REGEX = "^[a-zA-Z0-9]+";
    private final String SEAT_REGEX = "^\\d[0-9]+";
    private final String PHONE_REGEX = "^\\d{10}$";
    private final String CCCD_REGEX = "^\\d{12}$";
    private final String GPLX_REGEX = "^\\d{12}$";

    public static InputService getInstance() {
        return inputService;
    }

    public int[] inputPriceRange() {
        int[] result = new int[2];
        while (true) {
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

    public int inputChoice() {
        System.out.print("Input your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputCarID() {
        System.out.println("Input the car ID:");
        return Integer.parseInt(scanner.nextLine());
    }

    public Car inputCarInfo() {
        System.out.println("Input car brand: ");
        String brand = scanner.nextLine();
        System.out.println("Input car model: ");
        String model = scanner.nextLine();
        System.out.println("Input car seat: ");
        int seat = Integer.parseInt(scanner.nextLine());
        System.out.println("Input rental car: ");
        int price =Integer.parseInt(scanner.nextLine());
//        CarService.getInstance().addCarToList(new Car(brand, model, seat, price, true));
        System.out.println("Add car successful !");
        return CarBuilder.getInstance()
                .brand(brand)
                .model(model)
                .seats(seat)
                .rentPrice(price)
                .available(true)
                .build();
    }

    // -------------chua xong------------
//    public void inputInfoCustomerBooking() {
//        List<String> customers = new ArrayList<>();
//        System.out.println("Input CCCD: ");
//        int cccd = Integer.parseInt(scanner.nextLine());
//        System.out.println("Input GPLX: ");
//        String gplx = scanner.nextLine();
//        return customers.add(cccd, gplx);
//    }
}
