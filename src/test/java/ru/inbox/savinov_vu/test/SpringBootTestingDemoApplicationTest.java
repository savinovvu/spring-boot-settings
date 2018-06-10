package ru.inbox.savinov_vu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class SpringBootTestingDemoApplicationTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void test_getMaxSalariedEmployee(){
        Employee emp = employeeService.getMaxSalariedEmployee();
        assertNotNull(emp);
        assertEquals(2, emp.getId().intValue());
        assertEquals("B", emp.getName());
        assertEquals(75000, emp.getSalary().intValue());

    }

}