package com.example.onboarding.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborCalculation {
    private float length;
    private float width;
    private float sqftPerGallon;

    public float myCalcuation() {
        return this.getLength()*this.getWidth()/this.getSqftPerGallon();
    }

}

