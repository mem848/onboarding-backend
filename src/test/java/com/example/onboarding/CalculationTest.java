package com.example.onboarding;

import com.example.onboarding.domain.part1pojos.Labor;
import com.example.onboarding.domain.part1pojos.LaborCalculated;
import com.example.onboarding.domain.part1pojos.Material;
import com.example.onboarding.domain.part1pojos.MaterialCalculated;
import com.example.onboarding.rest.resources.mappers.LaborCalculationMapper;
import com.example.onboarding.rest.resources.mappers.MaterialCalculationMapper;
import com.example.onboarding.rest.resources.v1.LaborCalculationRequest;
import com.example.onboarding.rest.resources.v1.LaborCalculationResponse;
import com.example.onboarding.rest.resources.v1.MaterialCalculationRequest;
import com.example.onboarding.rest.resources.v1.MaterialCalculationResponse;

import com.example.onboarding.rest.LaborCalculationController;
import com.example.onboarding.service.LaborCalculationService;
import com.example.onboarding.service.MaterialCalculationService;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
import org.junit.jupiter.api.Test; //trying this import rather than org.junit.Test
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
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
    @Mock
    private LaborCalculationRequest mockLaborRequest;
    @Mock
    private LaborCalculated mockLaborCalculated;
    @Mock
    private Labor mockLabor;
    @Mock
    private LaborCalculationResponse mockLaborResponse;

    @MockBean
    private LaborCalculationMapper mockLaborMapper;
    @MockBean
    private LaborCalculationService mockLaborService;


    @Mock
    private MaterialCalculationRequest mockMaterialRequest;
    @Mock
    private MaterialCalculated mockMaterialCalculated;
    @Mock
    private Material mockMaterial;
    @Mock
    private MaterialCalculationResponse mockMaterialResponse;

    @MockBean
    private MaterialCalculationMapper mockMaterialMapper;
    @MockBean
    private MaterialCalculationService mockMaterialService;

    private ObjectMapper objectMapper;
    @MockBean
    private LaborCalculationController mockController;

    public CalculationTest() {
    }
    //https://stackoverflow.com/questions/51346781/how-to-test-post-method-in-spring-boot-using-mockito-and-junit

    @BeforeEach //initialize all variables before test
    void setUp()
    {
        this.objectMapper = new ObjectMapper();
        //this.mockMaterialService = new MaterialCalculationService();

    }

    @Test
    public void laborControllerTest () throws Exception
    {//test services, controllers, maybe mappers

        given(mockLaborMapper.requestToCalculated(mockLaborRequest)).willReturn(mockLaborCalculated); //request to calculated
        given(mockLaborService.setPriceService(mockLaborCalculated)).willReturn(mockLabor); //calc to labor
        given(mockLaborMapper.laborToResponse(mockLabor)).willReturn(mockLaborResponse); //labor to response
        //testing mapping and service

        this.mvc.perform(post("/Labor/Calculation")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(mockLaborRequest)))
                .andExpect(status().isOk());
        //these few lines test that controller works

        //check line 112 in ProfileControllerTest
        //https://github.com/sherwin-williams-co/TAG-Profile-Service/blob/develop/service/src/test/java/com/sw/service/rest/ProfileControllerTest.java#L112
        //https://stackoverflow.com/questions/9186604/mockito-exception-when-requires-an-argument-which-has-to-be-a-method-call-on
    }

    @Test
    public void materialControllerTest() throws Exception
    {
        given(mockMaterialMapper.requestToCalculated(mockMaterialRequest)).willReturn(mockMaterialCalculated); //request to calculated
        given(mockMaterialService.setPriceService(mockMaterialCalculated)).willReturn(mockMaterial); //calc to labor
        given(mockMaterialMapper.materialToResponse(mockMaterial)).willReturn(mockMaterialResponse); //labor to response

        this.mvc.perform(post("/Material/Calculation")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(mockMaterialRequest)))
                .andExpect(status().isOk());

    }
}
