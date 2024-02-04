package com.dexdev.loansimulation.modules.customer.repositories;

import com.dexdev.loansimulation.modules.customer.entities.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository<Customer> {
    List<Customer> customers = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer customer = new Customer(1, "Test", LocalDate.parse("1983-01-01"), "123455", "RG");
        customers.add(customer);
    }

    public List<Customer> all(){
        return customers;
    }

    public void save(Customer customer) {
        customers.add(customer);
    }

    public Optional<Customer> getById(int clientId) {
        return customers.stream()
                .filter(c -> c.getId() == clientId)
                .findFirst();

    }
}
