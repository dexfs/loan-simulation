package com.dexdev.loansimulation.modules.simulation.services;

import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import com.dexdev.loansimulation.modules.simulation.repositories.InMemorySimulatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSimulationByIdService {
    @Autowired
    InMemorySimulatioRepository repository;

    public Simulation execute(Integer simulationId) {
        return repository.getById(simulationId);
    }
}
