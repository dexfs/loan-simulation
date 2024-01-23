package com.dexdev.loansimulation.modules.client.controllers;

import com.dexdev.loansimulation.modules.client.entities.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Client> all() {
        return Arrays.asList(
                new Client(1, "Andre Santos", LocalDate.parse("1983-08-25"), "1234567890", "RG"),
                new Client(1, "Andre Santos", LocalDate.parse("1983-08-25"), "1234567890", "RG")
        );
    }
}
