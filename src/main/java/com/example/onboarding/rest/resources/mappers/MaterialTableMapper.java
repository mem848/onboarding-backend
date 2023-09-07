package com.example.onboarding.rest.resources.mappers;

import com.example.onboarding.domain.MaterialCalculated;
import com.example.onboarding.domain.MaterialTableCalculated;
import com.example.onboarding.domain.entity.MaterialTable;
import com.example.onboarding.rest.resources.v1.MaterialTableRequest;
import com.example.onboarding.rest.resources.v1.MaterialTableResponse;

public interface MaterialTableMapper {
    MaterialTableCalculated requestToCalculated(MaterialTableRequest request);
    MaterialTable calculatedToTable(MaterialTableCalculated calculated);
    MaterialTableResponse tableToResponse(MaterialTable table);
}
