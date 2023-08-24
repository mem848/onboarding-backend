package com.example.onboarding.controller;

import com.example.onboarding.domain.MaterialCalculationRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class OnboardingApplication_Calculation {

    public static void main(String[] args) {
        SpringApplication.run(OnboardingApplication_Calculation.class, args);

    }

    // Onboarding_Calculation is Redundant, should test the Mater
    @PostMapping(value = "/Onboarding_Calculation")
    //creates postMapping operation, expecting a plain text
    public float Onboarding_Calculation(@RequestBody MaterialCalculationRequest params)
    {
        MaterialCalculationRequest myCalc = new MaterialCalculationRequest(params.getLength(), params.getWidth(), params.getSqftPerGallon());
        return myCalc.myCalcuation();

    }
}

