package com.dexdev.loansimulation.modules.simulation.controllers;

import com.dexdev.loansimulation.modules.simulation.controllers.dtos.CreateSimulationRequest;
import com.dexdev.loansimulation.modules.simulation.controllers.dtos.CreateSimulationResponse;
import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import com.dexdev.loansimulation.modules.simulation.services.CreateSimulationService;
import com.dexdev.loansimulation.modules.simulation.services.GetSimulationByIdService;
import com.dexdev.loansimulation.shared.GenerateIDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;


import java.util.*;

@RestController
@RequestMapping("/simulation")
public class SimulationController {


    @Autowired
    CreateSimulationService createSimulationService;

    @Autowired
    GetSimulationByIdService getSimulationByIdService;

    @GetMapping("/client-id/{id}")
    public List<Simulation> getByClientId(@PathVariable int id) {
        return null;
    }

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody CreateSimulationRequest request) {
        Simulation newSimulation = createSimulationService.execute(request.clientId, request.amount, request.installments);
        UriComponents uriComponents = MvcUriComponentsBuilder
                .fromMethodName(SimulationController.class, "getById", newSimulation.getId())
                .build();

        return ResponseEntity
                .created(uriComponents.encode().toUri())
                .body(CreateSimulationResponse.create(newSimulation));

    }

    @GetMapping("{id}")
    public Simulation getById(@PathVariable("id") int id) {
        return getSimulationByIdService.execute(id);
    }
}
