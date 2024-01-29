package com.dexdev.loansimulation.modules.customer.services;

import com.dexdev.loansimulation.modules.customer.entities.Customer;
import com.dexdev.loansimulation.modules.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    @Autowired
    CustomerRepository customerRepository;


    public void execute(Customer customer) {
        customerRepository.save(customer);
    }
}
