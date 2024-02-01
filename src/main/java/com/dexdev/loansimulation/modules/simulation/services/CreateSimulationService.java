package com.dexdev.loansimulation.modules.simulation.services;

import com.dexdev.loansimulation.modules.product.entities.InstallmentTax;
import com.dexdev.loansimulation.modules.product.repositories.InMemoryProductRepository;
import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import com.dexdev.loansimulation.modules.simulation.entities.SimulationInstallment;
import com.dexdev.loansimulation.modules.simulation.repositories.InMemorySimulatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateSimulationService {
    @Autowired
    InMemorySimulatioRepository repository;

    @Autowired
    InMemoryProductRepository productRepository;

    public Simulation execute(Simulation simulation, int installments) {
        List<SimulationInstallment> simulationInstallments = calculate(simulation, installments);

        simulationInstallments.forEach(simulation::addInstallment);

        repository.save(simulation);
        return simulation;
    }

    private List<SimulationInstallment> calculate(Simulation simulation, int installments) {
        List<SimulationInstallment> simulationInstallments = new ArrayList<>();
        List<InstallmentTax> taxes = productRepository.getInstallmentsByProductIdAndQuantity(simulation.getProductId(), installments);
        taxes.forEach(tax -> {
            double installmentValue = calculateInstallmentValue(simulation.getAmount(), tax.getValue(), tax.getNumber());
            SimulationInstallment newSimulationInstallment = new SimulationInstallment(
                    tax.getNumber(),
                    installmentValue
            );
            simulationInstallments.add(newSimulationInstallment);
        });

        return simulationInstallments;
    }

    private double calculateInstallmentValue(double amount, double taxValue, int installmentNumber) {
        double tTax = taxValue / 100;
        double calculatedValue = (amount * tTax) / (1 - (1 / (Math.pow((1 + tTax), installmentNumber))));
        return new BigDecimal(calculatedValue).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
}
