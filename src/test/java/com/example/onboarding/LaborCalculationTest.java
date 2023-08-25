package com.example.onboarding;

import com.example.onboarding.domain.LaborCalculationRequest;
import com.example.onboarding.rest.LaborCalculationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LaborCalculationController.class)
@WithMockUser(username = "mockuser")
public class LaborCalculationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private LaborCalculationController mockController;
    //https://stackoverflow.com/questions/51346781/how-to-test-post-method-in-spring-boot-using-mockito-and-junit
    public void laborControllerTest () throws Exception
    {
        //for testing, call funcions, see if what is returned is what is expected
        System.out.println("hello world");
        LaborCalculationRequest myRequest = new LaborCalculationRequest(1,2,3);
        this.mvc.perform(post("/LaborCalculationController"))
                //.contentType(MediaType.APPLICATION_JSON_VALUE)
                //.content(toJson(myRequest))
                .andExpect(status().isOk());

    }
}
