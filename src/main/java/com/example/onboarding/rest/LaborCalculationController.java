package com.example.onboarding.rest;

import com.example.onboarding.domain.LaborCalculated;
import com.example.onboarding.rest.resources.mappers.LaborCalculationMapper;
import com.example.onboarding.rest.resources.v1.LaborCalculationRequest;
import com.example.onboarding.rest.resources.v1.LaborCalculationResponse;
import com.example.onboarding.service.LaborCalculationService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.mapstruct.Mapper;
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
    @PostMapping(value = "/LaborCalculationController")
    public LaborCalculationResponse onboarding(@RequestBody LaborCalculationRequest params)
    {
        //map from request to laborCalculated here
        LaborCalculated calculated = mapper.requestToCalculated(params);
        //do math/set price for labor based on params
        service.laborCalculationService(calculated);
        //controller handles mapping back to response
        return mapper.calculatedToResponse(calculated);
    }
}
