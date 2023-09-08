package com.example.onboarding.domain.part2pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

//this is my object that recieves it's information from mapping from LaborTableRequest
//this will feed LaborTable (which will be put into h2 database)
public class LaborTableCalculated {
    private double length;
    private double width;
    private double pricePerSqft;
    private double cost;

}