package com.spring22.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring22.dao.Employee;
import com.spring22.service.EmployeeService;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService svc;

    @GetMapping("/getAllEmpDetails")
    public List<Employee> getAllEmployeeDetails(){
        return svc.getAllEmployeeDetails();
    }

    @GetMapping("/getEmpDetails/{id}")
    public Optional<Employee> getEmployeeDetails(@PathVariable int id){
        return svc.getEmployeeDetails(id);
    }

    @PostMapping("/addEmp")
    public Employee addEmployeeDetails(@RequestBody Employee emp ){
        Employee savedEmp = svc.addEmployeeDetails(emp);
        return savedEmp;
    }

    @PutMapping("/updateEmp")
    public Employee updateEmpDetails(@RequestBody Employee emp){
        return svc.updateEmpDetails(emp);
    }

    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable int id){
        return svc.deleteEmp(id);
    }


    @GetMapping("/getByName/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return svc.findEmployeeByName(name);
    }

    // @GetMapping("/getEmployeeBySpecificBranchName/{branch}")
    // public Employee getEmployeeBySpecificBranchName(@PathVariable String branch){
    //     return svc.getEmployeeBySpecificBranchName(branch);
    // }
}
