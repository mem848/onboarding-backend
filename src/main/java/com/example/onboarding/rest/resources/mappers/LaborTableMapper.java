package com.example.onboarding.rest.resources.mappers;

import com.example.onboarding.domain.entity.LaborTable;
import com.example.onboarding.domain.LaborTableCalculated;
import com.example.onboarding.rest.resources.v1.LaborTableRequest;
import com.example.onboarding.rest.resources.v1.LaborTableResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
//this will map values from LaborTableRequest to LaborTableCalculated (my own object), and from LTC to LaborTableResponse
public interface LaborTableMapper {
    LaborTableCalculated requestToCalculated (LaborTableRequest request);

    LaborTable calculatedToTable(LaborTableCalculated calculated);

    LaborTableResponse tableToResponse(LaborTable table);
}
