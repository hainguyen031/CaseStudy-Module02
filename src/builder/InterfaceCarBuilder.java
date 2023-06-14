package builder;

import entity.Car;

public interface InterfaceCarBuilder {
    InterfaceCarBuilder brand(String brand);
    InterfaceCarBuilder model(String model);
    InterfaceCarBuilder seats(int seats);
    InterfaceCarBuilder rentPrice(int rentPrice);
    InterfaceCarBuilder available(boolean available);
    Car build();
}
