package com.example.onboarding.rest.resources.mappers;
import com.example.onboarding.domain.LaborCalculated;
import com.example.onboarding.rest.resources.v1.LaborCalculationRequest;
import com.example.onboarding.rest.resources.v1.LaborCalculationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface LaborCalculationMapper {
    LaborCalculated requestToCalculated(LaborCalculationRequest request);
    LaborCalculationResponse calculatedToResponse(LaborCalculated calculated);
}
