package com.example.onboarding.service;

import com.example.onboarding.domain.part2pojos.LaborTableCalculated;
import org.springframework.stereotype.Service;

@Service
public class LaborTableService {
    //this class should take LaborTableCalculated object and calculate price for labor
    public void setCost(LaborTableCalculated table)
    {
        table.setCost(table.getLength()* table.getWidth()* table.getPricePerSqft());
    }
}
