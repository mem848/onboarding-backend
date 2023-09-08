package com.example.onboarding.rest.resources.mappers;

import com.example.onboarding.domain.part2pojos.MaterialTableCalculated;
import com.example.onboarding.domain.entity.MaterialTable;
import com.example.onboarding.rest.resources.v1.MaterialTableRequest;
import com.example.onboarding.rest.resources.v1.MaterialTableResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialTableMapper {
    MaterialTableCalculated requestToCalculated(MaterialTableRequest request);
    MaterialTable calculatedToTable(MaterialTableCalculated calculated);
    MaterialTableResponse tableToResponse(MaterialTable table);
}
