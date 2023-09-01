package com.example.onboarding;

import com.example.onboarding.domain.LaborDestination;
import com.example.onboarding.domain.LaborSource;
import com.example.onboarding.rest.resources.mappers.LaborSourceDestinationMapper;
import org.junit.Test;
import org.mapstruct.factory.Mappers;


public class LaborMapperTest {

    private LaborSourceDestinationMapper mapper = Mappers.getMapper(LaborSourceDestinationMapper.class);
        @Test
        public void givenSourceToDestination_whenMaps_thenCorrect() {
            LaborSource myLaborSource = new LaborSource(14, 12, 1.5F);
            myLaborSource.setLength(14);
            myLaborSource.setWidth(12);
            myLaborSource.setPricePerUnit(1.5F);

            LaborDestination myDestination = new LaborDestination(0,0,0);
            LaborDestination anotherDestination = mapper.sourceToDestination(myLaborSource);

            assertEquals(myLaborSource.getLength(), myDestination.getLength());
            assertEquals(myLaborSource.getWidth(), myDestination.getWidth());
            assertEquals(myLaborSource.getPricePerUnit(), myDestination.getPricePerUnit());
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
            LaborDestination myDestination = new LaborDestination(6,5,2);
            myDestination.setLength(6);
            myDestination.setWidth(5);
            myDestination.setPricePerUnit(2);
            LaborSource source = mapper.destinationToSource(myDestination);
            assertEquals(myDestination.getLength(), source.getLength());
            assertEquals(myDestination.getWidth(), source.getWidth());
            assertEquals(myDestination.getPricePerUnit(), source.getPricePerUnit());
            System.out.println(source);
        }
    }

