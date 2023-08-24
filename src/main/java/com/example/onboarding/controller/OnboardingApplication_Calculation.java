package com.example.onboarding.controller;

import com.example.onboarding.model.LaborCalculation;
import com.example.onboarding.model.LaborParamsCalculation;
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
    @PostMapping(value = "/Onboarding_Calculation")
    //creates postMapping operation, expecting a plain text
    public float Onboarding_Calculation(@RequestBody LaborParamsCalculation params)
    {
        LaborCalculation myCalc = new LaborCalculation(params.getLength(), params.getWidth(), params.getSqftPerGallon());
        return myCalc.myCalcuation();

    }
}

