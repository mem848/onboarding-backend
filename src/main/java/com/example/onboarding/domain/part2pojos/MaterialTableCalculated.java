package com.example.onboarding.domain.part2pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this class will receive information after mapping from MaterialTableRequest
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialTableCalculated {
    private double length;
    private double width;
    private double sqftPerGallon;
    private double gallons_required;
}
