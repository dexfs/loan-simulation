package com.dexdev.loansimulation.modules.simulation.repositories;

import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class InMemorySimulationRepositoryTest {
    @Autowired
    InMemorySimulatioRepository repository;

    @Test
    void testGetByIdTest() {
        Random rand = new Random();
        int id1 = Math.abs(rand.nextInt());
        int id2 = Math.abs(rand.nextInt());
        Simulation newSimulation1 = new Simulation(
                id1,
                1,
                100,
                10,
                1
        );

        Simulation newSimulation2 = new Simulation(
                id2,
                3,
                200,
                2,
                1
        );


        repository.save(newSimulation1);
        repository.save(newSimulation2);

        Simulation simulation = repository.getById(id1);
        Assertions.assertNotNull(simulation);
        Assertions.assertEquals(simulation, newSimulation1);
    }
}
