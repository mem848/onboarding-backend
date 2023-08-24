package com.example.onboarding.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class MaterialCalculationRequest {
    private float length;
    private float width;
    private float sqftPerGallon;
    public float myCalcuation() {
        return this.getLength()*this.getWidth()/this.getSqftPerGallon();
    }
}
