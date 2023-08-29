package com.example.onboarding.rest;

import com.example.onboarding.domain.MaterialCalculationRequest;
import com.example.onboarding.domain.MaterialCalculationResponse;
import com.example.onboarding.service.MaterialCalculationService;
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
    public MaterialCalculationResponse Onboarding(@RequestBody MaterialCalculationRequest params)
    {
        MaterialCalculationService service = new MaterialCalculationService();
        return service.materialCalculationService(params);
    }

}
