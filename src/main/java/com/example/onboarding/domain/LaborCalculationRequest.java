package com.example.onboarding.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborCalculationRequest {
    private float length;
    private float width;
    private float pricePerSqft;

}
