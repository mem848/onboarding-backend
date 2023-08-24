package com.example.onboarding.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class LaborParamsCalculation {
    private float length;
    private float width;
    private float sqftPerGallon;
}
