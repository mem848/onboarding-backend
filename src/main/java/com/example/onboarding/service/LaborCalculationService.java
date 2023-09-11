package com.example.onboarding.service;

import com.example.onboarding.domain.Labor;
import com.example.onboarding.domain.LaborCalculated;
import com.example.onboarding.rest.resources.mappers.LaborCalculationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class LaborCalculationService {
    @Autowired
    LaborCalculationMapper mapper;
    public Labor setPriceService(LaborCalculated calculated)
    {
        calculated.setPrice(calculated.getLength()* calculated.getWidth()* calculated.getPricePerSqft());
        calculated.setId(1234567890);
        return mapper.calculatedToLabor(calculated);
    }

}
