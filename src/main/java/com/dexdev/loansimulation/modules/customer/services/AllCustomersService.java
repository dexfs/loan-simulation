package com.dexdev.loansimulation.modules.customer.services;

import com.dexdev.loansimulation.modules.customer.entities.Customer;
import com.dexdev.loansimulation.modules.customer.repositories.CustomerRepository;
import com.dexdev.loansimulation.modules.customer.repositories.InMemoryCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllCustomersService {

    @Autowired
    InMemoryCustomerRepository repository;
    public List<Customer> execute() {
        return repository.all();
    }
}
