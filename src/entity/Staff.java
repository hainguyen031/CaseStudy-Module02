package entity;

import service.CarService;

import java.util.Scanner;

public class Staff extends User {
    //    Scanner scanner = new Scanner(System.in);
//    CarService carService = new CarService();
//    Car car = new Car();
//
//    public void addCar() {
//        System.out.println("Input car brand: ");
//        car.setBrand(scanner.nextLine());
//        System.out.println("Input car model: ");
//        car.setModel(scanner.nextLine());
//        System.out.println("Input car seat: ");
//        car.setSeats(Integer.parseInt(scanner.nextLine()));
//        System.out.println("Input rental car: ");
//        car.setRentPrice(Integer.parseInt(scanner.nextLine()));
//        carService.addCarToList(car);
//        System.out.println("Add car successful !");
//        System.out.println("-----------------------");
//    }
//    public void deleteCar() {
//        while (true) {
//            System.out.println("Input ID car: ");
//            boolean success = false;
//            int idCheck = Integer.parseInt(scanner.nextLine());
//            for (Car ele: CarService.getCarList()) {
//                if (ele.getId() == idCheck) {
//                    CarService.getCarList().remove(ele);
//                    success = true;
//                }
//            }
//            if (success) {
//                break;
//            } else {
//                System.out.println("ID don't exist, please input again !");
//            }
//        }
//    }
    private static final Staff staff = new Staff(
            "staff",
            "staff123",
            "0984872656",
            "rentalcar@gmail.com"
    );

    private Staff(String username, String password, String phone, String email) {
        super(username, password, phone, email);
        super.setId(0);
    }
    public static Staff getInstance() {
        return staff;
    }
}
