package com.example.onboarding.service;

import com.example.onboarding.domain.part2pojos.MaterialTableCalculated;
import org.springframework.stereotype.Service;

@Service
public class MaterialTableService {
    //takes MaterialTableCalculated object and sets cost for materials
    public void setGallonsRequired(MaterialTableCalculated calculated)
    {
        calculated.setGallons_required(calculated.getLength()* calculated.getWidth()/ calculated.getSqftPerGallon());
    }
}
