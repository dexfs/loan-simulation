package com.dexdev.loansimulation.modules.simulation.repositories;

import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemorySimulatioRepository {
    private List<Simulation> simulations = new ArrayList<Simulation>();

    public Simulation save(Simulation simulation) {
        simulations.add(simulation);
        return simulation;
    }

    public Simulation getById(int simulationId) {
        return simulations.stream()
                .filter(simulation -> simulation.getId() == simulationId)
                .findFirst()
                .orElse(null);
    }
}
