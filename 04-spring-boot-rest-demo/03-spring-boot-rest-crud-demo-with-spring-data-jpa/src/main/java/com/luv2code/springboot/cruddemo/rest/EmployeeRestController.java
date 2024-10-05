package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found -" + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmploye(@RequestBody Employee emp){
        emp.setId(0); //id veritabanına eklendiginde oto olusturulcak
        // id 0 verildiginde bir guncelleme degil kayit islemi old anlar
        Employee dbEmployee = employeeService.save(emp);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        Employee dbEmp = employeeService.save(emp);
        return dbEmp;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found -" + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee deleted id: " + employeeId;
    }
}
