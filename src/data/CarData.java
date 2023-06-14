package data;

import entity.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarData {
    private List<Car> carList;
    private static final String CAR_FILE = "E:\\CODEGYM\\Module 02\\Case Study\\APP THUE XE\\src\\Data\\Car.csv";

    public CarData() {
        carList = new ArrayList<>();
    }

    public void writeFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAR_FILE))) {
            writer.println("ID,Brand,Model,Seat,Price,Available");

            for (Car ele : carList) {
                writer.println(ele.getId() + "," +
                        ele.getBrand() + "," +
                        ele.getModel() + "," +
                        ele.getSeats() + "," +
                        ele.getRentPrice() + "," +
                        ele.isAvailable());
            }

            System.out.println("The data has been saved to a CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CAR_FILE))) {
            String line;
            // Bỏ qua dòng tiêu đề
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String brand = data[1];
                String model = data[2];
                int seat = Integer.parseInt(data[3]);
                int price = Integer.parseInt(data[4]);
                boolean available = Boolean.parseBoolean(data[5]);

                Car car = new Car(id, brand, model, seat, price);
                carList.add(car);
            }

            System.out.println("Dữ liệu đã được đọc từ file CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
