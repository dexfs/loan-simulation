package com.dexdev.loansimulation.modules.simulation.services;

import com.dexdev.loansimulation.modules.customer.entities.Customer;
import com.dexdev.loansimulation.modules.customer.repositories.InMemoryCustomerRepository;
import com.dexdev.loansimulation.modules.product.entities.InstallmentTax;
import com.dexdev.loansimulation.modules.product.entities.Product;
import com.dexdev.loansimulation.modules.product.repositories.InMemoryProductRepository;
import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import com.dexdev.loansimulation.modules.simulation.entities.SimulationInstallment;
import com.dexdev.loansimulation.modules.simulation.repositories.InMemorySimulatioRepository;
import com.dexdev.loansimulation.shared.GenerateIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateSimulationService {
    @Autowired
    GenerateIDService generateIDService;

    @Autowired
    InMemorySimulatioRepository repository;

    @Autowired
    InMemoryProductRepository productRepository;

    @Autowired
    InMemoryCustomerRepository customerRepository;

    public Simulation execute(Integer clientId, double amount, int installments) {
        Product product = productRepository.getById(1);
        Customer customer = customerRepository.getById(clientId);
        Simulation newSimulation = new Simulation(
                generateIDService.execute(),
                customer,
                amount,
                product
        );
        List<SimulationInstallment> simulationInstallments = calculate(newSimulation, installments);

        simulationInstallments.forEach(newSimulation::addInstallment);

        repository.save(newSimulation);
        return newSimulation;
    }

    private List<SimulationInstallment> calculate(Simulation simulation, int installments) {
        List<SimulationInstallment> simulationInstallments = new ArrayList<>();
        List<InstallmentTax> taxes = productRepository.getInstallmentsByProductIdAndQuantity(simulation.getProduct().getId(), installments);
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
