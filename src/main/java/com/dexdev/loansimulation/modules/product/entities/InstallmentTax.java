package com.dexdev.loansimulation.modules.product.entities;


import java.io.Serializable;

public class InstallmentTax implements Serializable {
    private int number;
    private float value;

    public InstallmentTax(int instalmentNumber, float value) {
        this.number = instalmentNumber;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
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
