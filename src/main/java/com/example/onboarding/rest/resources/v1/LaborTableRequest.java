package com.example.onboarding.rest.resources.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//this class represents the frontEndRequest
//the id will be generated from response object, and cost will be calculated from LaborTableCalculated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborTableRequest {
    //private double id;
    //private Date time_stamp;
    private double length;
    private double width;
    private double price_per_sqft;
    //private double cost;
}
