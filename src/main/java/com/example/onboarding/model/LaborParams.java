package com.example.onboarding.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class LaborParams {
    private float length;
    private float width;
    private float pricePerUnit;
}
