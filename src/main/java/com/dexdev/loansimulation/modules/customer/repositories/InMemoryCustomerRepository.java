package com.dexdev.loansimulation.modules.customer.repositories;

import com.dexdev.loansimulation.modules.customer.entities.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository<Customer> {
    List<Customer> customers = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer customer = new Customer(1, "Andre", LocalDate.parse("1983-08-25"), "123455", "CPF");
        customers.add(customer);
    }

    public List<Customer> all(){
        return customers;
    }

    public void save(Customer customer) {
        customers.add(customer);
    }
}
