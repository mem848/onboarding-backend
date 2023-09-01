package com.example.onboarding;

import com.example.onboarding.domain.MaterialCalculated;
import com.example.onboarding.rest.resources.mappers.LaborCalculationMapper;
import com.example.onboarding.rest.resources.mappers.LaborSourceDestinationMapper;
import com.example.onboarding.rest.resources.mappers.MaterialCalculationMapper;
import com.example.onboarding.rest.resources.v1.LaborCalculationRequest;
import com.example.onboarding.rest.resources.v1.LaborCalculationResponse;
import com.example.onboarding.rest.resources.v1.MaterialCalculationRequest;
import com.example.onboarding.rest.resources.v1.MaterialCalculationResponse;

import com.example.onboarding.rest.LaborCalculationController;
import com.example.onboarding.rest.MaterialCalculationController;
import com.example.onboarding.service.LaborCalculationService;
import com.example.onboarding.service.MaterialCalculationService;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
import org.junit.jupiter.api.Test; //trying this import rather than org.junit.Test
import org.junit.jupiter.api.BeforeEach;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest({LaborCalculationController.class, MaterialCalculationController.class})
@SpringBootTest //- can only have @SpringBootTest or @WebMvcTest not both
@AutoConfigureMockMvc

public class CalculationTest {
    //I think use @Mock for boilerplate object, and @MockBean for controller tests
    //use @injectedMocks for service methods
    @Autowired
    private MockMvc mvc;

    @Autowired
    private MaterialCalculationMapper mockMaterialMapper;
    @Mock
    private LaborCalculationRequest mockLaborRequest;
    @Mock
    private LaborCalculationResponse mockLaborResponse;

    @Mock
    private LaborCalculationService mockLaborService;

    @Mock
    private MaterialCalculationRequest mockMaterialRequest;
    private MaterialCalculationResponse materialResponse;

    private MaterialCalculationService materialService;

    private ObjectMapper objectMapper;
    @MockBean
    private LaborCalculationController mockController;
    //https://stackoverflow.com/questions/51346781/how-to-test-post-method-in-spring-boot-using-mockito-and-junit

    @BeforeEach //initialize all variables before test
    void setUp()
    {
        this.objectMapper = new ObjectMapper();
        this.materialService = new MaterialCalculationService();

    }
    @Test
    public void laborControllerTest () throws Exception
    {//test services, controllers, maybe mappers
        System.out.println("hello world");
        //mvc performs controller
        this.mvc.perform(post("/LaborCalculationController")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(mockLaborRequest)))
                .andExpect(status().isOk());

        LaborCalculationRequest testRequest = new LaborCalculationRequest(14F, 12F, 2.5F);
        LaborCalculationResponse testResponse = new LaborCalculationResponse(1234567890, 420);
        //https://stackoverflow.com/questions/9186604/mockito-exception-when-requires-an-argument-which-has-to-be-a-method-call-on
        //testing results of controller
        given(mockController.onboarding(testRequest)).willReturn(testResponse);
    }

    @Test
    public void materialControllerTest() throws Exception
    {
        System.out.println("Howdy Partner");
        //given(mockMaterialService.materialCalculationService(mockMaterialRequest)).willReturn(mockMaterialResponse);
        //mvc performs controller
        this.mvc.perform(post("/MaterialCalculationController")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(mockMaterialRequest)))
                .andExpect(status().isOk());

        MaterialCalculationRequest testRequest = new MaterialCalculationRequest(14, 12, 300);
        MaterialCalculated testCalculated = new MaterialCalculated(14, 12, 300, 0);
        MaterialCalculationResponse testResponse = new MaterialCalculationResponse(0.56F);

        MaterialCalculated calculated = this.mockMaterialMapper.requestToCalculated(testRequest);
        System.out.println(calculated+": "+testCalculated+" ");

        this.materialService.materialCalculationService(calculated);
        testCalculated.setGallons_required(0.56F);
        System.out.println(calculated.getGallons_required()+": "+testCalculated.getGallons_required());

        this.materialResponse = this.mockMaterialMapper.calculatedToResponse(calculated);
        System.out.println(materialResponse+": "+testResponse);
    }
}
