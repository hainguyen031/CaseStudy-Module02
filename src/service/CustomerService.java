package service;

import entity.Customer;
import view.CustomerView;

public class CustomerService {
    private static final CustomerService customerService = new CustomerService();
    public static CustomerService getInstance() {
        return customerService;
    }

}
