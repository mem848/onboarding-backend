package com.example.onboarding.rest.resources.v1;
//this class represents the frontEndRequest

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialTableRequest {
    private double length;
    private double width;
    private double sqftPerGallon;
}
