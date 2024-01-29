package com.dexdev.loansimulation.modules.customer.entities;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String name;
    private LocalDate birthDate;

    private String ssn;
    private String ssnType;

    public Customer(int id, String name, LocalDate birthDate, String ssn, String ssnType) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.ssn = ssn;
        this.ssnType = ssnType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsnType() {
        return ssnType;
    }

    public void setSsnType(String ssnType) {
        this.ssnType = ssnType;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", ssn='" + ssn + '\'' +
                ", ssnType='" + ssnType + '\'' +
                '}';
    }
}
