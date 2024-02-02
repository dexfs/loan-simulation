package com.dexdev.loansimulation.modules.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(int customerId) {
        super("Customer not found with  ID:" + customerId);
    }
}
