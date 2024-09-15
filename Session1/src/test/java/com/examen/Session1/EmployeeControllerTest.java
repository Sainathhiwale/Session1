package com.examen.Session1;

import com.examen.Session1.domain.Employee;
import com.examen.Session1.services.EmployeeServices;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;

@WebMvcTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServices employeeServices;

    @Test
    public void employeeSave(){
        Employee employee = Employee.builder()
                .name("Mahesh")
                .department("IT")
                .address("pune")
                .build();
        given(employeeServices.save(any(Employee.class)))
                .willAnswer(InvocationOnMock::getArguments);

    }
}
