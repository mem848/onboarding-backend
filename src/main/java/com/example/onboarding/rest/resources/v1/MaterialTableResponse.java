package com.example.onboarding.rest.resources.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//this class will have its data mapped from MaterialTable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialTableResponse {
    private double id;
    private Date time_stamp;
    private double length;
    private double width;
    private double sqftPerGallon;
    private double gallons_required;
}
