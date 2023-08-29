package com.example.onboarding;

import com.example.onboarding.domain.LaborCalculationRequest;
import com.example.onboarding.domain.LaborCalculationResponse;
import com.example.onboarding.domain.MaterialCalculationRequest;
import com.example.onboarding.domain.MaterialCalculationResponse;
import com.example.onboarding.rest.LaborCalculationController;
import com.example.onboarding.rest.MaterialCalculationController;
import com.example.onboarding.service.LaborCalculationService;
import com.example.onboarding.service.MaterialCalculationService;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
import org.junit.jupiter.api.Test; //trying this import rather than org.junit.Test
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest({LaborCalculationController.class, MaterialCalculationController.class})
//@SpringBootTest - can only have @SpringBootTest or @WebMvcTest not both
@AutoConfigureMockMvc

public class CalculationTest {
    //I think use @Mock for boilerplate object, and @MockBean for controller tests
    //use @injectedMocks for service methods
    @Autowired
    private MockMvc mvc;
    @Mock
    private LaborCalculationRequest mockLaborRequest;
    @Mock
    private LaborCalculationResponse mockLaborResponse;

    @Mock
    private LaborCalculationService mockLaborService;

    @Mock
    private MaterialCalculationRequest mockMaterialRequest;
    @Mock
    private MaterialCalculationResponse mockMaterialResponse;

    @Mock
    private MaterialCalculationService mockMaterialService;

    private ObjectMapper objectMapper;
    @MockBean
    private LaborCalculationController mockController;
    //https://stackoverflow.com/questions/51346781/how-to-test-post-method-in-spring-boot-using-mockito-and-junit

    @BeforeEach //initialize all variables before test
    void setUp()
    {
        this.objectMapper = new ObjectMapper();

    }
    @Test
    public void laborControllerTest () throws Exception
    {//test services, controllers, maybe mappers
        System.out.println("hello world");
        //https://stackoverflow.com/questions/9186604/mockito-exception-when-requires-an-argument-which-has-to-be-a-method-call-on
        given(mockLaborService.laborCalculationService(mockLaborRequest)).willReturn(mockLaborResponse);
        //mvc performs controller
        this.mvc.perform(post("/LaborCalculationController")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(mockLaborRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void materialControllerTest() throws Exception
    {
        System.out.println("Howdy Partner");
        given(mockMaterialService.materialCalculationService(mockMaterialRequest)).willReturn(mockMaterialResponse);
        //mvc performs controller
        this.mvc.perform(post("/MaterialCalculationController")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(mockMaterialRequest)))
                .andExpect(status().isOk());

    }
}
