package com.example.onboarding.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialCalculated {
    private float length;
    private float width;
    private float sqftPerGallon;
    private float gallons_required;
}
