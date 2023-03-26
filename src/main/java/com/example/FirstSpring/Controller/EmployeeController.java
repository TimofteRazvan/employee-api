package com.example.FirstSpring.Controller;

import com.example.FirstSpring.Entity.Employee;
import com.example.FirstSpring.Entity.EmployeeDTO;
import com.example.FirstSpring.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ArrayList<Integer> findAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        ArrayList<Integer> idList = new ArrayList<>();
        for (Employee employee : employeeList) {
            idList.add(employee.getId());
        }
        return idList;
    }

    //@RequestMapping(value = "/employees", method = RequestMethod.GET)
    @GetMapping("/employees-details")
    public List<Employee> findAllEmployeesDetails() {
        return employeeService.getAllEmployees();
    }

    //@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    @GetMapping("/employees/{id}")
    public Employee findEmployee(@PathVariable int id) {
        try {
            return employeeService.getEmployee(id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //@RequestMapping(value = "/employees", method = RequestMethod.POST)
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    //@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        try {
            employeeService.updateEmployee(id, employee);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        try {
            employeeService.deleteEmployee(id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/employees/filter/age/{age}")
    public List<Employee> findEmployeeByAge(@PathVariable int age) {
        return employeeService.findEmployeeByAge(age);
    }

    @GetMapping("/employees/compare/age")
    public List<EmployeeDTO> getComparison() {
        return employeeService.getComparison();
    }
}
