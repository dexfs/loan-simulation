package com.dexdev.loansimulation.modules.customer.controllers;

import com.dexdev.loansimulation.modules.customer.controllers.request.CreateCustomerRequest;
import com.dexdev.loansimulation.modules.customer.entities.Customer;
import com.dexdev.loansimulation.modules.customer.services.AllCustomersService;
import com.dexdev.loansimulation.modules.customer.services.CreateUserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController()
@RequestMapping("/customers")
@Tag(name = "Customer Rest Endpoint")
public class CustomerController {
    @Autowired
    AllCustomersService allCustomersService;

    @Autowired
    CreateUserService createUserService;

    @PostMapping()
    public @ApiResponse(responseCode = "201") ResponseEntity<Customer> create(@Valid @RequestBody CreateCustomerRequest request) {
        Random rand = new Random();
        Customer newCustomer = new Customer(
                Math.abs(rand.nextInt()),
                request.name,
                LocalDate.parse(request.birthDate.toString()),
                request.ssn,
                request.ssnType
        );
        createUserService.execute(newCustomer);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping()
    public List<Customer> all() {
        return allCustomersService.execute();
    }
}
