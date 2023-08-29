package com.example.onboarding.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborCalculationResponse {
    private int id;
    private float price;

}
