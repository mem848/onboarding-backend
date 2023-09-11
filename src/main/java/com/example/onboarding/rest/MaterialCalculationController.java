package com.example.onboarding.rest;

import com.example.onboarding.domain.Material;
import com.example.onboarding.domain.MaterialCalculated;
import com.example.onboarding.rest.resources.mappers.MaterialCalculationMapper;
import com.example.onboarding.rest.resources.v1.MaterialCalculationRequest;
import com.example.onboarding.rest.resources.v1.MaterialCalculationResponse;
import com.example.onboarding.service.MaterialCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    MaterialCalculationService service;
    @Autowired
    MaterialCalculationMapper mapper;
    @PostMapping(value = "/Material/Calculation")
    public MaterialCalculationResponse materialCalculationController(@RequestBody MaterialCalculationRequest params)
    {
        //request to MaterialCalculated
        MaterialCalculated calculated = mapper.requestToCalculated(params);
        //service call on calculated object
        Material material = service.setPriceService(calculated);
        //map to response and return
        return mapper.materialToResponse(material);
    }

}
