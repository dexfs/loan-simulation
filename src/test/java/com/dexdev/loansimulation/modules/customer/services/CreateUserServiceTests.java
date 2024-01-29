package com.dexdev.loansimulation.modules.customer.services;

import com.dexdev.loansimulation.modules.customer.entities.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class CreateUserServiceTests {
    @Autowired
    CreateUserService service;

    @Autowired
    AllCustomersService allCustomersService;

    @Test
    void testCreateNewUser() {
        Customer newCustomer = new Customer(1, "Teste", LocalDate.parse("2000-11-11"), "1123123", "RG");
        service.execute(newCustomer);

        List<Customer> customers = allCustomersService.execute();

        Assertions.assertNotNull(customers);
        Assertions.assertEquals(customers.size(), 2);
    }
}
