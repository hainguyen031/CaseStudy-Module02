package entity;

public class Car {
    private int id;
    private static int countId = 1;
    private String brand;
    private String model;
    private int seats;
    private int rentPrice;
    private boolean available = true;

    public Car() {
    }

    public Car(String brand, String model, int seats, int rentPrice, boolean available) {
        this.id = countId++;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.rentPrice = rentPrice;
        this.available = available;
    }

    public Car(int id, String brand, String model, int seats, int rentPrice) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.rentPrice = rentPrice;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    @Override
    public String toString() {
        return "Car{" +
                "ID='" + countId + '\'' +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", seats=" + seats +
                ", rentalPrice=" + rentPrice +
                '}';
    }


}
