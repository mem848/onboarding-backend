package com.example.onboarding.service;

import com.example.onboarding.domain.MaterialTableCalculated;
import org.springframework.stereotype.Service;

@Service
public class MaterialTableService {
    //takes MaterialTableCalculated object and sets cost for materials
    public void setCost(MaterialTableCalculated calculated)
    {
        calculated.setCost(calculated.getLength()* calculated.getWidth()/ calculated.getSqft_per_gallon());
    }
}
