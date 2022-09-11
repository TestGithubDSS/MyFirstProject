package com.mindtree.Employee;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.mindtree.Employee.entity.Employee;
import com.mindtree.Employee.repository.EmployeeRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc


class EmployeeApplicationTests {

	@Autowired
    private MockMvc mockMvc;

@Autowired
    private EmployeeRepository employeeRepository;

@BeforeEach
    void setup(){
        employeeRepository.deleteAll();
    }

@Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception{
        // given - precondition or setup
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee("Souvik Roy",33000,"Male",34,3));
        listOfEmployees.add(new Employee("Krishna Roy",35000,"Female",44,3));
        employeeRepository.saveAll(listOfEmployees);
        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(get("http://localhost:9092/employee"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfEmployees.size())));

    }
}
