package com.example.onboarding.domain;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborCalculated {
    private float length;
    private float width;
    private float pricePerSqft;
    private int id;
    private float price;
}
