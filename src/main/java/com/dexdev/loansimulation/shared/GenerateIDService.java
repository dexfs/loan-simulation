package com.dexdev.loansimulation.shared;


import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateIDService {
    public Integer execute() {
        Random rand = new Random();
        return Math.abs(rand.nextInt());
    }
}
