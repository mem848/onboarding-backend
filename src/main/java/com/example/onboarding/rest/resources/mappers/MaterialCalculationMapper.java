package com.example.onboarding.rest.resources.mappers;

import com.example.onboarding.domain.part1pojos.Material;
import com.example.onboarding.domain.part1pojos.MaterialCalculated;
import com.example.onboarding.rest.resources.v1.MaterialCalculationRequest;
import com.example.onboarding.rest.resources.v1.MaterialCalculationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialCalculationMapper {
    MaterialCalculated requestToCalculated(MaterialCalculationRequest request);

    Material calculatedToMaterial(MaterialCalculated calculated);
    MaterialCalculationResponse materialToResponse(Material material);
}
