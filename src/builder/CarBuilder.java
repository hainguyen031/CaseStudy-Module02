package builder;

import entity.Car;
import service.CarService;

public class CarBuilder implements InterfaceCarBuilder{
    protected String brand;
    protected String model;
    protected int seats;
    protected int rentprice;
    protected boolean available;
    private static final CarBuilder carBuilder = new CarBuilder();
    private CarBuilder() {}
    public static CarBuilder getInstance() {
        return carBuilder;
    }
    @Override
    public InterfaceCarBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public InterfaceCarBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public InterfaceCarBuilder seats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public InterfaceCarBuilder rentPrice(int rentPrice) {
        this.rentprice = rentPrice;
        return this;
    }

    @Override
    public InterfaceCarBuilder available(boolean available) {
        this.available = available;
        return this;
    }

    @Override
    public Car build() {
        return new Car(brand, model, seats, rentprice, available);
    }
}
