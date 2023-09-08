package com.example.onboarding.service;

import com.example.onboarding.domain.part1pojos.Material;
import com.example.onboarding.domain.part1pojos.MaterialCalculated;
import com.example.onboarding.rest.resources.mappers.MaterialCalculationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class MaterialCalculationService {
    @Autowired
    MaterialCalculationMapper mapper;
    public Material setPriceService (MaterialCalculated calculated)
    {
        calculated.setGallons_required(calculated.getLength()* calculated.getWidth()/ calculated.getSqftPerGallon());
        return mapper.calculatedToMaterial(calculated);
    }
}
