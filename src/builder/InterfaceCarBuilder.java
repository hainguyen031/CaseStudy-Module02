package builder;

import entity.Car;

public interface InterfaceCarBuilder {
    InterfaceCarBuilder id (int id);
    InterfaceCarBuilder brand(String brand);
    InterfaceCarBuilder model(String model);
    InterfaceCarBuilder seats(int seats);
    InterfaceCarBuilder rentPrice(int rentPrice);
    InterfaceCarBuilder available(boolean available);
    InterfaceCarBuilder describe(String describe);
    Car build();
}
