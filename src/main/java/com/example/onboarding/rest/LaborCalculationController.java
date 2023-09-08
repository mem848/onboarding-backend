package com.example.onboarding.rest;

import com.example.onboarding.domain.part1pojos.Labor;
import com.example.onboarding.domain.part1pojos.LaborCalculated;
import com.example.onboarding.rest.resources.mappers.LaborCalculationMapper;
import com.example.onboarding.rest.resources.v1.LaborCalculationRequest;
import com.example.onboarding.rest.resources.v1.LaborCalculationResponse;
import com.example.onboarding.service.LaborCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    LaborCalculationMapper mapper;
    @Autowired
    LaborCalculationService service;
    @PostMapping(value = "/Labor/Calculation")
    public LaborCalculationResponse laborCalculationController(@RequestBody LaborCalculationRequest params)
    {
        //map from request to laborCalculated here
        LaborCalculated calculated = mapper.requestToCalculated(params);
        System.out.println(calculated);
        //do math/set price for labor based on params
        Labor labor = service.setPriceService(calculated);
        //controller handles mapping back to response

        //change from labor to response
        return mapper.laborToResponse(labor);
    }
}
