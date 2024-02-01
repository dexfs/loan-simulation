package com.dexdev.loansimulation.modules.simulation.entities;

public class SimulationInstallment {
    private int number;
    private double value;

    public SimulationInstallment(int number, double value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

