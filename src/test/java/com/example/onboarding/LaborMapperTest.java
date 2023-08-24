package com.example.onboarding;

import com.example.onboarding.domain.MaterialCalculationRequest;
import com.example.onboarding.service.LaborSourceDestinationMapper;
import org.junit.Test;
import org.mapstruct.factory.Mappers;


public class LaborMapperTest {

    private LaborSourceDestinationMapper mapper = Mappers.getMapper(LaborSourceDestinationMapper.class);
        @Test
        public void givenSourceToDestination_whenMaps_thenCorrect() {
            MaterialCalculationRequest.LaborSource myLaborSource = new MaterialCalculationRequest.LaborSource(14, 12, 1.5F);
            myLaborSource.setLength(14);
            myLaborSource.setWidth(12);
            myLaborSource.setPricePerGallon(1.5F);

            MaterialCalculationRequest.LaborDestination myDestination = new MaterialCalculationRequest.LaborDestination(0,0,0,1000123);
            MaterialCalculationRequest.LaborDestination anotherDestination = mapper.sourceToDestination(myLaborSource);

            assertEquals(myLaborSource.getLength(), myDestination.getLength());
            assertEquals(myLaborSource.getWidth(), myDestination.getWidth());
            assertEquals(myLaborSource.getPricePerGallon(), myDestination.getPricePerGallon());
            System.out.println(myDestination);
        }

    private void assertEquals(float length, float length1) {
            if(length!=length1)
            {
                System.out.println("issue in mapping: "+length+" is not equal to "+length1);
            }
    }

    @Test
        public void givenDestinationToSource_whenMaps_thenCorrect() {
            MaterialCalculationRequest.LaborDestination myDestination = new MaterialCalculationRequest.LaborDestination(6,5,2,100001233);
            myDestination.setLength(6);
            myDestination.setWidth(5);
            myDestination.setPricePerGallon(2);
            MaterialCalculationRequest.LaborSource source = mapper.destinationToSource(myDestination);
            assertEquals(myDestination.getLength(), source.getLength());
            assertEquals(myDestination.getWidth(), source.getWidth());
            assertEquals(myDestination.getPricePerGallon(), source.getPricePerGallon());
            System.out.println(source);
        }
    }

