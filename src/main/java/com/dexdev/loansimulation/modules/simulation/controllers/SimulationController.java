package com.dexdev.loansimulation.modules.simulation.controllers;

import com.dexdev.loansimulation.modules.simulation.controllers.validations.CreateSimulationRequest;
import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import com.dexdev.loansimulation.modules.simulation.services.CreateSimulationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/simulation")
public class SimulationController {
    @Autowired
    CreateSimulationService createSimulationService;

    @GetMapping("/client-id/{id}")
    public List<Simulation> getByClientId(@PathVariable int id) {
        return null;
    }

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody CreateSimulationRequest request) {
        Random rand = new Random();
        Simulation newSimulation = new Simulation(
                Math.abs(rand.nextInt()),
                request.clientId,
                request.amount,
                request.installments,
                1
        );
        createSimulationService.execute(newSimulation);
        UriComponents uriComponents = MvcUriComponentsBuilder
                .fromMethodName(SimulationController.class, "getById", newSimulation.getId())
                .build();

        return ResponseEntity
                .created(uriComponents.encode().toUri())
                .body(newSimulation);

    }

    @GetMapping("{id}")
    public Simulation getById(@PathVariable("id") int id) {
        return null;
    }
}
