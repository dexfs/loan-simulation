package com.dexdev.loansimulation.modules.simulation.controllers;

import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/simulation")
public class SimulationController {

    @GetMapping("/client-id/{id}")
    public List<Simulation> getByClientId(@PathVariable int id) {
        return List.of(
                new Simulation(
                        1,
                        id,
                        1000,
                        10,
                        new Date(),
                        1)
        );
    }
}
