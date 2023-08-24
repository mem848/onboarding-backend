package com.example.onboarding.service;

import com.example.onboarding.domain.MaterialCalculationRequest;
import org.mapstruct.Mapper;

//https://www.baeldung.com/mapstruct
@Mapper(componentModel = "spring")

public interface LaborSourceDestinationMapper {
    MaterialCalculationRequest.LaborDestination sourceToDestination(MaterialCalculationRequest.LaborSource mySource);
    MaterialCalculationRequest.LaborSource destinationToSource(MaterialCalculationRequest.LaborDestination myDestination);
}
