package com.dexdev.loansimulation.modules.customer.controllers;

import com.dexdev.loansimulation.modules.customer.controllers.validations.CreateCustomerRequest;
import com.dexdev.loansimulation.modules.customer.entities.Customer;
import com.dexdev.loansimulation.modules.customer.services.AllCustomersService;
import com.dexdev.loansimulation.modules.customer.services.CreateUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController()
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    AllCustomersService allCustomersService;

    @Autowired
    CreateUserService createUserService;

    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody CreateCustomerRequest request) {
        Random rand = new Random();
        Customer newCustomer = new Customer(
                Math.abs(rand.nextInt()),
                request.name,
                LocalDate.parse(request.birthDate),
                request.ssn,
                request.ssnType
        );
        createUserService.execute(newCustomer);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public List<Customer> all() {
        return allCustomersService.execute();
    }
}