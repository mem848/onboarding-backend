package com.example.onboarding.rest;

import com.example.onboarding.domain.MaterialCalculationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MaterialCalculationController {
    @PostMapping(value = "/MaterialCalculationController")
    public float MaterialCalculationController(@RequestBody MaterialCalculationRequest params)
    {
        MaterialCalculationRequest myCalc = new MaterialCalculationRequest(params.getLength(), params.getWidth(), params.getSqftPerGallon());
        return myCalc.myCalcuation();
    }

}
