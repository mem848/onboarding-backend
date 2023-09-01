package com.example.onboarding.rest.resources.mappers;

import com.example.onboarding.domain.LaborDestination;
import com.example.onboarding.domain.LaborSource;
import org.mapstruct.Mapper;

//https://www.baeldung.com/mapstruct
@Mapper(componentModel = "spring")

public interface LaborSourceDestinationMapper {
    LaborDestination sourceToDestination(LaborSource mySource);
    LaborSource destinationToSource(LaborDestination myDestination);
}
