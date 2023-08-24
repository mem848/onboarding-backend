package com.example.onboarding.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborSource {
    private float length;
    private float width;
    private float pricePerUnit;
}
