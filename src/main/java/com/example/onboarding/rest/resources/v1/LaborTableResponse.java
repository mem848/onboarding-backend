package com.example.onboarding.rest.resources.v1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//this class represents the frontEndResponse
//most of the information should be mapped from LaborTableCalculated object,
//I think datecreated should be made in
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborTableResponse {
    private double id;
    private Date time_stamp;
    private double length;
    private double width;
    private double price_per_sqft;
    private double cost;
}
