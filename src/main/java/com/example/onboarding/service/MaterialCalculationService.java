package com.example.onboarding.service;

import com.example.onboarding.domain.MaterialCalculated;
import com.example.onboarding.rest.resources.v1.MaterialCalculationRequest;
import com.example.onboarding.rest.resources.v1.MaterialCalculationResponse;
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
    public void materialCalculationService (MaterialCalculated calculated)
    {
        calculated.setGallons_required(calculated.getLength()* calculated.getWidth()/ calculated.getSqftPerGallon());
    }
}
