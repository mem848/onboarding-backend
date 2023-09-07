package com.example.onboarding.service;

import com.example.onboarding.domain.LaborTableCalculated;
import lombok.Data;

@Data
public class LaborTableService {
    //this class should take LaborTableCalculated object and calculate price for labor
    public void laborTableCalculated(LaborTableCalculated table)
    {
        table.setCost(table.getLength()* table.getWidth()* table.getPrice_per_sqft());
    }
}
