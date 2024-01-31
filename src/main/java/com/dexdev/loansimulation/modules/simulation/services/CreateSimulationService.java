package com.dexdev.loansimulation.modules.simulation.services;

import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import com.dexdev.loansimulation.modules.simulation.repositories.InMemorySimulatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSimulationService {
    @Autowired
    InMemorySimulatioRepository repository;

    public Simulation execute(Simulation simulation) {
        repository.save(simulation);
        return simulation;
    }
}
