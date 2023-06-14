package builder;

import entity.Customer;
import entity.User;

public class CustomerBuilder implements InterfaceCustomerBuilder{
    protected String username;
    protected String password;
    protected String email;
    protected String phone;
    protected String name;
    protected String cccd;
    private String gplx;
    private static final CustomerBuilder customerBuilder = new CustomerBuilder();
    private CustomerBuilder() {}
    public static CustomerBuilder getInstance() {
        return customerBuilder;
    }
    @Override
    public InterfaceCustomerBuilder username(String username) {
        this.username = username;
        return this;
    }

    @Override
    public InterfaceCustomerBuilder password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public InterfaceCustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public InterfaceCustomerBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public InterfaceCustomerBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public InterfaceCustomerBuilder cccd(String cccd) {
        this.cccd = cccd;
        return this;
    }

    @Override
    public InterfaceCustomerBuilder gplx(String gplx) {
        this.gplx = gplx;
        return this;
    }

    @Override
    public Customer build() {
        return new Customer(username, password, phone, email, name, cccd, gplx);
    }
}
