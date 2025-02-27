package com.spring22.service;

// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring22.dao.Employee;
// import com.spring22.dao.EmployeeDao;
import com.spring22.dao.EmployeeJPAInterface;

@Service
public class EmployeeService {

    @Autowired
    EmployeeJPAInterface empJPA;
    public List<Employee> getAllEmployeeDetails(){
        return empJPA.findAll();
    }

    public Optional<Employee> getEmployeeDetails(int id){
        return empJPA.findById(id);
    }

    public Employee addEmployeeDetails(Employee emp){
        Employee savedEmp = empJPA.save(emp);
        return savedEmp;
    }

    public Employee updateEmpDetails(Employee emp){
        Optional<Employee> existedEmp = empJPA.findById(emp.getId());
        return empJPA.save(emp);
    }


    public String deleteEmp(int id){
        Optional<Employee> existedEmployee = empJPA.findById(id);
        empJPA.deleteById(id);
        return "Employee Deleted Successfully";
    }

    public List<Employee> findEmployeeByName(String name){
        return empJPA.findByName(name);
    }

    public List<Employee> getEmployeeBySpecificBranchName(String branch){
        return empJPA.findBySpecificBranchName(branch);
    }
}
