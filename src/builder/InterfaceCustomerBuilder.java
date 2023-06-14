package builder;

import entity.Customer;
import entity.User;

public interface InterfaceCustomerBuilder {
    InterfaceCustomerBuilder username(String username);
    InterfaceCustomerBuilder password(String password);
    InterfaceCustomerBuilder email(String email);
    InterfaceCustomerBuilder phone(String phone);
    InterfaceCustomerBuilder name(String name);
    InterfaceCustomerBuilder cccd(String cccd);
    InterfaceCustomerBuilder gplx(String gplx);
    Customer build();

}
