package com.example.onboarding.rest;

import com.example.onboarding.domain.LaborCalculationRequest;
import com.example.onboarding.domain.LaborCalculationResponse;
import com.example.onboarding.service.LaborCalculationService;
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
        LaborCalculationService service = new LaborCalculationService();
        return service.laborCalculationService(params);

    }
}
