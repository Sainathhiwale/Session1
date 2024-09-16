package com.examen.Session1;

import com.examen.Session1.domain.Employee;
import com.examen.Session1.services.EmployeeServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {

    @Autowired
     MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper; // convert the class object member variable into json object

    @MockBean
    private EmployeeServices employeeServices;

    @Test
    public void employeeSave()  {
        Employee employee = Employee.builder()
                .name("Mahesh")
                .department("IT")
                .address("pune")
                .build();
        try {
            given(employeeServices.save(any(Employee.class)))
                    .willAnswer(invocation -> invocation.getArgument(0));
            ResultActions response = mockMvc.perform(post("/api/v2/employee/save")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(employee))
            );
            response.andDo(print())
                    .andExpect(status().isCreated());


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
