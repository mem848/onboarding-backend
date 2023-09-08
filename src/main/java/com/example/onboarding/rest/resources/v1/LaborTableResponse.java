package com.example.onboarding.rest.resources.v1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborTableResponse {
    private double id;
    private Date time_stamp;
    private double length;
    private double width;
    private double pricePerSqft;
    private double cost;
}
