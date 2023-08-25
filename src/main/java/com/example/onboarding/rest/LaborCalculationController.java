package com.example.onboarding.rest;

import com.example.onboarding.domain.LaborCalculationRequest;
import com.example.onboarding.domain.LaborCalculationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//{
//        "length": 14,
//        "width": 12,
//          "pricePerSqft": 2.5
//        }
//this controller takes an input of length, width and pricePerUnit
//returns an id and price
public class LaborCalculationController {

    @PostMapping(value = "/LaborCalculationController")
    public LaborCalculationResponse Onboarding(@RequestBody LaborCalculationRequest params)
    {
        float laborPrice = params.getLength()* params.getWidth()* params.getPricePerSqft();
        LaborCalculationResponse myResponse = new LaborCalculationResponse(1234567890, laborPrice);
        return myResponse;

    }
}
