package com.example.onboarding.rest;

import com.example.onboarding.domain.MaterialCalculationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//{
//        "length": 14,
//        "width": 12,
//        "sqftPerGallon": 300
//        }
//takes in 3 parameters, returns gallons required
public class MaterialCalculationController {
    @PostMapping(value = "/MaterialCalculationController")
    public float Onboarding(@RequestBody MaterialCalculationRequest params)
    {
        MaterialCalculationRequest myCalc = new MaterialCalculationRequest(params.getLength(), params.getWidth(), params.getSqftPerGallon());
        return myCalc.gallonsRequired();
    }

}
