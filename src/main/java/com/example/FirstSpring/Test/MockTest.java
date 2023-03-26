package com.example.FirstSpring.Test;

import com.example.FirstSpring.Entity.Employee;
import com.example.FirstSpring.Entity.Spouse;
import com.example.FirstSpring.Repository.EmployeeRepository;
import com.example.FirstSpring.Repository.SpouseRepository;
import com.example.FirstSpring.Service.EmployeeService;
import com.example.FirstSpring.Service.SpouseService;
//import org.testng.annotations.Test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    @Mock
    private SpouseRepository spouseRepository;
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private SpouseService spouseService;
    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testFindSpouseByAge() {
        int age = 26;
        Spouse spouse1 = new Spouse("28", "0770805482", 28);
        Spouse spouse2 = new Spouse("18", "0770805482", 18);
        Spouse spouse3 = new Spouse("31", "0770805482", 31);
        List<Spouse> spouseList = new ArrayList<>();
        spouseList.add(spouse3); spouseList.add(spouse2); spouseList.add(spouse1);
        when(spouseRepository.findAll()).thenReturn(spouseList);
        List<Spouse> correctList = new ArrayList<>();
        correctList.add(spouse1); correctList.add(spouse3);
        Assert.assertArrayEquals(correctList.toArray(), spouseService.findSpouseByAgeImpl(age).toArray());
    }

    @Test
    public void testFindEmployeeByAge() {
        int age = 26;
        Employee employee1 = new Employee("28", "cluj", 28);
        Employee employee2 = new Employee("18", "cluj", 18);
        Employee employee3 = new Employee("31", "cluj", 31);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee3); employeeList.add(employee2); employeeList.add(employee1);
        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> correctList = new ArrayList<>();
        correctList.add(employee1); correctList.add(employee3);
        Assert.assertArrayEquals(correctList.toArray(), employeeService.findEmployeeByAgeImpl(age).toArray());
    }
}
