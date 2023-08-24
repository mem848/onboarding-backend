package com.example.onboarding.service;

import com.example.onboarding.domain.LaborDestination;
import com.example.onboarding.domain.LaborSource;
import com.example.onboarding.domain.MaterialCalculationRequest;
import org.mapstruct.Mapper;

//https://www.baeldung.com/mapstruct
@Mapper(componentModel = "spring")

public interface LaborSourceDestinationMapper {
    LaborDestination sourceToDestination(LaborSource mySource);
    LaborSource destinationToSource(LaborDestination myDestination);
}
