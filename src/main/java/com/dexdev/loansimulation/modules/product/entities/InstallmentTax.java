package com.dexdev.loansimulation.modules.product.entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class InstallmentTax implements Serializable {
    private int number;
    private double value;

    public InstallmentTax(int instalmentNumber, float value) {
        this.number = instalmentNumber;
        this.value = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
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

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "number=" + number +
                ", value=" + value +
                '}';
    }
}
